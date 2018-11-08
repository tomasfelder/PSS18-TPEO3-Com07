package NivelEnemigos;
import java.awt.*;

import javax.swing.ImageIcon;
/**
 * Esta clase solo se encargara de inicializar los atributos del enemigo acorde al nivel que posee.
 * @author Fede iar
 *
 */
public abstract class NivelEnemigo {
	
	//atributos
	
	
	protected double velocidad_movimiento;
	protected int HP;
	protected int puntosQueDa;
	protected int fuerza_impacto;
	
	//constructor
	
	public NivelEnemigo() {
		
	}
	
	//metodos
	
	
	public int getFuerzaImpacto() {
		return fuerza_impacto;
	}
	
	public double getVelocidadMovimiento() {
		return velocidad_movimiento;
	}
	
	public int getHP() {
		return HP;
	}

	public int getPuntaje() {
		return puntosQueDa;
	}
	
	
	
	
	
	
}
