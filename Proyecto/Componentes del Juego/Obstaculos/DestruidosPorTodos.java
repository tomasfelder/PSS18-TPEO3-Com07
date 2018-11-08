package Obstaculos;

import java.awt.Color;

import javax.swing.JLabel;

import Logica.Logica;
import Visitors.Visitor;

public class DestruidosPorTodos extends Obstaculo{

	//atributos
	
	
	//constructor
	
	public DestruidosPorTodos(Logica l, double x, double y) {
		
		//----PARTE LOGICA DE DestruidosPorTodos----
		
		super(l, x, y);
		
		
		//----PARTE GRAFICA DE DestruidosPorTodos----
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.lightGray);
		
	}
	
	
	//metodos
	
	public void serVisitado(Visitor v) {
		v.afectarDestruidosPT(this);
	}

}
