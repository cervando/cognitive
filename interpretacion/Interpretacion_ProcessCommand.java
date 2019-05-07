package interpretacion;

import config.AreaNames;
import cFramework.nodes.processes.Process;


public class Interpretacion_ProcessCommand extends Process {
	public Interpretacion_ProcessCommand(){
		this.ID = AreaNames.Interpretacion_ProcessCommand;
		this.namer = AreaNames.class;
	}
	
	
	public void init(){
		
	}
	
	int i = 0;
	public void receive(long nodeID, byte[] data){
		if ( i++ == 2) {
			setWellness(0);
		}
		System.out.println( new String(data));
	}
	
	public void recovery_receive(long nodeID,byte[] data){
		System.out.println( getWellness() );
	}
	
}
