package EnemigosConcretos;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Inteligencias.InteligenciaEnemigoKamikazeDirigido;
import Logica.Logica;
import Personajes.*;
import Premios.Premio;
public class EnemigoKamikazeDirigido extends Enemigo{

	//atributos
	
	//constructor
	
	public EnemigoKamikazeDirigido(Logica l, double x, double y, int nivel, Premio P) {
		
		//---- PARTE LOGICA DEL EnemigoKamikazeDirigido ----
		
		super(l, x, y, nivel, P);
		inteligencia = new InteligenciaEnemigoKamikazeDirigido(this , log.getJugador());
		
		//---- PARTE GRAFICA DEL EnemigoKamikazeDirigido ----
		
		imagen = new ImageIcon("Sprites/Enemy_3.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
	}
	
	//metodos
	

}
