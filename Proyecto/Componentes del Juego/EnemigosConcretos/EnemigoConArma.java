package EnemigosConcretos;

import Armas.*;

import javax.swing.*;


import Personajes.*;
import Premios.Premio;
import Inteligencias.*;
import Logica.*;
public class EnemigoConArma extends Enemigo {

	//atributos
	
	
	
	//constructor
	
	public EnemigoConArma(Logica l, double x, double y , int nivel , Premio P) {
		
		//----parte logica del EnemigoConArma---
		
		super(l,x,y,nivel,P);
		inteligencia = new InteligenciaEnemigoConArma(this);
		miArma = new ArmaClasicaEnemigo(log); 
		
		
		
		//----parte grafica del EnemigoConArma----
		
		imagen = new ImageIcon("Sprites/Enemy_2.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen); 
	}
	
	//metodos
	
	
	
	
}
