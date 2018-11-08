package Mapas;

import EnemigosConcretos.EnemigoADesarmar;
import EnemigosConcretos.EnemigoConArma;
import EnemigosConcretos.EnemigoKamikazeAleatorio;
import EnemigosConcretos.EnemigoKamikazeDirigido;
import EnemigosConcretos.EnemigoTorreta;
import Logica.Logica;
import ObjetoGeneral.Objeto;
import TDALista.ListaDE;
import TDALista.PositionList;

public class Mapa_3 extends Mapa {

	//atributos
	
	 
	 
	//constructor
		 
	 public Mapa_3(Logica l) {
		super(l);
		mapa_siguiente = new Mapa_Sans(log);
	 }
		 
	 //metodos
		

	public PositionList<Objeto> obtenerObjetosIniciales(){
		PositionList<Objeto> L = new ListaDE<Objeto>();
		 
		EnemigoTorreta enemy = new EnemigoTorreta (log , 15 , 70 , 2 , powerups[4]);
		L.addLast(enemy);
		cantEnemigos++;
	
		enemy = new EnemigoTorreta (log , MAX_X - 50 , 70 , 2 , powerups[4]);
		L.addLast(enemy);
		cantEnemigos++;
		
		for(int i=0 ; i<5 ; i++) {
			EnemigoConArma ene = new EnemigoConArma( log, 425 + i*100 , 100  , 2 , powerups[ i % CANT_MAX_PREMIOS].clone());
			L.addLast(ene);
			cantEnemigos++;
		}
		
		for(int i=0 ; i<5 ; i++) {
			EnemigoADesarmar ene = new EnemigoADesarmar( log, 425 + i*100 , 160  , 2 , powerups[ i % CANT_MAX_PREMIOS].clone());
			L.addLast(ene);
			cantEnemigos++;
		}
		
		for(int i=0 ; i<5 ; i++) {
			EnemigoKamikazeAleatorio ene = new EnemigoKamikazeAleatorio( log, 450 + i*100 , 220  , 2 , powerups[ i % CANT_MAX_PREMIOS].clone());
			L.addLast(ene);
			cantEnemigos++;
		}
		
		return L;
	 }
		 
}
