package Inteligencias;
import Disparos.*;
public  class InteligenciaDisparo extends Inteligencia{

	//atributos
	
	protected Disparo disp;
	double direccion; //direccion del disparo, medida en grados. (entre 0 y 360)
	
	//constructor

	public InteligenciaDisparo(Disparo d , double direc) {
		disp = d;
		direccion = Math.toRadians(direc);
	}
	
	//metodos
	
	public void accionar() {
		if(fueraDeLimite()) {
			disp.morir();
		}
		else { 
			disp.setX(disp.getX() + disp.getVelocidad() * Math.cos(direccion));
			disp.setY(disp.getY() + disp.getVelocidad() * ( - Math.sin(direccion))); //negativo ya que para subir hay que restar en Y
		}
	}
	
	private boolean fueraDeLimite() {
		if( (disp.getX() < 0) || (disp.getX() > ANCHO_MAPA) || (disp.getY() < 0) || (disp.getY() > ALTO_MAPA))
			return true;
		else
			return false;
	}

}
