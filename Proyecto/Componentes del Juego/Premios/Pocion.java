package Premios;

import java.awt.Color;

import javax.swing.JLabel;

import Logica.Logica;
import Personajes.Jugador;

public class Pocion extends Premio{

	//atributos
	protected int vida_que_cura;
	
	//constructor
	
	public Pocion(double x, double y, double velCaida, Logica l) {
		
		//----PARTE LOGICA DE Pocion----
		super(x, y, velCaida, l);
		
		vida_que_cura = Jugador.maxHP / 2;
		
		//----PARTE GRAFICA DE Pocion----
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.GREEN);
	}

	
	//metodos
	
	public void activarPremio(Jugador j) {
		j.quitarHP( - (vida_que_cura) );
		this.morir();
	}


	public Premio clone() {
		return new Pocion(getX() , getY() , this.getVelocidadDeCaida() , log);
	}

	//atributos
	
	
	//constructor 
}
