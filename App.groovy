def server = vertx.createHttpServer()

// Serve the static resources
server.requestHandler { req ->
    def file = ( req.uri == "/" ) ? "revised.html" : req.uri
    req.response.sendFile("web/$file")
}

vertx.createSockJSServer(server).bridge(prefix: '/eventbus', [[:]])

server.listen(8080)
