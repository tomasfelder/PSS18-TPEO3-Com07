package Armas;

import Disparos.DisparoComunEnemigo;
import Logica.Logica;

public class ArmaMetralladoraEnemigo extends Arma{

	//atributos
	
	
	//constructor
	
	public ArmaMetralladoraEnemigo(Logica l) {
		super(l);
		velocidadDisparo = 15;
		fuerzaDisparo = 1;
		cadencia = 285;
	}

	//metodos
	
	
	protected void crear_disparo(double x, double y) {
		DisparoComunEnemigo disp = new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,x,y,270);
		log.agregarObjeto(disp);
	}

}
