package config;

import cFramework.util.IDHelper;

//import kmiddle2.util.IDHelper;

public class AreaNames {


	
	public static long Ambiente	= IDHelper.generateID("Ambiente");
	public static long Ambiente_WebServer	= IDHelper.generateID("Ambiente_WebServer", 1, 0);
	public static long Sistemasensorial	= IDHelper.generateID("Sistemasensorial", 0, 0);
	public static long Sistemasensorial_NLP	= IDHelper.generateID("Sistemasensorial", 1, 0);
	public static long Sistemasensorial_TreeBankToCommand	= IDHelper.generateID("Sistemasensorial", 2, 0);
	public static long Interpretacion	= IDHelper.generateID("longerpretacion", 0, 0);
	public static long Interpretacion_ProcessCommand	= IDHelper.generateID("longerpretacion",1,0);
	public static long Workingmemory	= IDHelper.generateID("Workingmemory", 0, 0);
	public static long LongTermMemory	= IDHelper.generateID("LongTermMemory", 0, 0);
	public static long Emociones	= IDHelper.generateID("Emociones", 0, 0);
	public static long TomadeDesiciones	= IDHelper.generateID("TomadeDesiciones", 0, 0);
	public static long Planeacion	= IDHelper.generateID("Planeacion", 0, 0);
	public static long SistemaMotor	= IDHelper.generateID("SistemaMotor", 0, 0);
	
	
	
	
	public static void main(String[] a) {
		System.out.println("AREA CON UN NOMBRE LARGO".hashCode() );
		System.out.println("AREA CON UN NOMBRE BASTANTE LARGO".hashCode() );
		
		//-1521258652
		//  354264420
	}
	
}
