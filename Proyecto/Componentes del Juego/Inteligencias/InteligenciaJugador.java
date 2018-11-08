package Inteligencias;
import Personajes.*;
import Disparos.DisparoJugador;
import Logica.Tiempo;

public class InteligenciaJugador extends Inteligencia{


	//atributos
	
	
	protected Jugador jug;
	
	
	protected int quiero_shoot; //sería si el jugador apreta para disparar
	protected int direccion;
	
	
	//constructor
	public InteligenciaJugador(Jugador j) {
		jug = j;
		direccion = 0;
		quiero_shoot = 0;
		
	}
	
	//metodos
	
	public void accionar() {
		//---CON RESPECTO AL MOVIMIENTO---
		
		if(direccion==1) {
			moverIzquierda();
		}
		else
			if(direccion==2)
				moverDerecha();
		
		
		
		
		//---CON RESPECTO AL DISPARO---
		
		
		if (quiero_shoot==1) { 
			jug.crearDisparo();
		}
		
		
		
	}
	
	private void moverIzquierda() {
		if(jug.getX() - jug.getVelocidadMovimiento() > 0) { 
			jug.setX(jug.getX() - jug.getVelocidadMovimiento()); //  y aca *
		}
		else {
			jug.setX(ANCHO_MAPA - jug.getAncho());
			
		}
	}
	
	private void moverDerecha() {
		if(jug.getX() + jug.getVelocidadMovimiento() < ANCHO_MAPA - jug.getAncho()) { //ver rec.getWidth() para ver si entra bien
			jug.setX(jug.getX() + jug.getVelocidadMovimiento()); // aca *
		}
		else
			jug.setX(0);
	}
	
	//---metodos especiales para la inteligencia del jugador---
	
	public void setDireccion(int dir) {
		direccion = dir;
	}
	
	public void setShoot(int shoot) {
		quiero_shoot = shoot;
	}
	
}
