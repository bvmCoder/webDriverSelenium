const _ = require("lodash");

const getCount = (tree, type) => {
    const result = _.countBy(tree.rules, "type");
    const count = result[type];
    return count ? count : 0;
};

const notOnlyImportStatement = (tree) => {
    const result = _.countBy(tree.rules, "type");
    for (const type in result) {
        if (type !== "Import") {
            return true;
        }
    }
    return false;
};

const getRootSelectorCount = (tree) => {
    return getCount(tree, "Ruleset");
};

const getRootMixinCallCount = (tree) => {
    return getCount(tree, "MixinCall");
};

const getRootMixinCount = (tree) => {
    return getCount(tree, "MixinDefinition");
};

const getSelectorCountInRootMixin = (node) => {
    const rootMixin = _.find(node.rules, ["type", "MixinDefinition"]);
    if (!rootMixin) {
        return 0;
    }

    return getRootSelectorCount(rootMixin) + getRootMixinCallCount(rootMixin);
};

module.exports = {
    getRootSelectorCount,
    getRootMixinCallCount,
    getRootMixinCount,
    getSelectorCountInRootMixin,
    notOnlyImportStatement
};