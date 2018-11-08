package Disparos;
import Visitors.*;
import Logica.*;
import ObjetoGeneral.*;
import Personajes.*;
import Inteligencias.*;
public abstract class DisparoEnemigo extends Disparo {

    //atributos
	
	//constructor
	
		public DisparoEnemigo(Logica l , double v , int f , double x , double y,double direc) {
			super(l,v,f,x,y,direc);
			visitor = new VisitorDisparoEnemigo(this); //esto lo diferencia con un disparo jugador
			
		}
		
	//metodos
		 
		
		
}
