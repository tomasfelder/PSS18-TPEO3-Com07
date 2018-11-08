package EnemigosConcretos;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Armas.ArmaSans;
import Disparos.DisparoSansEnemigo;
import Disparos.DisparoSansRicochetEnemigo;
import Inteligencias.InteligenciaSans;
import Logica.Logica;
import Mapas.Mapa;
import NivelEnemigos.NivelSans;
import Personajes.Enemigo;
import Premios.Premio;

public class SANS extends Enemigo{

	//atributos
	
	protected final static int ANCHO = 120;
	protected final static int ALTO = 160;
	public final static long DURACION_ATAQUE_ESPECIAL = 15000;
	private int numero_ataque_especial;
	
	//constructor
	
	public SANS(Logica l, double x, double y, int nivel, Premio P) {
		
		//----PARTE LOGICA DE SANS----
		
		super(l, x, y, nivel, P);
		
		miNivel = new NivelSans();
		HP = miNivel.getHP();
		
		miArma = new ArmaSans(log);
		inteligencia = new InteligenciaSans(this);
		numero_ataque_especial = 0;
	
		
		//----PARTE GRAFICA DE SANS----
		
		rec = this.crear_rectangulo(x, y, ANCHO, ALTO); //redefine el rectangulo de Enemigo
		imagen = new ImageIcon("Sprites/Sans_stand.gif");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
		
		
	}

	//metodos
	
	public void crear_disparos() {
		double x = 0; //ya que el arma de sans se encarga de crearlos en X
		double y = getY() + this.getAlto() - miArma.getVelocidadDisparo();
		
		miArma.disparar(x, y);
	}
	
	public void lanzar_poder() {
		
		
		
		switch(numero_ataque_especial) {
		case 0 : shootFromBelow();
				 break;
		case 1 : blasters();
				 break;
		case 2 : multipleShots();
				 break;
				
		}
		numero_ataque_especial = (numero_ataque_especial + 1) % 3;
		
	}
	
	public void shootFromBelow() {
		
		for(int i=0 ; i<10 ; i++) {
			log.agregarObjeto(new DisparoSansEnemigo(log, 15 , 5 ,(20 + 90 * i) % (Mapa.MAX_X - 20) , Mapa.MAX_Y / 1.25 ,70));
		}
		
	}
	
	public void blasters() {
		BlasterManager BM = new BlasterManager(log);
		BM.start();
	}
	
	public void multipleShots() {
		
		for(int i=0 ; i < 11 ; i++)
			log.agregarObjeto(new DisparoSansRicochetEnemigo(log, 10 , 5 , Mapa.MAX_X / 3 , Mapa.MAX_Y / 2 , i*30 ));
		
		for(int i=0 ; i < 11 ; i++)
			log.agregarObjeto(new DisparoSansRicochetEnemigo(log, 10 , 5 , Mapa.MAX_X / 3 * 2 , Mapa.MAX_Y / 2 , i*30 ));
		
	}
	
	
}
