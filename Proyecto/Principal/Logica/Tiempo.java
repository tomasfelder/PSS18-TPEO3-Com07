package Logica;


public class Tiempo extends Thread{
	
	//atributos

	private Logica log;
	public final static int SLEEP_TIME = 40;
	private TiempoEntreNiveles new_time;
	private boolean seguir;
	//constructor
	
	public Tiempo(Logica l) {
		log = l;
		new_time = new TiempoEntreNiveles(log);
		seguir = true;
	}
	
	//metodos
	
	
	
	public void run() {
		while(log.hayMapa() && log.jugadorEstaVivo()) {
			
			try {
				if(!log.hayEnemigos() && log.hayMapa() && !new_time.isAlive()) {
					
					new_time = new TiempoEntreNiveles(log);
					new_time.start();
					
				}
				
				
				
				log.actualizarObjetos();
				
				log.accionarObjetos();
				
				log.detectarColisiones();
				
				
				
				Thread.sleep(SLEEP_TIME);
				
				//MUY IMPORTANTE RESPETAR EL ORDEN EN EL QUE SE REALIZAN ESTAS ACCIONES! de lo contrario aumenta 
				//significantemente el delay
				//de todas formas, dependiendo de la forma en la que esten ordenados se produce el error en ejecucion raro.
			}
			catch (InterruptedException  e) {
				e.printStackTrace();
				
			}	
		}
		
		if(!log.hayMapa()) {
			log.ganar();
		}
	}
	
	public void parar() {
		seguir = false;
	}

	public void seguir() {
		seguir = true;
	}
	
	
}
