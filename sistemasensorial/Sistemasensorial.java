package sistemasensorial;

import cFramework.communications.spikes.SpikeRouter;
import cFramework.nodes.processes.ProcessConfiguration;
import cFramework.nodes.routers.Router;
import config.AreaNames;

public class Sistemasensorial extends Router{
	
	public Sistemasensorial(){
		this.ID = AreaNames.Sistemasensorial;
		this.namer = AreaNames.class;
		addProcess(Sistemasensorial_TreeBankToCommand.class,ProcessConfiguration.TYPE_PARALLEL);
		addProcess(Sistemasensorial_NLP.class);
		
		
		AddRoute(new SpikeRouter(
					new long[]{AreaNames.Ambiente}, 
					new long[]{AreaNames.Sistemasensorial_NLP, AreaNames.Interpretacion_ProcessCommand }));
	}

	public void receive(int nodeID, byte[] data) {}
}
