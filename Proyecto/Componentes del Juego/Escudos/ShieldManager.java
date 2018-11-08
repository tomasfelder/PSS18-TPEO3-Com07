package Escudos;
import Personajes.*;
public class ShieldManager {

	
	public static synchronized void setEscudo(Jugador jug , Escudo nuevo_escudo ,int durabilidad) throws InterruptedException {
		
			
			
			Escudo viejo_escudo = jug.getEscudo();
			jug.setEscudo(nuevo_escudo);
			
			Thread.sleep(durabilidad);
			
			jug.setEscudo(viejo_escudo);
			
			
		
	}
	
}
