var path = require('path');
var express = require('express');
var colors = require('colors/safe');
var api = require('./public/api'); // ./demo dir not included in mdc-neptune package!
var neptuneConf = require('./package.json');

var port = process.env.PORT || 3000;
var app = express();

colors.setTheme({
    info: 'green',
    verbose: 'cyan',
    warn: 'yellow',
    debug: 'blue',
    error: 'red'
});

api.register(app);

app.use(express.static(path.resolve(__dirname, 'public')));

const buildPage = (version) => { 
    const cacheBust = process.env.RUNTIME_ID ? `?bust=${version}-${process.env.RUNTIME_ID}` : `?bust=${version}`;
    return `<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1">
        <meta charset="UTF-8"> 
        <title>Neptune</title>
        <link rel="stylesheet" href="/css/app.css${cacheBust}">
        <script src="/js/vendor.js${cacheBust}"></script>
    </head>
    <body>
        <div id="app"></div>
        <script src="/js/app.js${cacheBust}"></script>
    </body>
</html>`;
};

const cachedPage = buildPage(neptuneConf.name + "@" + neptuneConf.version);

app.get('/*', (req, res) => {
    res.send(cachedPage);
});

var server = app.listen(port, (err) => {
    if (err) {
        console.log(err);
        return;
    }
    
    var url = `http://localhost:${port}`;

    console.log(colors.info(`Listening on ${url}`));
});

server.on('uncaughtException', (req, res, err) => {
    console.log(colors.error(err));
    
    req.log.error({
        req,
        res,
        route: null,
        err
    }, 'uncaught exception');

    if (!res.headersSent) {
        req.log.error('sending error response from uncaught exception');
        res.send(err);
    }
});