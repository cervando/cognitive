import tornado.websocket
import thread
import time
import socketListener
import array
from config import AreaNames

#thread.start_new_thread ( socketListener.initConexions, () )


class MyWebSocket(tornado.websocket.WebSocketHandler):
    
    smallNode = None
    
    def initialize(self, SmallNode):
        self.smallNode = SmallNode
    
    def open(self, *args):
    	print "WebSocket opened"
    	#self.id = self.get_argument("Id")
    	self.ip = self.request.remote_ip
        socketListener.connections[self.ip] = {"object": self}

    def on_message(self, message):
        #self.write_message(u"You said: " + message)
        self.smallNode.receive(AreaNames.Ambiente,  [ord(s) for s in message] )

    def on_close(self):
    	del socketListener.connections[self.ip]
        print "WebSocket closed"
