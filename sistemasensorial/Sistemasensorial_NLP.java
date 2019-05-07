package sistemasensorial;

import java.io.UnsupportedEncodingException;

/*import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.logging.RedwoodConfiguration;*/
import cFramework.nodes.processes.Process;
import config.AreaNames;





public class Sistemasensorial_NLP extends Process {
	
	//private NLPProcessor nlp;
	
	public Sistemasensorial_NLP(){
		this.ID = AreaNames.Sistemasensorial_NLP;
		this.namer = AreaNames.class;
		//nlp = new NLPProcessor();
		//console.log()
	}
	
	
	
	public void receive(long nodeName, byte[] data) {
		try {
			String str = new String(data, "UTF-8");
			//str = nlp.Process(str);
			//log.message(str);
			send(AreaNames.Sistemasensorial_TreeBankToCommand, str.getBytes());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
	/*public static void main (String[] args){
		//String sentences = "Search on youtube dog play on beach";
		String sentences = "Search videos of doggie in youtube";
		NLPProcessor nlp = new NLPProcessor();
		System.out.println(nlp.Process(sentences));
	}*/
}
/*
class NLPProcessor {
	
	private StanfordCoreNLP pipeline;
	
	public NLPProcessor() {
		Properties props = new Properties();
		//String annotators = "tokenize, ssplit, pos, lemma, ner, parse";
		String annotators = "tokenize, ssplit, pos, lemma, parse";
		props.setProperty("annotators", annotators);
		RedwoodConfiguration.current().clear().apply();
		pipeline = new StanfordCoreNLP(props);
		
	}
	
	
	public String Process(String sentences){
	
		Annotation annotation = new Annotation(sentences);
		pipeline.annotate(annotation);
		
		List<CoreMap> sentencesList = annotation.get(SentencesAnnotation.class);

		for(CoreMap sentence: sentencesList) {
			// this is the parse tree of the current sentence
			Tree tree = sentence.get(TreeAnnotation.class);
			// Convert the tree into an XML string
			StringWriter stringWriter = new StringWriter();
			PrintWriter writer = new PrintWriter(stringWriter);
			tree.indentedXMLPrint( writer, false);
			String s = stringWriter.toString();
			
			
			
			
			//Adds the NER tag to every leaf
			try {
				Document doc =  DocumentBuilderFactory.newInstance().
										newDocumentBuilder().
											parse(new ByteArrayInputStream( s.getBytes() ));
				
				//System.out.println(DOMToString(doc));
				
				NodeList nodeList = doc.getElementsByTagName("leaf");
				List<CoreLabel> tokens = sentence.get(TokensAnnotation.class);
				if ( nodeList.getLength() == tokens.size() ){
					
					for ( int i = 0; i < nodeList.getLength(); i++ ){
						Element e = (Element) nodeList.item(i);
						e.setAttribute("ne", tokens.get(i).getString(NamedEntityTagAnnotation.class));
						e.setAttribute("Lemma", tokens.get(i).getString(LemmaAnnotation.class));
						org.w3c.dom.Node parent = e.getParentNode();
						String wordType = parent.getAttributes().getNamedItem("value").getNodeValue();
						e.setAttribute("pos", wordType );
						parent.getParentNode().replaceChild((org.w3c.dom.Node)e, parent);
					}
				}
				
				return DOMToString(doc);
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}	
		return "";
	}
	
	private String DOMToString(Document doc){
		try{
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer2 = new StringWriter();
			StreamResult result = new StreamResult(writer2);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			return writer2.toString();
		}catch( Exception e ){
			System.out.println(e.getMessage());
		}
		return "";
	}
	
}
*/