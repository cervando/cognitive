import tornado.web
import tornado.template as template


STACIC_FOLDER = None
TEMPLATES = None


#Una Clase por cada URL
class index(tornado.web.RequestHandler):
	
	def get(self):
		loader = template.Loader(STACIC_FOLDER)
		self.write( loader.load("index.html").generate() )

class proccess(tornado.web.RequestHandler):
	
	def post(self):
		i = web.input()
		ret = nlp.analize(i.text , session )
		return ret

class option(tornado.web.RequestHandler):
	def post(self):
		print session.engineinfo
		ret = behaviortree.option(i.text , session )
		return ret
		
class test(tornado.web.RequestHandler):
	def get(self):
		loader = template.Loader(STACIC_FOLDER)
		self.write( loader.load("test.html").generate() )

class confNLP(tornado.web.RequestHandler):
	def get(self):
		render = web.template.render(TEMPLATES + "conf/")
		return render.nlp([])