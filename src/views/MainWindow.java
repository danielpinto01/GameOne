package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.Controller;
import models.Dog;
import models.Player;

public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanelInit jPanelInit;
	private JPanelGameOver jPanelGameOver;
	
	public MainWindow(Controller controller) {
		setLayout(new BorderLayout());
		setBackground(Color.BLUE);
		setTitle("Game v1.0");
		setIconImage(new ImageIcon("src/images/icon.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		addKeyListener(controller);
		
		init(controller);
		setFocusable(true);
		setVisible(true);
	}
	
	public void setTime(int time) {
		jPanelInit.setTime(time);
	}

	public void init(Controller controller) {
		jPanelInit = new JPanelInit(controller);
		add(jPanelInit);
	}
	
	public void setGame(Player player, ArrayList<Dog> dogs) {
		jPanelInit.setCoordinates(player, dogs);
		jPanelInit.repaint();
	}

	public JPanelInit getjPanelInit() {
		return jPanelInit;
	}
	
	public void gameOver() {
		remove(jPanelInit);
		jPanelGameOver = new JPanelGameOver();
		add(jPanelGameOver, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
}