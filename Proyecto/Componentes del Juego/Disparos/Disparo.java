package Disparos;

import java.awt.*;
import Logica.*;
import javax.swing.*;

import Inteligencias.InteligenciaDisparo;
import ObjetoGeneral.Objeto;
import Visitors.Visitor;

public abstract class Disparo extends Objeto {

	//atributos
	public final static int ANCHO = 5;
	public final static int ALTO = 20;
	
	protected double velocidad_disparo;

	protected int fuerza_impacto;
	
	
	//constuctor
	
	public Disparo (Logica l,double v ,int f, double x , double y , double angulo) {
		
		//----PARTE LOGICA DEL DISPARO----
		
		super(l);
		
		velocidad_disparo = v;
		fuerza_impacto = f;
		
		inteligencia = new InteligenciaDisparo(this , angulo); //direc = direccion del disparo, medida en grados. (entre 0 y 360)
		
		
		//----PARTE GRAFICA DEL DISPARO----
		
		rec = crear_rectangulo(x, y, ANCHO, ALTO);
		
		etiqueta = new JLabel();
		
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.WHITE);
		
	}
	
	//metodos
	
	public double getVelocidad() {
		return velocidad_disparo;
	}
	
	public int getFuerzaImpacto() {
		return fuerza_impacto;
	}
	
	
	
	//---forma de morir---
	
	public abstract void morir(); //se lo deja abstracto para que cada disparo pueda hacer algo diferente al morir
	
	//----VISITOR----
	
	public void serVisitado(Visitor v) {
		//cuerpo vacio ya que no tiene efecto que un disparo seaVisitado por alguien
	}
	
}
