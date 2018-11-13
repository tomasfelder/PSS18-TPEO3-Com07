package Personajes;
import Visitors.*;
import Escudos.*;
import Armas.*;
import Inteligencias.*;
import Logica.*;
import ObjetoGeneral.Objeto;

import java.awt.Rectangle;

import javax.swing.*;

import Disparos.Disparo;
import Disparos.DisparoComunJugador;
import Disparos.DisparoJugador;
public class Jugador extends Personajes {
	
	//--------------ATRIBUTOS----------------
	protected final static int ANCHO = 30;
	protected final static int ALTO = 30;
	public final static int maxHP = 10;
	public final static int VidasIniciales = 4;
	
	protected int vidas; //al perder toda su HP, el jugador pierde una vida
	
	protected int velocidad_movimiento;
	
	protected Escudo mi_escudo;
	protected Arma miArma;
	
	boolean ya_mori;
	//--------------CONSTRUCTOR--------------
	
	public Jugador (Logica l,double x , double y ) { 
		
		//---parte logica del jugador---
		super(l);
		visitor = new VisitorJugador();
		inteligencia = new InteligenciaJugador(this);
		miArma = new ArmaClasicaJugador(log); 
		mi_escudo = new SinEscudo();
		
		HP = maxHP;
		velocidad_movimiento = 12;
		vidas = VidasIniciales;
		
		ya_mori = false;
		
		//---parte grafica del jugador---
		
		rec = crear_rectangulo(x,y,ANCHO,ALTO);
		imagen = new ImageIcon("Sprites/Frisk.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
		
		
	}
	
	//----------------METODOS----------------
	
	
	//VELOCIDAD de movimiento
	
	public double getVelocidadMovimiento() {
		return velocidad_movimiento;
	}
	
	
	public void setVelocidadMovimiento(int n) {
		velocidad_movimiento = n;
	}
	
	//ARMA
	
	public Arma getArma() {
		return miArma;
	}
	
	public void setArma(Arma a) {
		miArma = a;
	}
	
	//Vidas , HP y escudo
	
	public Escudo getEscudo() {
		return mi_escudo;
	}
	
	public void setEscudo(Escudo e){
		mi_escudo = e;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getVidas() {
		return vidas;
	}
		
	public void quitarHP(int n) {
		int daño = mi_escudo.getDaño(n);
		
		if ( HP - daño > 0)
			HP -= daño;
		else {
			vidas--;
			HP = maxHP;
		}
		if(vidas<0 && !ya_mori) { //este chequeo hace falta porque en ocasiones se buguea y se ejecuta morir 2 veces
			HP = 0;				  //por ejemplo cuando me impactan 2 enemigoskamikazes, y ya me habia matado el primero.
			vidas = 0;
			morir();
			ya_mori = true; 
		}
		
	}
	
	//-----MOVIMIENTO------
		
	
	public void mover (int dir) {
		inteligencia.setDireccion(dir);
	}
	
	//------DISPARO------
	
	
	public void disparar(int shoot) {
		inteligencia.setShoot(shoot);
	}
	
	public void crearDisparo() {
		double x = getX() + getAncho() / 2;
		double y = getY();
		
		miArma.disparar(x, y);
	}
	
	//---FORMA DE MORIR DEL JUGADOR---
	
	public void morir() {
		log.perder();
	}
	
	
	//-----VISITOR-----
	
	public void serVisitado(Visitor v) {
		v.afectarJugador(this);
	}

	
	
}
