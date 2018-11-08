package Inteligencias;
import java.util.Random;

import Logica.Tiempo;
import Personajes.*;
public abstract class InteligenciaEnemigo extends Inteligencia{ //esta bien esta interfaz intermedia?

	//atributos
	
	protected int cambio_direccion;
	
	private boolean direccion;
	private long time;
	
	
	//constructor
	
	protected InteligenciaEnemigo() {
		super();
		time = System.currentTimeMillis();
		direccion = true;
		cambio_direccion = 4000;
	}
	
	//metodos
	
	
	protected void movimiento_estandar(Enemigo ene) { 
		
		long elapsed_time = System.currentTimeMillis() - time;
	
		
		if(elapsed_time > cambio_direccion) {
			direccion = (!direccion);
			time = System.currentTimeMillis();
		}
		
		if(direccion)
			moverIzquierda(ene);
		else
			moverDerecha(ene);
		
		
	}
	
	private void moverIzquierda(Enemigo ene) {
		if(ene.getX() - ene.getVelocidadMovimiento() > 0) { 
			ene.setX(ene.getX() - ene.getVelocidadMovimiento()); // 
		}
	}
	
	private void moverDerecha(Enemigo ene) {
		if(ene.getX() + ene.getVelocidadMovimiento() < ANCHO_MAPA - ene.getAncho()) { 
			ene.setX(ene.getX() + ene.getVelocidadMovimiento()); 
		}
	}
	
	
}