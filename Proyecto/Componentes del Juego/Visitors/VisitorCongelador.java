package Visitors;

import Personajes.*;
import Inteligencias.*;
public class VisitorCongelador extends Visitor{

	//atributos
	
	//constructor
	
	public VisitorCongelador() {
		
	}
	
	//metodos
	
	public void afectarEnemigo(Enemigo e) {
		Inteligencia inte = new InteligenciaDummyTemporal(e);
		e.setInteligencia(inte);
	}
	
}
