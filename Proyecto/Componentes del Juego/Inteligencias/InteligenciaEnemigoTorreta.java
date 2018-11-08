package Inteligencias;
import java.util.Random;

import Personajes.*;
public class InteligenciaEnemigoTorreta extends InteligenciaEnemigo{

	
	//atributos
	
	protected Enemigo ene;
	
	//constructor
	
	public InteligenciaEnemigoTorreta(Enemigo e) {
		super();
		ene = e;
	}
	
	//metodos
	
	public void accionar() {
		
		ene.crearDisparo();
		
	}
}
