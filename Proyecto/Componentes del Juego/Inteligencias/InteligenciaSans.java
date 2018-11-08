package Inteligencias;

import EnemigosConcretos.SANS;

public class InteligenciaSans extends InteligenciaEnemigo{

	//atributos
	
	private SANS sans;
	
	private long time;
	
	private long cadencia_ataqueEspecial;

	
	private boolean ataqueEspecialEnProceso;
	
	//constructor
	
	public InteligenciaSans(SANS s) {
		sans = s;
		cambio_direccion = 5500;
		
		time = System.currentTimeMillis();
		
		
		cadencia_ataqueEspecial = 16000;
		
		ataqueEspecialEnProceso = false;
	}
	
	public void accionar() {
		
		//CON RESPECTO AL MOVIMIENTO
		
		movimiento_estandar(sans);
		
		//CON RESPECTO AL DISPARO
		
		if(!ataqueEspecialEnProceso)
			sans.crear_disparos();
		else {
			long elapsed_time = System.currentTimeMillis() - time;
			if (elapsed_time > SANS.DURACION_ATAQUE_ESPECIAL) {
				ataqueEspecialEnProceso = false;
				time = System.currentTimeMillis();
			}
		}
		
		//CON RESPECTO A LOS PODERES
		
		long elapsed_time = System.currentTimeMillis() - time;
		if(elapsed_time > cadencia_ataqueEspecial && !ataqueEspecialEnProceso) {
			ataqueEspecialEnProceso = true;
			time = System.currentTimeMillis();
			
			sans.lanzar_poder();
		}
		
	}

}
