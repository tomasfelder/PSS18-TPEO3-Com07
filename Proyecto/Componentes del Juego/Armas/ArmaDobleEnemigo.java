package Armas;

import Disparos.DisparoComunEnemigo;
import Disparos.DisparoComunJugador;

import Logica.*;

public class ArmaDobleEnemigo extends Arma{

	//atributos
	
	
	
	//constructor
	
	public ArmaDobleEnemigo(Logica l) {
		super(l);
		velocidadDisparo = 15;
		fuerzaDisparo = 2;
		
		cadencia = 700;
		chances = 3;
	}
	
	//metodos
	
	public void crear_disparo(double x , double y) {
		
		DisparoComunEnemigo disparoJ = new DisparoComunEnemigo(log , velocidadDisparo,fuerzaDisparo, x-10 , y , 260);
		log.agregarObjeto(disparoJ);
		
		disparoJ = new DisparoComunEnemigo(log , velocidadDisparo , fuerzaDisparo , x+10 , y , 280);
		log.agregarObjeto(disparoJ);
			
	}
	
}
