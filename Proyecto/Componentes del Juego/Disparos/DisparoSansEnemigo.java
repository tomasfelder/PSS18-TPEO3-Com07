package Disparos;

import java.awt.Color;

import Inteligencias.InteligenciaDisparoSans;
import Logica.Logica;

public class DisparoSansEnemigo extends DisparoEnemigo{

	//atributos
	
	
	
	//constructor
	public DisparoSansEnemigo(Logica l, double v, int f, double x, double y, double direc) {
		super(l, v, f, x, y, direc);
		inteligencia = new InteligenciaDisparoSans(this ,direc);
		
		etiqueta.setBackground(Color.cyan);
	}

	//metodos
	
	public void morir() {
		log.eliminarObjeto(this);
	}

}
