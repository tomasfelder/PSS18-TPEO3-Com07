package EnemigosConcretos;

import Logica.Logica;
import Mapas.Mapa;

public class BlasterManager extends Thread{

	//atributos
	
	private final int tiempo_entre_blasters = 500;
	private final int POS_Y = Mapa.MAX_Y / 4;
	
	private Logica log;
	
	//constructor
	
	public BlasterManager(Logica l) {
		log = l;
	}
	
	//metodos
	
	public void run() {
		try {
			
			log.agregarObjeto(new Blaster(log , Mapa.MAX_X / 2 - 20, POS_Y , 0 , null));
			
			Thread.sleep(tiempo_entre_blasters);
			
			for(int i=1 ; i<10 ; i++) {
				if(log.jugadorEstaVivo()) {
					log.agregarObjeto(new Blaster(log , Mapa.MAX_X / 2 - 20 + 50 * i , POS_Y , 0 , null));
					log.agregarObjeto(new Blaster(log , Mapa.MAX_X / 2 - 20 - 50 * i , POS_Y , 0 , null));
				
					Thread.sleep(tiempo_entre_blasters);
				}
				else
					break;
			}
			
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
