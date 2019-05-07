package config;

import ambiente.Ambiente;
import cFramework.nodes.service.Igniter;
import emociones.Emociones;
import interpretacion.Interpretacion;
import longTermMemory.LongTermMemory;
import planeacion.Planeacion;
import sistemaMotor.SistemaMotor;
import sistemasensorial.Sistemasensorial;
import tomadeDesiciones.TomadeDesiciones;
import workingmemory.Workingmemory;

public class Init extends Igniter{

	public Init(){
		String [] areas = {
				Sistemasensorial.class.getName(),
				Emociones.class.getName(),
				Interpretacion.class.getName(),
				LongTermMemory.class.getName(),
				Planeacion.class.getName(),
				SistemaMotor.class.getName(),
				TomadeDesiciones.class.getName(),
				Workingmemory.class.getName(),
				Ambiente.class.getName()
		};
		//Configuration of THIS RUN
		configuration.setDebug(null);
		setAreas(areas);
		run();
	}
	
	public static void main(String[] args){
		new Init();
	}
}
