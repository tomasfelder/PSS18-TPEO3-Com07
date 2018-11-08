package Visitors;
import Premios.*;
import Personajes.*;
public class VisitorPremio extends Visitor{
	
	//atributos
	
	protected Premio reward;
	
	//constructor
	
	public VisitorPremio (Premio P) {
		reward = P;
		
	}
	
	//metodos
	
	public void afectarJugador(Jugador j) {
		reward.activarPremio(j);
	}

}
