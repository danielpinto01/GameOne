package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controllers.Controller;
import models.Dog;
import models.Player;

public class JPanelInit extends JPanel{

	private static final Image PLAYER = new ImageIcon("src/images/personLeft.gif").getImage();
	private static final Image DOG = new ImageIcon("src/images/dog.gif").getImage();
	private static final long serialVersionUID = 1L;
	private Player player;
	private int time;
	private ArrayList<Dog> dogs;

	public JPanelInit(Controller controller) {
		player = new Player();
		setBackground(Color.LIGHT_GRAY);
		dogs = new ArrayList<>();
		addMouseListener(controller);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("src/images/danger.png");
		Cursor c = toolkit.createCustomCursor(image , new Point(this.getX(), this.getY()), "img");
		setCursor (c);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (player != null) {
			g.drawImage(PLAYER, player.getX(), player.getY(), 80, 80, this);
			g.drawString("Time:" + String.valueOf(time), 320, 30);
		}
		if (dogs!= null) {
			for (Dog dog : dogs) {
				g.drawImage(DOG, dog.getX(), dog.getY(), 80, 80, this);
			}
		}
		
		g.drawString("Life: " + player.getLife(), 400, 30);
		
		if (player.getLife() < 30) {
			g.setColor(Color.RED);
		}else if (player.getLife() >= 30 && player.getLife() < 70) {
			g.setColor(Color.ORANGE);
		}else {
			g.setColor(Color.GREEN);
		}
		g.fill3DRect(460, 15, (player.getLife()*180)/100, 30, true);
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setCoordinates(Player player, ArrayList<Dog> dogs) {
		this.player = player;
		this.dogs = dogs;
	}
}