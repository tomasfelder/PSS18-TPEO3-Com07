package EnemigosConcretos;

import Logica.Logica;
import Personajes.Enemigo;
import Premios.Premio;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Inteligencias.*;
public class EnemigoKamikazeMixto extends Enemigo {

	public EnemigoKamikazeMixto(Logica l, double x, double y, int nivel, Premio P) {
		
		//----PARTE LOGICA DEL EnemigoKamikazeMixto----
		super(l, x, y, nivel, P);
		inteligencia = new InteligenciaEnemigoKamikazeDirigido(this , log.getJugador());
		
		//----PARTE GRAFICA DEL EnemigoKamikazeMixto----
		
		imagen = new ImageIcon("Sprites/Enemy_4.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
	}

	public void quitarHP(int n) {
		super.quitarHP(n);
		if(HP <= miNivel.getHP() / 2)
			inteligencia = new InteligenciaEnemigoKamikazeAleatorio(this);
	}
}
