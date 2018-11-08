package Disparos;
import Visitors.*;
import Inteligencias.*;

import javax.swing.ImageIcon;

import EnemigosConcretos.EnemigoConArma;
import Logica.*;
import ObjetoGeneral.*;
import Personajes.*;
import Obstaculos.*;
public abstract class DisparoJugador extends Disparo{
	
	//atributos
	
	//constructor
	
		public DisparoJugador(Logica l , double v , int f , double x , double y , double direc) {
			super(l,v,f,x,y,direc);
			visitor = new VisitorDisparoJugador(this); //esto lo diferencia con un disparo enemigo
			
			rec = crear_rectangulo(x,y,6,20);
			etiqueta.setBounds(rec);
			etiqueta.setOpaque(false);
			imagen = new ImageIcon("Sprites/Disparo.png");
			etiqueta.setIcon(imagen);
		}
		
	//metodos
	
		
		
		
}
