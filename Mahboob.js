<div>
    Counted Value : <span id="counter">{state.counter}</span>
</div>
<button id="inc"> + </button>
<button id="dec"> - </button>
<script>
	var count = {
	    counter: 3,
	    id: new date()
	}
	document.querySelector("#inc").onclick = () => dispatch('INC')
	document.querySelector("#dec").onclick = () => dispatch('DEC')
	function dispatch(action) {
		const newState = reducer(state, action)

		if ( newState !== state) {
			state = newState
		}

		listeners.forEach(listener => listener())
	}

	const listeners = []

	function subscribe(callBack) {
		listeners.push(callBack)
	}
	function reducer(state = count, action) {
		switch (action) {
			case 'INC': 
				return {
					...state,
					counter : state.counter + 1
				}
			case 'DEC': 
				return {
					...state,
					counter : state.counter - 1
				}
			default:
				return state
		}
	}
	subscribe(updateView)
	function updateView() {
		document.querySelector("#counter").innerText = state.counter
	}

</script>
const _ = require("lodash");

const bestPracticeRules = require("./rules/best-practices");
const errorRules = require("./rules/errors");
const es6Rules = require("./rules/es6");
const filenameRules = require("./rules/filenames");
const nodeRules = require("./rules/node");
const reactRules = require("./rules/react");
const strictRules = require("./rules/strict");
const styleRules = require("./rules/style");
const variableRules = require("./rules/variables");

const allRules = _.assign(bestPracticeRules,
    errorRules,
    es6Rules,
    filenameRules,
    reactRules,
    strictRules,
    styleRules,
    variableRules,
    nodeRules);

module.exports = {
    "env": {
        "browser": true,
        "node": true,
        "es6": true
    },
    "ecmaFeatures": {
        "modules": true,
        "jsx": true
    },
    "parser": "babel-eslint",
    "plugins": [
        "filenames",
        "react"
    ],
    "globals": {
        "__SERVER_RENDERING__": false
    },
    "rules": allRules
};
