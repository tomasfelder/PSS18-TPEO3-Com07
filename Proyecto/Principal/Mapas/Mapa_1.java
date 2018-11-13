package Mapas;
import Grafica.*;
import Logica.*;
import ObjetoGeneral.*;
import TDALista.*;
import Personajes.*;
import EnemigosConcretos.*;
import Obstaculos.*;
public class Mapa_1 extends Mapa {

	 //atributos
	
	 
	 
	 //constructor
	 
	 public Mapa_1(Logica l) {
		super(l);
		mapa_siguiente = new Mapa_2(log);
	}
	 
	 //metodos
	

	public PositionList<Objeto> obtenerObjetosIniciales(){
		 PositionList<Objeto> L = new ListaDE<Objeto>();
		
		 
		 
		 L.addLast(new BarricadaParaEnemigos (log , 20 , MAX_Y / 2));
		 L.addLast(new BarricadaParaEnemigos (log , 870 , MAX_Y / 2));
		 		 
		 L.addLast(new DestruidosPorTodos (log, MAX_X - Obstaculo.ANCHO - 120 , MAX_Y /2 - 60));
		 L.addLast(new DestruidosPorTodos (log, MAX_X - Obstaculo.ANCHO - 430 , MAX_Y /2 - 60));
		 L.addLast(new DestruidosPorTodos (log, MAX_X - Obstaculo.ANCHO - 740 , MAX_Y /2 - 60));
		 
		 for(int i = 0 ; i<8 ; i++) {
			 EnemigoConArma ene = new EnemigoConArma(log , 250 + i*80 , 70 , 1 , powerups[ i % CANT_MAX_PREMIOS].clone());
			 L.addLast(ene);
			 cantEnemigos++;
		 }
		
		 for(int i = 0 ; i<6 ; i++) {
			EnemigoKamikazeAleatorio ene = new EnemigoKamikazeAleatorio( log, 300 + i*90 , 150  ,1 , powerups[ i % CANT_MAX_PREMIOS].clone());
			L.addLast(ene);
			cantEnemigos++;
		}
		
		 
		 
		
		 return L;
	 }
	 
	
}
