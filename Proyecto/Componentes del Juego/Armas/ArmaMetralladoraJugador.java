package Armas;

import Disparos.DisparoComunEnemigo;
import Disparos.DisparoComunJugador;
import Logica.Logica;

public class ArmaMetralladoraJugador extends Arma{

	//atributos
	
	
	//constructor
	
	public ArmaMetralladoraJugador(Logica l) {
		super(l);
		velocidadDisparo = 15;
		fuerzaDisparo = 1;
		cadencia = 150;
	}

	//metodos
	
	
	protected void crear_disparo(double x, double y) {
		DisparoComunJugador disp = new DisparoComunJugador(log,velocidadDisparo,fuerzaDisparo,x,y,90);
		log.agregarObjeto(disp);
	}

}
