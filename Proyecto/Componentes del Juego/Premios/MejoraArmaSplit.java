package Premios;

import Logica.Logica;
import Personajes.Jugador;
import Visitors.Visitor;

import java.awt.Color;

import javax.swing.JLabel;

import Armas.*;
public class MejoraArmaSplit extends Premio{
	
	
	//atributos
	
	protected Arma nuevaArma;
	
	//constructor
	public MejoraArmaSplit(double x, double y, double velCaida, Logica l) {
		
		//---parte logica de la MejoraArmaSplit---
		super(x, y, velCaida, l);
		nuevaArma = new ArmaSplitJugador(log); 
		
		
		//---parte grafica de la MejoraArmaSplit---
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.RED);
		
	}
	
	//metodos

	public Premio clone() {
		return new MejoraArmaSplit( this.getX() , this.getY() , this.velocidadDeCaida , log);
	}
	
	public void activarPremio(Jugador j) {
		
		j.setArma(nuevaArma);
		
		morir();
	}

}
