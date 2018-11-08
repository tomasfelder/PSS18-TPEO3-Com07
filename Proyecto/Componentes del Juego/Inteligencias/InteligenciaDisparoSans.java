package Inteligencias;
import Disparos.*;
import EnemigosConcretos.SANS;
public  class InteligenciaDisparoSans extends Inteligencia{

	//atributos
	
	protected Disparo disp;
	double direccion; //direccion del disparo, medida en grados. (entre 0 y 360)
	
	protected long time;
	protected long tiempo_de_vida;
	//constructor

	public InteligenciaDisparoSans(Disparo d , double direc) {
		disp = d;
		direccion = Math.toRadians(direc);
		time = System.currentTimeMillis();
		tiempo_de_vida = SANS.DURACION_ATAQUE_ESPECIAL;
		
	}
	
	//metodos
	
	public void accionar() {
		
		long elapsed_time = System.currentTimeMillis() - time;
		
		if(elapsed_time > tiempo_de_vida) {
			disp.morir();
		}
		
		fueraDeLimite();
		disp.setX(disp.getX() + disp.getVelocidad() * Math.cos(direccion));
		disp.setY(disp.getY() + disp.getVelocidad() * ( - Math.sin(direccion))); //negativo ya que para subir hay que restar en Y
		
		
	}
	
	private void fueraDeLimite() {
		if(disp.getX() < 0)
			disp.setX(ANCHO_MAPA - disp.getAncho() - 10);
		else
			if ( disp.getX() > ANCHO_MAPA - 10 )
				disp.setX(0);
			else
				if (disp.getY() < 0)
					disp.setY(ALTO_MAPA - disp.getAlto());
				else
					if (disp.getY() > ALTO_MAPA)
						disp.setY(0);
					
	}

}
