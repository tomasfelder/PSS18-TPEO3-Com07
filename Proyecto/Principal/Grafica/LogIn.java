package Grafica;

import javax.swing.JFrame;

import Grafica.GUI.OyenteTeclado;
import Logica.Logica;
import Mapas.Mapa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame{
	
	private boolean logeado=false;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	
	private Map<String,String> usuarios=new HashMap<String,String>();
	
	public LogIn() {
		super("Log In");
		getContentPane().setLayout(null);
		this.setBounds(250, 50, 400, 250);
		this.setResizable(false);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(95, 80, 63, 14);
		getContentPane().add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(196, 77, 86, 20);
		getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setBounds(95, 122, 91, 14);
		getContentPane().add(lblContrasenia);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(196, 119, 86, 20);
		getContentPane().add(passwordField);
		
		usuarios.put("comision7", "sarasa");
		usuarios.put("admin", "1234");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textFieldUsuario.getText()!=null){
					String contrasenia=usuarios.get(textFieldUsuario.getText());
					char[] contraseniaIngresada=passwordField.getPassword();
					String contraseniaIngresadaParseada= String.valueOf(contraseniaIngresada);
					
					if ((contraseniaIngresadaParseada!=null) && (contraseniaIngresadaParseada.equals(contrasenia)))
					{
						System.out.println((textFieldUsuario.getText()));
						if(textFieldUsuario.getText().equals("admin")){
							close();
							new PantallaComentarios();
							
						}
						else{
							GUIWithMenu gui = new GUIWithMenu();
							gui.setVisible(true);
							close();
						}
						logeado=true;
						
					}
					else JOptionPane.showMessageDialog(null, "Usuario incorrecto", "Error", JOptionPane.WARNING_MESSAGE);
				}
					
			}
		});
		btnAceptar.setBounds(161, 173, 89, 23);
		getContentPane().add(btnAceptar);
		
		
	}
	 private void close(){
		 this.setVisible(false);
	 }
}
