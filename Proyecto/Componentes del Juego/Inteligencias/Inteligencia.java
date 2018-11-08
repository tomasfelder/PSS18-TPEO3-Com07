package Inteligencias;


import Mapas.Mapa;


public abstract class Inteligencia {
	
	
	//atributos
	
	protected final static int ANCHO_MAPA=Mapa.MAX_X; 
	protected final static int ALTO_MAPA=Mapa.MAX_Y;  
	
	
	//sin constructor
	
	
	//metodos
	
	public abstract void accionar();	
	
	
	//  METODOS HECHOS EXCLUSIVAMENTE PARA InteligenciaJugador,
	//	DONDE ADEMAS SERAN REDEFINIDOS.
	
	public void setDireccion(int dir) { 
		
	}
	
	public void setShoot(int shoot) {
		
	}

}
