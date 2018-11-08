package Visitors;

import Logica.Logica;
import Obstaculos.*;
import Personajes.*;
public abstract class Visitor {

	//atributos
	
	
	
	//constructor
	
	public Visitor() {
		
	}
	
	//metodos
	
	public void afectarEnemigo(Enemigo e) {}
	
	public void afectarJugador(Jugador j) {}
	
	public void afectarDestruidosPT (DestruidosPorTodos o) {}
	
	public void afectarBarricadaPE (BarricadaParaEnemigos b) {}
}
