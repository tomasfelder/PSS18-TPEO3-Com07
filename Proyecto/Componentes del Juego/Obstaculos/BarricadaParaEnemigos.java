package Obstaculos;

import java.awt.Color;

import javax.swing.JLabel;

import Logica.Logica;
import Visitors.Visitor;

public class BarricadaParaEnemigos extends Obstaculo{

	//atributos
	
	
	//constructor
	
	public BarricadaParaEnemigos(Logica l, double x, double y) {
		
		//----PARTE LOGICA DE BarricadaParaEnemigos----
		
		super(l, x, y);
		
		
		//----PARTE GRAFICA DE BarricadaParaEnemigo----
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.DARK_GRAY);
	}

	
	//metodos
	
	
	public void serVisitado(Visitor v) {
		v.afectarBarricadaPE(this);
	}

}
