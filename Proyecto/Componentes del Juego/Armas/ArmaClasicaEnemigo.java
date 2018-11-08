package Armas;
import Logica.*;
import Disparos.*;


public class ArmaClasicaEnemigo extends Arma{

	//atributos
	
	
	//constructor
	
	public ArmaClasicaEnemigo(Logica l) {
		super(l);
		velocidadDisparo = 15;
		fuerzaDisparo = 2;
		cadencia = 500;
		chances = 2;
	}
	
	//metodos
	
	public void crear_disparo(double x , double y) {
		
		DisparoComunEnemigo dispE = new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,x,y,270);
		log.agregarObjeto(dispE);
	
	}
	
	
	
}
