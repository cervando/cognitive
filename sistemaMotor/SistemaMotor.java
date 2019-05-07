package sistemaMotor;

import cFramework.nodes.routers.Router;
import config.AreaNames;

public class SistemaMotor extends Router{
	
	public SistemaMotor(){
		this.ID = AreaNames.SistemaMotor;
		this.namer = AreaNames.class;
	}
	
	public void init(){
		
	}
	
	
	@Override
	public void receive(long senderID, byte[] data) {
		
	}
}
