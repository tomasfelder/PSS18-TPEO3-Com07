package Grafica;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FrameAgregarComentarios extends JFrame {
	
	private JTextField textField;
	private String nombre;
	private String comentario;
	private String fechaActual;
	
	
	public FrameAgregarComentarios() {
		getContentPane().setLayout(null);
		this.setBounds(500, 40, 400, 350);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 90, 311, 122);
		getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(50, 32, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIngreseNombre = new JLabel("Ingrese Nombre");
		lblIngreseNombre.setBounds(50, 13, 116, 16);
		getContentPane().add(lblIngreseNombre);
		
		JLabel lblAgregueUnComentario = new JLabel("Agregue un comentario");
		lblAgregueUnComentario.setBounds(50, 67, 153, 16);
		getContentPane().add(lblAgregueUnComentario);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre = textField.getText();
				comentario = textArea.getText();
				fechaActual = new Date().toString();
				guardarEnArchivo();
			}
		});
		btnGuardar.setBounds(264, 225, 97, 25);
		getContentPane().add(btnGuardar);
	}
	
	private void guardarEnArchivo() {
		Path path = FileSystems.getDefault().getPath("", "comentarios.txt");
		File fout = new File(path.toString());
		FileWriter fr = null;
		try {
			fr = new FileWriter(fout,true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedWriter bw = new BufferedWriter(fr);
		try {
			bw.write(nombre);
			bw.newLine();
			bw.write(comentario);
			bw.newLine();
			bw.write(fechaActual);
			bw.newLine();
			bw.newLine();
			bw.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
