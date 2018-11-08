package Personajes;
import Visitors.*;


import java.util.Random;


import Logica.*;
import NivelEnemigos.*;

import Premios.*;
public abstract class Enemigo extends Personajes {

	//atributos
	protected final static int ANCHO = 30;
	protected final static int ALTO = 30;
	
	
	protected NivelEnemigo miNivel; 
	protected Premio power_up;
	
	
	boolean ya_mori;
	//constructor
	
	public Enemigo(Logica l,double x, double y,  int nivel , Premio P) { 
		
		//----PARTE LOGICA DE Enemigo----
		
		super(l);
		visitor = new VisitorEnemigo(this);
		setNivel(nivel);
		
		HP = miNivel.getHP();
		power_up = P;
		
		ya_mori = false;
		
		
		//----PARTE GRAFICA DE Enemigo----
		
		rec = crear_rectangulo(x,y,ANCHO,ALTO);
	}
	
	//NIVELES
	
	private void setNivel(int n) {
		switch(n) {
			case 1 :   miNivel = new NivelEnemigo_1();
				   	   break;
			case 2 :   miNivel = new NivelEnemigo_2();
				       break;
			case 3 :   miNivel = new NivelEnemigo_3();
				       break;
			case 4 :   miNivel = new NivelEnemigo_4();
				       break;
			default :  miNivel = new NivelEnemigo_1();
				       break;
		}
	}
	
	//metodos
	
	
	public int getPuntaje() {
		return miNivel.getPuntaje();
	}
	
	public double getVelocidadMovimiento() {
		return miNivel.getVelocidadMovimiento();
	}

	public int getFuerzaImpacto() {
		return miNivel.getFuerzaImpacto();
	}
	
	
	public void quitarHP(int n) {
		if( HP - n > 0)
			HP -= n;
		else 
			if(!ya_mori) { //este chequeo se hace porque cuando impacta un disparo del arma doble lo "mata" 2 veces
				morir();   //es decir, se ejecuta morir() 2 veces.
				ya_mori = true; 
			}
	}
	
	
	//----forma de morir comun a todos los enemigos----
	
	public void morir() {
		int puntaje = miNivel.getPuntaje();
		log.setPuntaje(log.getPuntaje() + puntaje);
		log.setCantEnemigos(log.cantEnemigos() - 1);
		log.eliminarObjeto(this);
		
		Random ran = new Random();
		int r  = ran.nextInt(10);
		
		if(r<6) {
			power_up.setX( getX() );
			power_up.setY( getY() );
			power_up.setVelocidadCaida( this.getVelocidadMovimiento() * 2 );
			log.agregarObjeto(power_up);
		}
		
	
	}
	
	//--------DISPARO---------
	
	public void crearDisparo() {
		double x = getX() + getAncho() / 2;
		double y = getY() + getAlto() - miArma.getVelocidadDisparo();
		miArma.disparar(x, y);
	}
	
	
	//------------COLISION-------------
	
	public void serVisitado(Visitor v) { // sería el "aceptar(Visitor v)"
		v.afectarEnemigo(this);
	}
	
	
	
	
	
}
