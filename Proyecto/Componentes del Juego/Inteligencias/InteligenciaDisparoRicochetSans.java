package Inteligencias;
import Disparos.*;
import EnemigosConcretos.SANS;
public  class InteligenciaDisparoRicochetSans extends Inteligencia{

	//atributos
	
	protected Disparo disp;
	double angulo; //angulo del disparo, medida en grados. (entre 0 y 360)
	
	protected long time;
	protected long tiempo_de_vida;
	//constructor

	public InteligenciaDisparoRicochetSans(Disparo d , double angle) {
		disp = d;
		angulo = angle;
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
		disp.setX(disp.getX() + disp.getVelocidad() * Math.cos( Math.toRadians(angulo) ) );
		disp.setY(disp.getY() + disp.getVelocidad() * ( - Math.sin( Math.toRadians(angulo) ) ) ); //negativo ya que para subir hay que restar en Y
		
		
	}
	
	private void fueraDeLimite() {
		if(disp.getX() < 0) {
			disp.setX(0);
			angulo = 180 - angulo;
		}
		else
			if ( disp.getX() > ANCHO_MAPA - 20 ) {
				disp.setX(ANCHO_MAPA - 20);
				angulo = 180 - angulo;
			}
			else
				if (disp.getY() < 0) {
					disp.setY(0);
					angulo = 360 - angulo;
				}
				else
					if (disp.getY() > ALTO_MAPA - disp.getAlto() - 20) {
						disp.setY(ALTO_MAPA - disp.getAlto() - 20);
						angulo = 360 - angulo;
					}
	}

}
