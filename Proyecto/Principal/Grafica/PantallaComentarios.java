package Grafica;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PantallaComentarios extends JFrame{
	public PantallaComentarios() {
		
		JPanel middlePanel = new JPanel ();
	    middlePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Comentarios" ) );

	    // create the middle panel components

	    JTextArea display = new JTextArea ( 16, 58 );
	    display.setEditable ( false ); // set textArea non-editable
	    
	    //add comments
	    Path path=FileSystems.getDefault().getPath("", "comentarios.txt");
		try {
			String comentarios=new String(Files.readAllBytes(path));
			
			display.setText(comentarios);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    JScrollPane scroll = new JScrollPane ( display );
	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    
	    

	    //Add Textarea in to middle panel
	    middlePanel.add ( scroll );

	    // My code
	    JFrame frame = new JFrame ();
	    frame.add ( middlePanel );
	    frame.pack ();
	    frame.setLocationRelativeTo ( null );
	    frame.setVisible ( true );
		
		
	}
}
