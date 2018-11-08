package Premios;
import Logica.*;
import Personajes.Jugador;
import Visitors.*;

import java.awt.Color;

import javax.swing.JLabel;

import Armas.*;
public class MejoraArmaDoble extends Premio{

	//atributos
	
	protected Arma nuevaArma;
	
	//constructor
	
	public MejoraArmaDoble (double x, double y, double velCaida,Logica l) {
		
		//----parte logica de la mejora----
		
		super(x,y,velCaida,l);
		nuevaArma = new ArmaDobleJugador(log);
		
		//----parte grafica de la mejora----
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.BLUE);
	}
	
	//metodos
	
	public Premio clone() {
		return new MejoraArmaDoble( this.getX() , this.getY() , this.velocidadDeCaida , log);
	}
	
	public void activarPremio(Jugador j) {
	
		
		j.setArma(nuevaArma);
		
		morir();
	}
}
