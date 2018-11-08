package EnemigosConcretos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Inteligencias.InteligenciaBlaster;
import Logica.Logica;
import NivelEnemigos.NivelBlaster;
import Personajes.Enemigo;
import Premios.Premio;

public class Blaster extends Enemigo {

	//atributos
	
	//constructor
	
	public Blaster(Logica l , double x , double y , int nivel , Premio P) { // no dropea premio, asi que el ultimo atributo puede ser null
		
		//----PARTE LOGICA DE Blaster----
		super(l,x,y,nivel,P);
		
		inteligencia = new InteligenciaBlaster(this);
		miNivel = new NivelBlaster();
		HP = miNivel.getHP();
				
		//----PARTE GRAFICA DE Blaster----
		
		rec = crear_rectangulo(x,y,45,60); //redefine el rectangulo de Enemigo
		imagen = new ImageIcon("Sprites/Blaster.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
	}
	
	public void morir() {
		log.eliminarObjeto(this); //redefine morir
	}
}
