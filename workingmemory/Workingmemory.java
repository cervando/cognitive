package workingmemory;

import cFramework.nodes.routers.Router;
import config.AreaNames;

public class Workingmemory extends Router{
	
	public Workingmemory(){
		this.ID = AreaNames.Workingmemory;
		this.namer = AreaNames.class;
	}
	
	public void init(){

		
	}
	
	
	@Override
	public void receive(long senderID, byte[] data) {

	}

}