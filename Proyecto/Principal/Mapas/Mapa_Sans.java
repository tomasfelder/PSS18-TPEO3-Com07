package Mapas;
import Grafica.*;
import Logica.*;
import ObjetoGeneral.*;
import TDALista.*;
import Personajes.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import EnemigosConcretos.*;
import Obstaculos.*;
public class Mapa_Sans extends Mapa {

	 //atributos
	
	 
	 
	 //constructor
	 
	 public Mapa_Sans(Logica l) {
		super(l);
		mapa_siguiente = null;
	}
	 
	 //metodos
	

	public PositionList<Objeto> obtenerObjetosIniciales(){
		
		mostrarDialogoSans(); //importante: si se usa este mapa como primer nivel, comentar esta instruccion para no tener
								  //			que esperar los sleeps que hay en GUI
		
		PositionList<Objeto> L = new ListaDE<Objeto>();
		 
		SANS sans = new SANS(log , MAX_X / 2 + 150 , 50 , -1 , powerups[0]);
		L.addLast(sans);
		cantEnemigos++;
		
		
		
		 return L;
	 }
	 
	private void mostrarDialogoSans() {
		try {
			JLabel lblDialogoSans = new JLabel();
			lblDialogoSans.setBounds(325, 20 , 407, 209);
			lblDialogoSans.setIcon(new ImageIcon("Sprites/Sans_Dialog_1.png"));
			log.agregarLabel(lblDialogoSans);
	
			Thread.sleep(3500);
		
			lblDialogoSans.setIcon(new ImageIcon("Sprites/Sans_Dialog_2.png"));
			lblDialogoSans.setBounds(325, 20, 405, 185);
		
			Thread.sleep(3500);
		
			log.removerLabel(lblDialogoSans);
		
			Thread.sleep(300);
		
			lblDialogoSans.setIcon(new ImageIcon("Sprites/Sans_Dialog_3.png"));
			lblDialogoSans.setBounds(320, 175, 405, 193);
			log.agregarLabel(lblDialogoSans);
		
			Thread.sleep(2500);
		
			log.removerLabel(lblDialogoSans);
		}
	
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
