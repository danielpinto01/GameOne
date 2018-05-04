package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Player;

public class JPanelInit extends JPanel{
	
	private static final Image PLAYER = new ImageIcon("src/images/personLeft.gif").getImage();
	private static final long serialVersionUID = 1L;
	private Player player;
	
	public JPanelInit() {
		setBackground(Color.LIGHT_GRAY);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(PLAYER, player.getX(), player.getY(), 100, 100, this);
	}
	
	public void setCoordinates(Player player) {
		this.player = player; 
	}
}