package Disparos;

import java.awt.Color;

import Inteligencias.InteligenciaDisparoRicochetSans;
import Logica.Logica;

public class DisparoSansRicochetEnemigo extends DisparoEnemigo{

	//atributos
	
	
	
	//constructor
	public DisparoSansRicochetEnemigo(Logica l, double v, int f, double x, double y, double direc) {
		super(l, v, f, x, y, direc);
		inteligencia = new InteligenciaDisparoRicochetSans(this , direc);
		
		etiqueta.setBackground(Color.ORANGE);
	}

	//metodos
	
	public void morir() {
		log.eliminarObjeto(this);
	}

}
