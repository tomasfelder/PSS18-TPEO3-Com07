package Disparos;
import Logica.*;
public class DisparoComunEnemigo extends DisparoEnemigo {

	//atributos
	
	//constructor
	
	public DisparoComunEnemigo(Logica l , double v , int f ,double x , double y , double direc) {
		super(l,v,f,x,y,direc);
	}
	
	//metodos
	
	public void morir() {
		log.eliminarObjeto(this);
	}
}
