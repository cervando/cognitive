package sistemasensorial;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import cFramework.communications.MessageMetadata;
import cFramework.log.NodeLog;
import cFramework.nodes.processes.Process;
import config.AreaNames;




public class Sistemasensorial_TreeBankToCommand extends Process {
	public Sistemasensorial_TreeBankToCommand(){
		this.ID = AreaNames.Sistemasensorial_TreeBankToCommand;
		this.namer = AreaNames.class;
	}
	
	
	
	public void receive(long nodeName, byte[] data) {
		if ( nodeName == AreaNames.Sistemasensorial_NLP ){
			try {
				Document doc =  DocumentBuilderFactory.newInstance().newDocumentBuilder().
							parse(new ByteArrayInputStream( data ));
				process(doc);
				send(AreaNames.Interpretacion_ProcessCommand, data);
			} catch (SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void process(Document doc){
		//Node root  = doc.getFirstChild();
		//NodeList childs = root.getChildNodes();
	}
	
	
	
	
	
	public static void main(String args[]){
		byte[] data;
		try {
			data = Files.readAllBytes(Paths.get("coreNLPTest.xml"));
			Sistemasensorial_TreeBankToCommand sst = new Sistemasensorial_TreeBankToCommand();
			sst.setLog(new NodeLog("Treebank", null));
			sst.receive(AreaNames.Sistemasensorial_NLP, new MessageMetadata(0), data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
