package ObjetoGeneral;
import Inteligencias.*;
import Visitors.*;
import java.awt.Rectangle;
import Mapas.*;
import Personajes.Enemigo;

import javax.swing.*;
import Logica.*;

public abstract class Objeto {
	
	//atributos
		
	protected Rectangle rec;
	protected JLabel etiqueta;
	protected ImageIcon imagen;
	
	protected double pos_x;
	protected double pos_y;
	
	protected Inteligencia inteligencia;
	protected Logica log;
	protected Visitor visitor;
	
	//constructor
	
	public Objeto(Logica l) {
		log = l;
	}
	
	//metodos
	
	
	public Rectangle getRectangulo() {
		return rec;
	}
	
	public double getX() {
		return pos_x;
	}
	
	public double getY() {
		return pos_y;
	}
	
	public int getAncho() {
		return rec.width;
	}
	
	public int getAlto() {
		return rec.height;
	}
	
	public void setX(double i) {
		pos_x = i;
		int rounded_x = (int) Math.round(pos_x);
		rec.x = rounded_x;
		etiqueta.setBounds(rec);
	}
	
	public void setY (double i) {
		pos_y = i;
		int rounded_y = (int) Math.round(pos_y);
		rec.y = rounded_y;
		etiqueta.setBounds(rec);
	}
	
	public JLabel getLabel() {
		return etiqueta;
	}
	
	public Rectangle crear_rectangulo(double x , double y , int ancho , int alto) {
		pos_x = x;
		pos_y = y;
		int rounded_x = (int) Math.round(pos_x);
		int rounded_y = (int) Math.round(pos_y);
		Rectangle R = new Rectangle(rounded_x,rounded_y,ancho,alto);
		
		return R;
	}
	
	
	/**
	 * método que sera redefinido por cada clase depende como reacciona al ser eliminado
	 */
	public abstract void morir();
	
	
	//----INTELIGENCIA----
	
	public Inteligencia getInteligencia() {
		return inteligencia;
	}
	
	public void setInteligencia(Inteligencia i) {
		inteligencia = i;
	}
	
	/**
	* todos los objetos recurren a su inteligencia para ACCIONAR
	*/
	public  void accionar() {
		inteligencia.accionar();
	}
			
	//---VISITOR---
	
	
	public void chocar(Objeto o) {
		o.serVisitado(this.visitor);  // sería el "aceptar(Visitor v)"
	}
	
	public abstract void serVisitado(Visitor v);
	
	
	
	
}
