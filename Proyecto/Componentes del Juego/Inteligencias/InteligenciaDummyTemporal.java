package Inteligencias;

import Personajes.Enemigo;

public class InteligenciaDummyTemporal extends Inteligencia {

	//atributos
	
	private final int tiempo_freeze = 4000;
	
	private Enemigo ene;
	private long time;
	private Inteligencia vieja_inteligencia;
	
	//constructor
	
	public InteligenciaDummyTemporal(Enemigo e) {
		ene = e;
		vieja_inteligencia = e.getInteligencia();
		time = System.currentTimeMillis();
	}

	
	//metodos
	
	
	public void accionar() {
		long elapsed_time = System.currentTimeMillis() - time;
		
		if(elapsed_time > tiempo_freeze) {
			ene.setInteligencia(vieja_inteligencia);
			
			//no vuelvo a setear el tiempo ya que despues de esto esta inteligencia se destruira
		}
		
		
	}
	
}
