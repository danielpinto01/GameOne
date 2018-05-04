package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.Controller;
import models.Dog;
import models.Player;

public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanelInit jPanelInit;
	
	
	public MainWindow(Controller controller) {
		setLayout(new BorderLayout());
		setBackground(Color.BLUE);
		setTitle("Game v1.0");
		setIconImage(new ImageIcon("src/images/icon.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		addKeyListener(controller);
		
		init();
		setFocusable(true);
		setVisible(true);
	}
	
	public void setTime(int time) {
		jPanelInit.setTime(time);
	}

	public void init() {
		jPanelInit = new JPanelInit();
		add(jPanelInit);
	}
	
	public void setGame(Player player, Dog dog) {
		jPanelInit.setCoordinates(player, dog);
		jPanelInit.repaint();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanelInit getjPanelInit() {
		return jPanelInit;
	}
}