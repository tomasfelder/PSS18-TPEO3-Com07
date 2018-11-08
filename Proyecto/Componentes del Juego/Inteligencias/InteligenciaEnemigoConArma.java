package Inteligencias;

import Personajes.*;
import java.util.Random;



public class InteligenciaEnemigoConArma extends InteligenciaEnemigo{
	
	//atributos
	
	protected Enemigo ene;
	
	
	//constructor
	
	public InteligenciaEnemigoConArma(Enemigo e) {
		super();
		ene = e;
	}
	
	//metodos
	
	public void accionar() {
		

		//CON RESPECTO AL MOVIMIENTO
		
		movimiento_estandar(ene);
		
		//CON RESPECTO AL DISPARO
			
	
		ene.crearDisparo();
		
			
	}
	
	

	
	
	
}
