package Inteligencias;
import Premios.*;
import Personajes.*;
public class InteligenciaEscudo extends Inteligencia {

	
	//atributos
	
	private Jugador jugador;
	private Premio premio;
	private long durabilidad;
	private long time;
	
	//constructor
	
	public InteligenciaEscudo(Jugador j , Premio p , int durabilidad) {
		jugador = j;
		premio = p;
		this.durabilidad = durabilidad;
		time = System.currentTimeMillis();
	}
	
	//metodos
	
	public void accionar() {
		long time_elapsed = System.currentTimeMillis() - time;
		
		if(time_elapsed > durabilidad)
			premio.morir();
		else {
			premio.setX(jugador.getX());
			premio.setY(jugador.getY());
		}
			
	}
}
