var http = require('http');
var debug = require('debug');

debug.enable("nodyn:app");
debug.enable("nodyn:server_log");

var log, server_log;
log =        debug('nodyn:app');
server_log = debug('nodyn:server_log');

// Generate a instance of the java EJB Mock
var RuntimeService = new org.nodyn.EJBMock();
log(RuntimeService);

var PORT = 1337;

http.createServer(function(req, res) {

    // Skip favicon
    if (req.url === '/favicon.ico') {
        res.writeHead(200, {'Content-Type': 'image/x-icon'} );
        res.end();
        return;
    }

    server_log('Responding to %s %s', req.method, req.url);
    res.writeHead(200, {'Content-Type': 'application/json'});
    res.end( JSON.stringify( RuntimeService.fetchAllTickets() ) );

}).listen(PORT, '127.0.0.1');

log('Server Running at %s', 'http://127.0.0.1:' + PORT);