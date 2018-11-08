package Inteligencias;

import EnemigosConcretos.Blaster;
import EnemigosConcretos.SANS;
import Mapas.Mapa;

public class InteligenciaBlaster extends Inteligencia{

	
	//atributos
	
	private Blaster blaster;
	private long time;
	private long tiempo_de_vida;
	
	//constructor
	
	public InteligenciaBlaster(Blaster b) {
		blaster = b;
		tiempo_de_vida = SANS.DURACION_ATAQUE_ESPECIAL;
		time = System.currentTimeMillis();
	}
	
	//metodos
	
	public void accionar() {
		if(blaster.getY() < Mapa.MAX_Y)
			blaster.setY(blaster.getY() + blaster.getVelocidadMovimiento());
		else
			blaster.setY(0);
		
		long elapsed_time = System.currentTimeMillis() - time;
		
		if(elapsed_time > tiempo_de_vida)
			blaster.morir();
	}
}
