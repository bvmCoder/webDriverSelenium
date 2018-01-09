const _ = require("lodash");
const Path = require("path");
const fs = require("fs");
const less = require("less");
const Promise = require("bluebird");
const gutil = require("gulp-util");
const globalSelectors = require("./global-selectors");

const getDirectoryTree = require("./directory-tree");
const {notOnlyImportStatement} = require("./structure-validators");

const processingTasks = [];

const errors = [];
const warnings = [];

let addError = null;
let addWarning = null;

const MATCH_SUCCESS = 2;

const parseLessFile = (srcDir, filePath) => {
    return new Promise((resolve) => {
        const options = {
            filename: filePath,
            rootpath: srcDir
        };
        const content = fs.readFileSync(filePath, "utf8");
        less.parse(content, options, (e, tree) => {
            if (!tree) {
                addWarning(filePath, `Parse failed`);
            }
            resolve(tree);
        });
    });
};


const processMainLess = (srcDir) => {
    const mainLessFilePath = Path.join(srcDir, "main.less");
    const validateMainLess = (tree) => {
        if (!tree) {
            return;
        }
        if (notOnlyImportStatement(tree)) {
            addError(mainLessFilePath, `Can only has @import statements`);
        }
    };
    processingTasks.push(parseLessFile(srcDir, mainLessFilePath).then(validateMainLess));
};

const getWidgetFiles = (widgetDir) => {
    const jsFiles = [];
    const lessFiles = [];

    const walkTree = (node) => {
        if (node.type === "file") {
            if (node.extension === ".less") {
                lessFiles.push(node);
            }
            if (node.extension === ".js") {
                jsFiles.push(node);
            }
        } else if (node.type === "directory" && node.children && node.children.length > 0) {
            _.forEach(node.children, (value) => {
                walkTree(value);
            });
        }
    };

    walkTree(widgetDir);
    return {jsFiles, lessFiles};
};

/* eslint "no-constant-condition": 0 */
const collectClassNames = (filePath) => {
    const content = fs.readFileSync(filePath, "utf8");
    if (content.indexOf(" React") < 0) {
        return [];
    }

    let classNames = [];
    const classNameRegex = /\s+className\s*=\s*"([\w\s-]+)"/mg;
    while (true) {
        const matches = classNameRegex.exec(content);
        if (!matches) {
            break;
        }
        if (matches && matches.length === MATCH_SUCCESS) {
            let names = matches[1].split(" ");
            names = _.filter(names, (value) => {
                return (!_.isNil(value) && value.trim().length > 0);
            });
            classNames = classNames.concat(names);
        }
    }
    return classNames;
};

const ensureEachComponentHasLessFile = (jsFiles, lessFiles) => {
    const lessFileMap = {};
    lessFiles.forEach((value) => {
        lessFileMap[value.path] = true;
    });

    jsFiles.forEach((value) => {
        const classNames = collectClassNames(value.path);
        if (classNames.length > 0) {
            const lessPath = value.path.replace(/(.js)$/, ".less");
            if (!lessFileMap[lessPath]) {
                addError(value.path, `a Less file that has the same name is required.`);
            } else {
                const lessContent = fs.readFileSync(lessPath, "utf8");
                classNames.forEach((name) => {
                    if (globalSelectors.indexOf(name) > 0) {
                        return;
                    }
                    if (lessContent.indexOf(name) < 0) {
                        addWarning(value.path, `className "${name}" not found in ${lessPath}`);
                    }
                });
            }
        }
    });
};

const processWidgetFiles = (widgetDir) => {
    const {jsFiles, lessFiles} = getWidgetFiles(widgetDir);
    ensureEachComponentHasLessFile(jsFiles, lessFiles);
};

const checkLessStructure = (projectDir) => {
    const srcDir = Path.join(projectDir, "src");
    gutil.log(gutil.colors.green(`Start to analyze the project ${projectDir}`));
    addError = (file, msg) => {
        file = file.replace(projectDir, "");
        errors.push({file, msg});
    };
    addWarning = (file, msg) => {
        file = file.replace(projectDir, "");
        warnings.push({file, msg});
    };
    processMainLess(srcDir);
    const fileTree = getDirectoryTree(srcDir);
    fileTree.children.forEach((item) => {
        if (item.type !== "directory") {
            return;
        }
        processWidgetFiles(item);
    });

    return Promise.all(processingTasks).then(() => {
        errors.forEach((value) => {
            gutil.log(gutil.colors.cyan(value.file), ":", gutil.colors.red(value.msg));
        });
        warnings.forEach((value) => {
            gutil.log(gutil.colors.cyan(value.file), ":", gutil.colors.yellow(value.msg));
        });

        if (errors.length > 0) {
            throw new gutil.PluginError("lint", "Less file failed to pass check.");
        }
    });
};

module.exports = checkLessStructure;