package tomadeDesiciones;

import cFramework.nodes.routers.Router;
import config.AreaNames;

public class TomadeDesiciones extends Router{
	
	public TomadeDesiciones(){
		this.ID = AreaNames.TomadeDesiciones;
		this.namer = AreaNames.class;
	}
	
	public void init(){
		
	}
	
	
	@Override
	public void receive(long senderID,  byte[] data) {
	
	}

}
