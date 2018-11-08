package Mapas;
import Grafica.*;
import Logica.*;
import ObjetoGeneral.*;
import TDALista.*;
import Personajes.*;
import EnemigosConcretos.*;
import Obstaculos.*;
public class Mapa_Sans extends Mapa {

	 //atributos
	
	 
	 
	 //constructor
	 
	 public Mapa_Sans(Logica l) {
		super(l);
		mapa_siguiente = null;
	}
	 
	 //metodos
	

	public PositionList<Objeto> obtenerObjetosIniciales(){
		
		log.mostrarDialogoSans(); //importante: si se usa este mapa como primer nivel, comentar esta instruccion para no tener
								  //			que esperar los sleeps que hay en GUI
		
		PositionList<Objeto> L = new ListaDE<Objeto>();
		 
		SANS sans = new SANS(log , MAX_X / 2 + 150 , 50 , -1 , powerups[0]);
		L.addLast(sans);
		cantEnemigos++;
		
		
		
		 return L;
	 }
	 
	
}
