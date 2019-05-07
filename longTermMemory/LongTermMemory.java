package longTermMemory;

import cFramework.nodes.routers.Router;
import config.AreaNames;

public class LongTermMemory extends Router{
	
	public LongTermMemory(){
		this.ID = AreaNames.LongTermMemory;
		this.namer = AreaNames.class;
	}
	
	public void init(){
		 
	}
	
	
	@Override
	public void receive(long senderID, byte[] data) {
	}
}
