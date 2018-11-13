package Logica;

import TDALista.*;
import Personajes.*;

import Mapas.*;
import ObjetoGeneral.*;

import javax.swing.JLabel;

import Grafica.*;

public class Logica {

	//atributos
	
	private PositionList<Objeto> lista_agregar;
	private PositionList<Objeto> lista_eliminar;
	private PositionList<Objeto> lista_objetos;
	
	private Mapa mapa;
	private GUI gui;
	private Tiempo tiempo;
	
	private int puntaje  ,  cantEnemigos; 
	
	private Jugador jugador;
	
	//constructor
	
	public Logica( GUI g) {
		
		lista_objetos = new ListaDE<Objeto>();
		lista_agregar = new ListaDE<Objeto>();
		lista_eliminar = new ListaDE<Objeto>();
		
	    gui = g;

	}
	
	//metodos
	
	public Jugador getJugador() {
		return jugador;
	}
	public int getHPJugador() {
		return jugador.getHP();
	}
	public int getVidasJugador() {
		return jugador.getVidas();
	}
	public boolean jugadorEstaVivo() {
		return jugador!=null;
	}
	

	public int getPuntaje() {
		return puntaje;
	}
	
	public PositionList<Objeto> getListaObjetos(){
		return lista_objetos;
	}
	
	public void setPuntaje(int p) {
		puntaje = p;
	}
	
	public int cantEnemigos() {
		return cantEnemigos;
	}
	
	public void setCantEnemigos(int cant) {
		cantEnemigos = cant;
	}
	
	public boolean hayEnemigos() {
		return cantEnemigos > 0;
	}
	
	
	//----COMIENZO DEL JUEGO----
	
	public void empezarJuego() {
		puntaje = 0;
		cantEnemigos = 0;
		
		jugador = new Jugador (this, Mapa.MAX_X/2 , Mapa.MAX_Y - 70 );
		gui.add(jugador.getLabel());
		
		mapa = new Mapa_1(this);
		
		crearObjetosIniciales();
		
		tiempo = new Tiempo(this);
		tiempo.start();
		
		gui.requestFocus();
	}
	
	//----CAMBIO DE MAPAS----
	
	public boolean hayMapa() {
		if(mapa==null)
			return false;
		else
			return true;
	}
	
	public void getMapaSiguiente() {
		mapa = mapa.getMapaSiguiente();
		if(mapa!=null) 
			crearObjetosIniciales();
	}
	
	private void crearObjetosIniciales() { 
		resetearMapa();
		lista_agregar = mapa.obtenerObjetosIniciales();
		cantEnemigos = mapa.cantEnemigosVivos();
		
		lista_agregar.addLast(jugador); //necesito agregarlo manualmente cada vez que empieza un nuevo mapa ya que
										//fue removido de la lista de objetos cuando se reseteo el mapa.
		
	}
	
	private void resetearMapa() {
		try {
			while(!lista_objetos.isEmpty()) {
				Position<Objeto> po = lista_objetos.first();
				
				gui.remove(po.element().getLabel());
				lista_objetos.remove(po);
			}
		}
		catch(InvalidPositionException | EmptyListException e) {
			e.printStackTrace();
		}
		gui.repintar();
	}
	
	//----AGREGACION Y ELIMINACION DE OBJETOS----
	
	public void agregarObjeto(Objeto o) {
		lista_agregar.addFirst(o);
	}
	
	public void eliminarObjeto(Objeto o) {
		lista_eliminar.addLast(o);
	}
	
	public void actualizarObjetos() {
		
		for(Position<Objeto> po : lista_agregar.positions()) {
			lista_objetos.addLast(po.element());
			gui.add(po.element().getLabel());
		}
		
		lista_agregar = new ListaDE<Objeto>(); //ya agregamos lo que teniamos que agregar, reiniciamos la lista
		
		
		for(Position<Objeto> po : lista_eliminar.positions()) {
			eliminar(po.element());
		}
		
		lista_eliminar = new ListaDE<Objeto>(); //ya eliminamos lo que habia que eliminar, reiniciamos la lista
		
		gui.repintar();
	}	
	
	private void eliminar(Objeto o) {
		try {
			for(Position<Objeto> po : lista_objetos.positions()) {
				if(po.element() == o) {
					
					gui.remove(po.element().getLabel());
					lista_objetos.remove(po);
					break;
				}
			}
		}
		catch(InvalidPositionException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//----MOVIMIENTO DE LOS OBJETOS----
	
	
	public void lanzarDisparoJugador(int shoot) { 
		if(jugador!=null)
			jugador.disparar(shoot);
	}
	
	public void moverJugador (int direccion) { 
		if(jugador!=null)
			jugador.mover(direccion);
	}
	
	public void accionarObjetos() {
			
		for(Objeto o : lista_objetos) {
			o.accionar();
		}
		gui.repintar();
		
	}
	
	//----DETECCION DE COLISIONES----
	
	public void detectarColisiones() {
		Objeto objs[] = new Objeto[lista_objetos.size()]; //necesito un arreglo asi tengo un indice para
														  //recorrerlo 2 veces sin tener repetidos
		int i=0;
		
		for(Position<Objeto> po : lista_objetos.positions()) {
			objs[i] = po.element();
			i++;
		}
		
		for(i=0; i<objs.length ; i++) {
			for(int j=i+1 ; j<objs.length ; j++) {
				if(objs[i].getRectangulo().intersects(objs[j].getRectangulo())) { // si true quiere decir que colisionaron
					
					objs[i].chocar(objs[j]); 
					objs[j].chocar(objs[i]);
					/*es necesario hacer las 2 colisiones, ya que si por ejemplo un "enemigo" CHOCA A un "disparo"
					esto no tendrá efecto y no pasa nada, pero sí viceversa.
					*/
				}
			}
		}
	}
	
	//----VICTORIA , DERROTA Y DIALOGOS----
	
	public void perder() {
		eliminarTodo();
		jugador = null;
		gui.mostrarPanelDerrota();
	}
	
	private void eliminarTodo() {
		resetearMapa();
		lista_agregar = new ListaDE<Objeto>();
		lista_eliminar = new ListaDE<Objeto>();
	}
	
	public void ganar() {
		eliminarTodo();
		jugador = null;
		gui.mostrarPanelVictoria();
	}

	
	public void agregarLabel(JLabel l) {
		gui.getContentPane().add(l);
		gui.repintar();
	}
	
	public void removerLabel(JLabel l) {
		gui.remove(l);
		gui.repintar();
	}
}
