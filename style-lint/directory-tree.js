const Fs = require("fs");
const Path = require("path");

/* eslint "max-statements": 0 */
const getDirectoryTree = (path, extensions) => {
    const name = Path.basename(path);
    const item = { path, name };
    let stats;

    try {
        stats = Fs.statSync(path);
    } catch (e) {
        return null;
    }

    if (stats.isFile()) {
        const ext = Path.extname(path).toLowerCase();
        if (extensions && extensions.length && extensions.indexOf(ext) < 0) {
            return null;
        }
        item.type = "file"; 
        item.extension = ext;
    } else if (stats.isDirectory()) {
        try {
            item.children = Fs.readdirSync(path)
				.map((child) => getDirectoryTree(Path.join(path, child), extensions))
				.filter((e) => !!e);
            item.type = "directory";
        } catch (ex) {
            if (ex.code === "EACCES") {
                //User does not have permissions, ignore directory
                return null;
            }
        }
    } else {
        return null; // Or set item.size = 0 for devices, FIFO and sockets ?
    }
    return item;
};

module.exports = getDirectoryTree;