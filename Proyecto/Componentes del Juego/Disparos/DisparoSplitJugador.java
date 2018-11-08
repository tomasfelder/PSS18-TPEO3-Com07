package Disparos;

import Logica.Logica;
import Visitors.Visitor;

public class DisparoSplitJugador extends DisparoJugador {


	//atributos
	
	//constructor
	
	public DisparoSplitJugador(Logica l, double v, int f, double x, double y, double direc) {
		super(l, v, f, x, y, direc);
	}
	
	
	//metodos
	
	public void morir() {
		DisparoComunJugador disparoJ = new DisparoComunJugador(log,velocidad_disparo, fuerza_impacto , pos_x , pos_y , 135);
		log.agregarObjeto(disparoJ);
		
		disparoJ = new DisparoComunJugador(log,velocidad_disparo, fuerza_impacto , pos_x , pos_y , 45);
		log.agregarObjeto(disparoJ);
		
		log.eliminarObjeto(this);
	}

	
}
