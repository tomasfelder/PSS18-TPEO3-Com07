package Inteligencias;
import java.util.Random;
import Personajes.*;

public class InteligenciaEnemigoKamikazeAleatorio extends InteligenciaEnemigo {

	//atributos
	private final static int TIEMPO_ESPERA = 4000;
	private final double POS_INICIAL;
	
	private boolean me_pase;
	private boolean me_tiro;
	
	protected Enemigo ene;
	private long time;
		
	//constructor
	
	public InteligenciaEnemigoKamikazeAleatorio(Enemigo e) {
		super();
		ene = e;
		time = System.currentTimeMillis();
		
		POS_INICIAL = e.getY();
		me_pase = false;
		me_tiro = false;
	}
	
	//metodos
	
	public void accionar() {
		long elapsed_time = System.currentTimeMillis() - time;
		if(elapsed_time > TIEMPO_ESPERA) {
			
			if(!me_tiro) {
				Random ran = new Random();
				int r = ran.nextInt(3);
				if(r>=0 && r<2)
					me_tiro=true;
				else
					time = System.currentTimeMillis(); //vuelvo a esperar
			}
			
			if(me_tiro) {
				if(!me_pase)
					bajar();
				else {
					bajarEnLineaRecta();
				}
			}
			
		}
		else
			this.movimiento_estandar(ene);
			
	}
	
	private void bajarEnLineaRecta() {
		if(ene.getY() < POS_INICIAL)
			ene.setY(ene.getY() + ene.getVelocidadMovimiento() * 2 );
		else {
			ene.setY(POS_INICIAL);
			me_pase = false;
			me_tiro = false;
			time = System.currentTimeMillis();
		}
	}
	
	private void bajar() {
		if(ene.getY() + ene.getAlto() < ALTO_MAPA) {
			
			ene.setY(ene.getY() + (ene.getVelocidadMovimiento() * 3) );
				
			Random ran = new Random();
			int r = ran.nextInt(2);
			if(r==0) {
			
				if(ene.getX() + ene.getAncho() < ANCHO_MAPA) {
					ene.setX(ene.getX() + ene.getVelocidadMovimiento());
				}
				else {
					ene.setX(0);
				}
			
			}
			else {
			
				if(ene.getX() > 0) {
					ene.setX(ene.getX() - ene.getVelocidadMovimiento());
				}
				else {
					ene.setX(ANCHO_MAPA - ene.getAncho());
				}
			
			}
		
		}
		else {
			ene.setY(0);
			me_pase=true;
		}
	}
	
	
}
