package Grafica;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIWithMenu extends GUI {
	
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem restartItem;
	private JMenuItem logoutItem;
	
	public GUIWithMenu() {
		super();
		intializeMenu();
	}

	private void intializeMenu() {
		
		menubar = new JMenuBar();
		menu = new JMenu("Opciones");
		restartItem = new JMenuItem("Reiniciar");
		restartItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reiniciar();
			}
		});
		logoutItem = new JMenuItem("Salir");
		logoutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		
		menu.add(restartItem);
		menu.add(logoutItem);
		menubar.add(menu);
		this.setJMenuBar(menubar);
	}
	
	public void close() {
		System.exit(0);
	}
	
	
	
}
