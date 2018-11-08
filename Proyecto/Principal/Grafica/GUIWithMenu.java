package Grafica;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUIWithMenu extends GUI {
	
	public GUIWithMenu() {
		super();
		intializeMenu();
	}

	private void intializeMenu() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Opciones");
		JMenuItem restartItem = new JMenuItem("Reiniciar");
		JMenuItem logoutItem = new JMenuItem("Salir");
		menu.add(restartItem);
		menu.add(logoutItem);
		menubar.add(menu);
		this.setJMenuBar(menubar);
	}
	
	
	
}
