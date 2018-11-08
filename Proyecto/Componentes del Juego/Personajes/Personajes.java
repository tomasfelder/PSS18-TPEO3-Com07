package Personajes;

import Logica.*;

import ObjetoGeneral.Objeto;

import java.awt.Rectangle;
import Armas.*;
public abstract class Personajes extends Objeto {
	
	//atributos
	
	protected int HP; // puntos de vida
	
	protected Arma miArma;
	
	//constructor
	
	public Personajes(Logica l) {
		super(l);
		miArma = new ArmaDummy(l);
	}
	
	//metodos
	
	
	public abstract double getVelocidadMovimiento();
	
	public abstract void quitarHP(int n); 
		
	
	
}
