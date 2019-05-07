from SmallNode import SmallNode
import os
import tornado.httpserver
import tornado.ioloop
import tornado.web
from webserver import routes
from webserver import mySocketHandler
from config import AreaNames
from Utils.NodeNameHelper import NodeNameHelper

SERVER_PORT = 8888
settings = dict(
    ssl_options = {
        "certfile": os.path.join("src/Ambiente/webserver/ssl/localhost.cert"),
        "keyfile": os.path.join("src/Ambiente/webserver/ssl/localhost.key"),
    },
)
STACIC_FOLDER = "src/Ambiente/webserver/static/"
TEMPLATES = "src/Ambiente/webserver/dinamyc/"
routes.STACIC_FOLDER = STACIC_FOLDER
routes.TEMPLATES =  TEMPLATES

class Ambiente_WebServer(SmallNode):


    def __init__(self, myName, father, options, areaNamesClass):
        super(Ambiente_WebServer,self).__init__(myName, father, options, areaNamesClass)
        
        
        print myName
        #Mapear las URL
        urls = [
            (r'/static/(.*)', tornado.web.StaticFileHandler, {'path': STACIC_FOLDER}),
            (r"/socket", mySocketHandler.MyWebSocket,{"SmallNode":self}),
            (r"/proccess", routes.proccess),
            (r"/option", routes.option),
            (r"/test", routes.test),
            (r"/conf/nlp", routes.confNLP),
            (r"/", routes.index)
        ]

        
        server =  tornado.httpserver.HTTPServer( tornado.web.Application( urls ), **settings )
        server.listen(SERVER_PORT, "127.0.0.1")
        print "Starting Server at port " + str(SERVER_PORT)
        tornado.ioloop.IOLoop.instance().start()

	
	
    def receive(self, senderName, msg):
        if senderName == AreaNames.Ambiente:
            self.efferents( AreaNames.Sistemasensorial, msg)