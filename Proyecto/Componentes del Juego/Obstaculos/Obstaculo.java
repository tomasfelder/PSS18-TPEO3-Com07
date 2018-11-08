package Obstaculos;

import Inteligencias.InteligenciaDummyPermanente;
import Logica.Logica;
import ObjetoGeneral.Objeto;
import Visitors.VisitorDummy;

public abstract class Obstaculo extends Objeto {

	//atributos
	public final static int ANCHO  = 60;
	public final static int ALTO = 20;
	protected final static int MAX_HP = 20;
	
	protected int HP;
	protected boolean ya_mori;
	//constructor
	
	public Obstaculo(Logica l , double x ,double y) {
		
		//----PARTE LOGICA DEL OBSTACULO----
		super(l);
		inteligencia = new InteligenciaDummyPermanente();
		visitor = new VisitorDummy();
		
		HP = MAX_HP;
		ya_mori = false;
		
		//----PARTE GRAFICA DEL OBSTACULO----
		
		rec = crear_rectangulo(x,y,ANCHO,ALTO);
	}
	
	//metodos

	public void quitarHP(int n) {
		if( HP - n > 0)
			HP -= n;
		else {
			if(!ya_mori) { //este chequeo se hace porque cuando impacta un disparo del arma doble lo "mata" 2 veces
				morir();   //es decir, se ejecuta morir() 2 veces.
				ya_mori = true; 
			}
			
		}
	}
	
	public void morir() {
		log.eliminarObjeto(this);
	}
	
	
}
