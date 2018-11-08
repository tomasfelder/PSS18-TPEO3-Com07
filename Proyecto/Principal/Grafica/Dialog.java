package Grafica;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Dialog extends JDialog {
	public Dialog(JFrame owner) {
		  super(owner, true); // makes the dialog modal
		  // ...
		}
}
