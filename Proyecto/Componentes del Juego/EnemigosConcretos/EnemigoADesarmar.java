package EnemigosConcretos;
import java.awt.Color;
import Armas.*;

import javax.swing.*;

import Disparos.DisparoEnemigo;
import Personajes.Enemigo;
import Premios.Premio;
import Inteligencias.*;
import Logica.*;
public class EnemigoADesarmar extends Enemigo {

	//atributos
	
	
	
	//constructor
	
	public EnemigoADesarmar(Logica l, double x, double y , int nivel , Premio P) {
		
		//----PARTE LOGICA DEL EnemigoConArma---
		
		super(l,x,y,nivel,P);
		inteligencia = new InteligenciaEnemigoConArma(this);
		miArma = new ArmaDobleEnemigo(log); 
		
		
		
		//----PARTE GRAFICA DEL EnemigoConArma----
		
		imagen = new ImageIcon("Sprites/Enemy_5.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen); 
	}
	
	//metodos
	
	public void quitarHP(int n) {
		super.quitarHP(n);
		if(HP <= miNivel.getHP() / 2)
			miArma = new ArmaDummy(log);
	}
	
}
