package Escudos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Logica;
import Personajes.Jugador;
import Visitors.Visitor;

public class EscudoInvulnerable extends Escudo{

	//atributos
	
	//constructor
	
	public EscudoInvulnerable() {
		
	}
	
	//metodos
	
	public int getDa�o(int da�o_recibido) {
		return 0;
	}

	
}
