package planeacion;


import cFramework.nodes.routers.Router;
import config.AreaNames;

public class Planeacion extends Router{
	
	public Planeacion(){
		this.ID = AreaNames.Planeacion;
		this.namer = AreaNames.class;
	}
	
	public void init(){
		
	}
	
	
	@Override
	public void receive(long senderID, byte[] data) {
		//init:receive

		//end:receive
	}
}
