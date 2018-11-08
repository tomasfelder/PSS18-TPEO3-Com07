package EnemigosConcretos;
import Logica.*;
import Personajes.Enemigo;
import Premios.*;
import Inteligencias.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Armas.*;
public class EnemigoTorreta extends Enemigo {

	//atributos
	
	
	//constructor
	
	
	public EnemigoTorreta(Logica l, double x , double y, int nivel , Premio p) {
		
		//----PARTE LOGICA DE EnemigoTorreta----
		super(l,x,y,nivel,p);
		inteligencia = new InteligenciaEnemigoTorreta(this);
		miArma = new ArmaMetralladoraEnemigo(log);
		
		
		//----PARTE GRAFICA DE EnemigoTorreta----
		
		imagen = new ImageIcon("Sprites/Enemy_2.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen); 
	}
	
	//metodos
	
	
}
