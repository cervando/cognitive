package emociones;

import cFramework.nodes.routers.Router;
import config.AreaNames;

public class Emociones extends Router{
	
	public Emociones(){
		this.ID = AreaNames.Emociones;
		this.namer = AreaNames.class;
	}
	
	public void init(){
	}
	
	
	@Override
	public void receive(long senderID, byte[] data) {
	}
}
