package ambiente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cFramework.communications.MessageMetadata;
import cFramework.nodes.routers.Router;
import config.AreaNames;

public class Ambiente extends Router{
	
	public Ambiente(){
		this.ID = AreaNames.Ambiente;
		this.namer = AreaNames.class;
		//addProcess(AreaNames.Ambiente_WebServer, "Ambiente_WebServer", ActConf.LENG_PYTHON);
		//createMappedNode(AreaNames.Ambiente_WebServer, 1);
		
		//end:init		
		
	}
	
	public void init(){
		int i=1;
		send(AreaNames.Sistemasensorial, new MessageMetadata(i++), "Hello".getBytes());
		send(AreaNames.Sistemasensorial, new MessageMetadata(i++), "My Name is Armando".getBytes());
		send(AreaNames.Sistemasensorial, new MessageMetadata(i++), "This is a test".getBytes());
		send(AreaNames.Sistemasensorial, new MessageMetadata(i++), "Sinchronize".getBytes());
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(true){
			try {
				s = br.readLine();
				send(AreaNames.Sistemasensorial, new MessageMetadata(i++), s.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void receive(int nodeID, byte[] data) {

	}
}