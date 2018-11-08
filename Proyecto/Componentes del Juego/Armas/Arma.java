package Armas;

import java.util.Random;

import Disparos.Disparo;
import Logica.Logica;

public abstract class Arma {
	
	//atributos
	
	protected Logica log;
	
	protected double velocidadDisparo;
	protected int fuerzaDisparo;
	
	protected int cadencia; //cadencia de cada arma, medida en milisegundos
	protected int chances; //chances de disparar de cada arma. 1 = 100% , cuanto mas grande "chances", menos chances de disparar

	private long time;
	
	
	//constructor
	
	protected Arma(Logica l) {
		log = l;
		
		time = System.currentTimeMillis();
		chances = 1; //chance por defecto
	}
	
	//metodos
	
	//getters y setters
	
	public int getFuerzaDisparo() {
		return fuerzaDisparo;
	}
	
	public double getVelocidadDisparo() {
		return velocidadDisparo;
	}
	
	public void setVelocidadDisparo(double vel) {
		velocidadDisparo = vel;
	}
	
	public void setFuerzaDisparo(int str) {
		fuerzaDisparo = str;
	}
	
	//metodos especiales
	

	public void disparar(double x , double y) {
		long elapsed_time = System.currentTimeMillis() - time;
		if(elapsed_time > cadencia) {
			Random ran = new Random();
			int r_shoot = ran.nextInt(chances);
			if(r_shoot == 0)
				crear_disparo(x,y);
			
			time = System.currentTimeMillis();
		}
	}
	
	protected abstract void crear_disparo(double x , double y);
}
