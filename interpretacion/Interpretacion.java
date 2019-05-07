package interpretacion;

import java.util.HashMap;

import cFramework.communications.spikes.SpikeMerger;
import cFramework.communications.spikes.SpikeRouter;
import cFramework.nodes.routers.Router;
import config.AreaNames;

public class Interpretacion extends Router{
	
	public Interpretacion(){
		this.ID = AreaNames.Interpretacion;
		this.namer = AreaNames.class;
		addProcess(Interpretacion_ProcessCommand.class);
		
		AddRoute(new SpikeRouter(
				new long[]{ AreaNames.Sistemasensorial_TreeBankToCommand,AreaNames.Sistemasensorial}, 
				new long[]{ AreaNames.Interpretacion_ProcessCommand }
				,
				new SpikeMerger() {
					public byte[] merge(HashMap<Long, byte[]> spikes) {
						return (new String(spikes.get(AreaNames.Sistemasensorial)) + 
								new String(spikes.get(AreaNames.Sistemasensorial_TreeBankToCommand))).getBytes();
					}
				}));
	}
	
	
	@Override
	public void receive(long senderID, byte[] data) {
		
	}
}
