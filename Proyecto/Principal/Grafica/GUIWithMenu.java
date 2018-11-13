package Grafica;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class GUIWithMenu extends JFrame {
	
	public GUIWithMenu() {
		super();
		getContentPane().setLayout(null);
		this.setBounds(250, 40, 400, 350);
		
		JButton btnIniciarJuego = new JButton("Iniciar Juego");
		btnIniciarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI gui = new GUI();
				ocultarPantalla();
				gui.setVisible(true);
			}
		});
		btnIniciarJuego.setBounds(154, 80, 129, 25);
		getContentPane().add(btnIniciarJuego);
		
		JButton btnAgregarComentario = new JButton("Agregar Comentario");
		btnAgregarComentario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFrameComentarios();
			}
		});
		btnAgregarComentario.setBounds(138, 118, 160, 25);
		getContentPane().add(btnAgregarComentario);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnSalir.setBounds(154, 156, 129, 25);
		getContentPane().add(btnSalir);
	}
	
	private void ocultarPantalla() {
		this.setVisible(false);
	}

	public void close() {
		System.exit(0);
	}
	
	private void abrirFrameComentarios() {
		JFrame commentsFrame = new FrameAgregarComentarios();
		commentsFrame.setVisible(true);
	}
	
}
