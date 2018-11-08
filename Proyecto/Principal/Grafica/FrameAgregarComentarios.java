package Grafica;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameAgregarComentarios extends JFrame {
	private JTextField textField;
	public FrameAgregarComentarios() {
		getContentPane().setLayout(null);
		this.setBounds(250, 40, 400, 350);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 90, 311, 122);
		getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(50, 32, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
	}
}
