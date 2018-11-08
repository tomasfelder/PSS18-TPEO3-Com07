package Disparos;

import Logica.Logica;

public class DisparoComunJugador extends DisparoJugador{

	//atributos
	
	//constructor
	
	public DisparoComunJugador(Logica l, double v , int f, double x , double y,double direc) {
		super(l,v,f,x,y,direc);
	}
	
	//metodos
	
	public void morir() {
		log.eliminarObjeto(this);
	}
}
