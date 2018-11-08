package Premios;

import java.awt.Color;
import TDALista.*;

import javax.swing.JLabel;

import Logica.Logica;
import ObjetoGeneral.Objeto;
import Personajes.Jugador;
import Visitors.*;

public class CongelamientoTiempo extends Premio{

	//atributos
	
	protected Visitor vis_2;
	
	//constructor
	
	public CongelamientoTiempo(double x, double y, double velCaida, Logica l) {
		
		//---parte logica de CongelamientoTiempo---
		
		super(x, y, velCaida, l);
		
		vis_2 = new VisitorCongelador();
		
		//---parte grafica de CongelamientoTiempo---
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.CYAN);
	}

	
	
	//metodos
	public Premio clone() {
		return new CongelamientoTiempo(this.getX() , this.getY() , this.velocidadDeCaida , log);
	}
	
	public void activarPremio(Jugador j) {
		PositionList<Objeto> lista_objetos = log.getListaObjetos();
		
		for(Objeto o : lista_objetos) {
			o.serVisitado(vis_2);
		}
		
		morir();
	}

}
