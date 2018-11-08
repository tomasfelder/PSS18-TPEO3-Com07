package Visitors;

import Logica.Logica;
import Personajes.*;

public class VisitorEnemigo extends Visitor {

	//atributos
	
	protected Enemigo ene;
	
	//constructor
	public VisitorEnemigo(Enemigo e) {
		ene = e;
	}
	
	//metodos
	
	public void afectarJugador(Jugador j) {
		j.quitarHP(ene.getFuerzaImpacto());
		ene.morir();
	}
}
