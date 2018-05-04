package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Dog;
import models.Player;

public class JPanelInit extends JPanel{
	
	private static final Image PLAYER = new ImageIcon("src/images/personLeft.gif").getImage();
	private static final Image DOG = new ImageIcon("src/images/dog.gif").getImage();
	private static final long serialVersionUID = 1L;
	private Player player;
	private Dog dog;
	private int time;
	
	public JPanelInit() {
		setBackground(Color.LIGHT_GRAY);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (player != null) {
			g.drawImage(PLAYER, player.getX(), player.getY(), 80, 80, this);
			g.drawString("Time:" + String.valueOf(time), 30, 30);
		}
		if (dog != null) {
			g.drawImage(DOG, dog.getX(), dog.getY(), 80, 80, this);
			g.drawString("Time:" + String.valueOf(time), 30, 30);
		}
		
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public void setCoordinates(Player player, Dog dog) {
		this.player = player;
		this.dog = dog;
	}
}