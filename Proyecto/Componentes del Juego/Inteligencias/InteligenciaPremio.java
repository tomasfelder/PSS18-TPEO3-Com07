package Inteligencias;

import Mapas.Mapa;
import Premios.*;

public class InteligenciaPremio extends Inteligencia {

	//atributos
	
	Premio Pr;
	
	//constructor
	
	public InteligenciaPremio(Premio P) {
		Pr = P;
	}
	
	//metodos
	
	public void accionar() {
		if(Pr.getY() > ALTO_MAPA + Pr.getAlto()) {
			Pr.morir();
		}
		else
			Pr.setY(Pr.getY() + Pr.getVelocidadDeCaida());
	}
}
