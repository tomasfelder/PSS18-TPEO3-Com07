package Premios;
import ObjetoGeneral.*;
import Personajes.Jugador;
import Visitors.Visitor;
import Visitors.VisitorPremio;

import java.awt.Rectangle;

import Logica.*;

import Inteligencias.*;
public abstract class Premio extends Objeto {

	//------ATRIBUTOS------
	
	protected final static int ANCHO=10;
	protected final static int LARGO=10;
	
	protected double velocidadDeCaida;
	
	//--------CONSTRUCTOR-------
	
	public Premio (double x,double y,double velCaida,Logica l) {
		//---parte logica de los premios---
		
		super(l);
		inteligencia = new InteligenciaPremio(this);
		velocidadDeCaida = velCaida;
		visitor = new VisitorPremio(this);
		
		//---parte grafica de los premios---
		rec = crear_rectangulo(x,y,ANCHO,LARGO);
	}
	
	//------METODOS------
	
	public void setVelocidadCaida(double vel) {
		velocidadDeCaida = vel;
	}
	
	public double getVelocidadDeCaida() {
		return velocidadDeCaida;
	}
	
	
	//forma de morir comun a todos los premios
	
	public void morir() {
		log.eliminarObjeto(this);
	}
	
	//metodo que será redefinido dependiendo cada premio
	
	public abstract void activarPremio(Jugador j);
	
	public abstract Premio clone() ;
	
	//----VISITOR----
	
	public void serVisitado(Visitor v) {
		//cuerpo vacio ya que no tiene efecto que un Premio seaVisitado por alguien
	}
	
}
