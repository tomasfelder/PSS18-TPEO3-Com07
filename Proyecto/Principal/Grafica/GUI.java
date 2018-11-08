package Grafica;
import Mapas.*;
import Personajes.Jugador;

import java.awt.*;

import javax.net.ssl.ManagerFactoryParameters;
import javax.swing.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.border.*;

import Logica.Logica;

import javax.swing.SwingConstants.*;

 public class GUI extends JFrame {
 	
 	//ATRIBUTOS
	 
	 private JLabel lblHp , lblPuntaje , lblVidas , numVidas , numPuntaje ,
	 			    lblDerrota , lblTryAgain , lblSansDerrota, lblVictoria , lblDialogoSans;
	 
	 private JButton btnSi;
	 private JProgressBar BarraVida;
	 
	 
	 private Logica log;
	
	 
	//CONSTRUCTOR
	 
	public GUI() {
		super("Galaxian");
		initialize();
	}
 	
	private void initialize() {
		
		//CREA EL FRAME
		crearFrame();
		crearPanelSuperior();
		
		//SE CREA LA PARTE LOGICA
		log = new Logica(this);
		
		
		//EMPIEZA EL JUEGO
		
		log.empezarJuego();
		
		
		OyenteTeclado OT = new OyenteTeclado();
		this.addKeyListener(OT);
	}
	
	public void repintar() {
		if(log.jugadorEstaVivo()) {
			numPuntaje.setText(""+log.getPuntaje());
			BarraVida.setValue(log.getHPJugador());
			numVidas.setText(""+log.getVidasJugador());
		}
		repaint();
	}
	
	private void crearFrame() {
		this.setResizable(false);
		this.getContentPane().setBackground(Color.BLACK);
		this.getContentPane().setLayout(null);
		this.setBounds(250, 50, Mapa.MAX_X, Mapa.MAX_Y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	private void crearPanelSuperior() {
		
		//lbl HP:
			
		lblHp = new JLabel("HP:");
		lblHp.setForeground(Color.WHITE);
		lblHp.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblHp.setBounds(6, 11, 32, 14);
		getContentPane().add(lblHp);
				
		//crea la barra de vida
		
		BarraVida = new JProgressBar();
		BarraVida.setForeground(Color.GREEN);
		BarraVida.setBackground(Color.WHITE);
		
		BarraVida.setMaximum(Jugador.maxHP);
		BarraVida.setMinimum(0);
		BarraVida.setValue(Jugador.maxHP);
		
		BarraVida.setBounds(38, 10, 85, 14);
		getContentPane().add(BarraVida);
		
		//arma el puntaje
		
		lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPuntaje.setBounds(350, 6, 65, 20);
		getContentPane().add(lblPuntaje);
		
		numPuntaje = new JLabel("0");
		numPuntaje.setForeground(Color.WHITE);
		numPuntaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numPuntaje.setBounds(415, 9, 46, 14);
		getContentPane().add(numPuntaje);
		
		
		//arma las vidas
		
		lblVidas = new JLabel("Vidas:");
		lblVidas.setForeground(Color.WHITE);
		lblVidas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVidas.setBounds(820, 9, 46, 14);
		getContentPane().add(lblVidas);
		
		numVidas = new JLabel(""+Jugador.VidasIniciales);
		numVidas.setForeground(Color.WHITE);
		numVidas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numVidas.setBounds(865, 9, 46, 14);
		getContentPane().add(numVidas);
		
		
		
		
	}
	
	public void mostrarPanelDerrota() {
		
		lblDerrota = new JLabel("DERROTA");
		lblDerrota.setFont(new Font("Tahoma", Font.PLAIN, 64));
		lblDerrota.setForeground(Color.RED);
		lblDerrota.setBounds(312, 10, 291, 171);
		getContentPane().add(lblDerrota);
		
		lblSansDerrota = new JLabel();
		lblSansDerrota.setBounds(200, 150 , 418 , 189);
		lblSansDerrota.setIcon(new ImageIcon("Sprites/Sans_Defeat.png"));
		getContentPane().add(lblSansDerrota);
		
		lblTryAgain = new JLabel("Intentar de nuevo?");
		lblTryAgain.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTryAgain.setForeground(Color.WHITE);
		lblTryAgain.setBounds(350, 380, 239, 54);
		getContentPane().add(lblTryAgain);
		
		btnSi = new JButton("Si");
		btnSi.setBackground(Color.RED);
		btnSi.setForeground(Color.BLACK);
		btnSi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSi.setBounds(407, 500, 89, 23);
		getContentPane().add(btnSi);
		
		OyenteBoton OB = new OyenteBoton();
		btnSi.addActionListener(OB);
		
		repintar();
	}
	
	private void eliminarPanelDerrota() {
		this.remove(lblDerrota);
		this.remove(lblSansDerrota);
		this.remove(lblTryAgain);
		this.remove(btnSi);
		repintar();
	}
	
	public void mostrarPanelVictoria() {
		lblVictoria = new JLabel("\u00A1VICTORIA!");
		lblVictoria.setFont(new Font("Tahoma", Font.PLAIN, 66));
		lblVictoria.setForeground(Color.GREEN);
		lblVictoria.setBounds(250, 181, 355, 98);
		getContentPane().add(lblVictoria);
		repintar();
	}
	
	public void mostrarDialogosSans() {
		try {
			
			lblDialogoSans = new JLabel();
			lblDialogoSans.setBounds(325, 20 , 407, 209);
			lblDialogoSans.setIcon(new ImageIcon("Sprites/Sans_Dialog_1.png"));
			getContentPane().add(lblDialogoSans);
		
			Thread.sleep(3500);
			
			lblDialogoSans.setIcon(new ImageIcon("Sprites/Sans_Dialog_2.png"));
			lblDialogoSans.setBounds(325, 20, 405, 185);
			
			Thread.sleep(3500);
			
			this.remove(lblDialogoSans);
			
			Thread.sleep(300);
			
			lblDialogoSans.setIcon(new ImageIcon("Sprites/Sans_Dialog_3.png"));
			lblDialogoSans.setBounds(320, 175, 405, 193);
			getContentPane().add(lblDialogoSans);
			
			Thread.sleep(2500);
			
			this.remove(lblDialogoSans);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		repintar();
	}
	
	//-------------------------------------------
	//-------------OYENTES-----------------------
	//-------------------------------------------
	
	class OyenteTeclado implements KeyListener{
	
		int direccion = 0; //1 es izquierda, 2 es derecha
		int shoot = 0; //0 no dispara, 1 dispara.
		
		public void keyTyped(KeyEvent e) {
			
		}
		
		public void keyPressed(KeyEvent e) {
			
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				direccion = 1;
			}
			else 
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					direccion = 2;
				}
				else 
					if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER) 
						shoot = 1;
					
			log.lanzarDisparoJugador(shoot);
			log.moverJugador(direccion);
		}
		
		public void keyReleased(KeyEvent e) {
			
			
			if (e.getKeyCode() == KeyEvent.VK_LEFT && direccion==1) {
				direccion=0;
			}
			else 
				if (e.getKeyCode() == KeyEvent.VK_RIGHT && direccion==2) {
					direccion=0;
				}
				else
					if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER)
						shoot=0;
				
			log.lanzarDisparoJugador(shoot);
			log.moverJugador(direccion);
		}
		

	}
	
	class OyenteBoton implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			eliminarPanelDerrota();
			log.empezarJuego();
		}
	}
	
	
	
}