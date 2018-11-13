package Mapas;

import EnemigosConcretos.EnemigoConArma;
import EnemigosConcretos.EnemigoKamikazeDirigido;
import EnemigosConcretos.EnemigoTorreta;
import Logica.Logica;
import ObjetoGeneral.Objeto;
import Obstaculos.BarricadaParaEnemigos;
import Obstaculos.DestruidosPorTodos;
import Obstaculos.Obstaculo;
import TDALista.ListaDE;
import TDALista.PositionList;

public class Mapa_2 extends Mapa {

	//atributos
	
	 
	 
	//constructor
		 
	 public Mapa_2(Logica l) {
		super(l);
		mapa_siguiente = new Mapa_3(log);
	 }
		 
	 //metodos
		

	public PositionList<Objeto> obtenerObjetosIniciales(){
		PositionList<Objeto> L = new ListaDE<Objeto>();
		 
		EnemigoTorreta enemy = new EnemigoTorreta (log , 20 , 70 , 2 , powerups[4]);
		L.addLast(enemy);
		cantEnemigos++;
	
		enemy = new EnemigoTorreta (log , MAX_X - 50 , 70 , 2 , powerups[4]);
		L.addLast(enemy);
		cantEnemigos++;

		L.addLast(new BarricadaParaEnemigos (log , 220 , MAX_Y / 2 - 10));
		L.addLast(new BarricadaParaEnemigos (log , 475 , MAX_Y / 2 - 10));
		L.addLast(new BarricadaParaEnemigos (log , 730 , MAX_Y / 2 - 10));
			
		L.addLast(new DestruidosPorTodos (log, MAX_X - Obstaculo.ANCHO - 75 , MAX_Y /2 + 60));
		L.addLast(new DestruidosPorTodos (log, MAX_X - Obstaculo.ANCHO - 305 , MAX_Y /2 + 60));
		L.addLast(new DestruidosPorTodos (log, MAX_X - Obstaculo.ANCHO - 545 , MAX_Y /2 + 60));
		L.addLast(new DestruidosPorTodos (log, MAX_X - Obstaculo.ANCHO - 775 , MAX_Y /2 + 60));
				
		
		for(int i=0 ; i<8 ; i++) {
			EnemigoConArma ene = new EnemigoConArma( log, 200 + i*100 , 40  , 2 , powerups[ i % CANT_MAX_PREMIOS].clone());
			L.addLast(ene);
			cantEnemigos++;
		}
		
		for(int i=0 ; i<7 ; i++) {
			EnemigoKamikazeDirigido ene = new EnemigoKamikazeDirigido( log, 250 + i*100 , 115  , 1 , powerups[ i % CANT_MAX_PREMIOS].clone());
			L.addLast(ene);
			cantEnemigos++;
		}
		
		for(int i = 0 ; i<7 ; i++) {
			EnemigoConArma ene = new EnemigoConArma(log , 210 + i*110 , 200 , 1 , powerups[ i % CANT_MAX_PREMIOS].clone());
			 L.addLast(ene);
			 cantEnemigos++;
		}
		
		 
		return L;
	 }
		 
}
