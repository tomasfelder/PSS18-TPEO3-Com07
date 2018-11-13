package Mapas;

import EnemigosConcretos.*;
import Logica.Logica;
import ObjetoGeneral.Objeto;
import Obstaculos.BarricadaParaEnemigos;
import Obstaculos.DestruidosPorTodos;
import Obstaculos.Obstaculo;
import TDALista.ListaDE;
import TDALista.PositionList;

public class Mapa_3 extends Mapa {

	//atributos
	
	 
	 
	//constructor
		 
	 public Mapa_3(Logica l) {
		super(l);
		mapa_siguiente = new Mapa_4(log);
	 }
		 
	 //metodos
		

	public PositionList<Objeto> obtenerObjetosIniciales(){
		PositionList<Objeto> L = new ListaDE<Objeto>();
		 
		EnemigoTorreta enemy = new EnemigoTorreta (log , 15 , 70 , 3 , powerups[4]);
		L.addLast(enemy);
		cantEnemigos++;
	
		enemy = new EnemigoTorreta (log , MAX_X - 50 , 70 , 3 , powerups[4]);
		L.addLast(enemy);
		cantEnemigos++;
		
		L.addLast(new BarricadaParaEnemigos (log , 760  , MAX_Y / 2 - 10));
		L.addLast(new BarricadaParaEnemigos (log , 570 -30, MAX_Y / 2 - 10));
		L.addLast(new BarricadaParaEnemigos (log , 380 -30, MAX_Y / 2 - 10));
		L.addLast(new BarricadaParaEnemigos (log , 190 -60, MAX_Y / 2 - 10));
		
		
		L.addLast(new DestruidosPorTodos (log, 227, MAX_Y /2 + 60));
		L.addLast(new DestruidosPorTodos (log, 444 , MAX_Y /2 + 60));
		L.addLast(new DestruidosPorTodos (log, 651, MAX_Y /2 + 60));
			
		for(int i=0 ; i<8 ; i++) {
			EnemigoADesarmar ene = new EnemigoADesarmar( log, 200 + i*95 , 50  , 3 , powerups[ i % CANT_MAX_PREMIOS].clone());
			L.addLast(ene);
			cantEnemigos++;
		}
		
		for(int i=0 ; i<8 ; i++) {
			EnemigoKamikazeMixto ene = new EnemigoKamikazeMixto( log, 150 + i*95 , 200  , 3 , powerups[ i % CANT_MAX_PREMIOS].clone());
			L.addLast(ene);
			cantEnemigos++;
		}
		
		for(int i=0 ; i<8 ; i++) {
			EnemigoKamikazeAleatorio ene = new EnemigoKamikazeAleatorio( log, 175 + i*85 , 125  , 3 , powerups[ i % CANT_MAX_PREMIOS].clone());
			L.addLast(ene);
			cantEnemigos++;
		}
			
		return L;
	 }
		 
}
