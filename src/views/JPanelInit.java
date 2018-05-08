package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controllers.Controller;
import models.Dog;
import models.DogType;
import models.Player;

public class JPanelInit extends JPanel{

	private static final Image PLAYER = new ImageIcon("src/images/catTwo.png").getImage();
	private static final Image DOG = new ImageIcon("src/images/newDog.png").getImage();
	private static final Image DOG_MASTER = new ImageIcon("src/images/newDogTwo.png").getImage();
	private static final long serialVersionUID = 1L;
	public static final int SIZE_SHOOT = 40;
	private Player player;
	private int time;
	private ArrayList<Dog> dogs;

	public JPanelInit(Controller controller) {
		player = new Player();
		setBackground(Color.decode("#FFA000"));
		dogs = new ArrayList<>();
		addMouseListener(controller);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("src/images/ball.png");
		Cursor c = toolkit.createCustomCursor(image , new Point(this.getX(), this.getY()), "img");
		setCursor (c);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (player != null) {
			g.drawImage(PLAYER, player.getX(), player.getY(), 80, 80, this);
			g.setFont(new Font("Agency FB", Font.BOLD, 20));
			g.drawString("Time:" + String.valueOf(time), 320, 35);
		}
		if (dogs!= null) {
			for (Dog dog : dogs) {
				if (dog.getDogType().equals(DogType.PINCHER)) {
					g.drawImage(DOG, dog.getX(), dog.getY(), 80, 80, this);
				}else {
					g.drawImage(DOG_MASTER, dog.getX(), dog.getY(), 100, 100, this);
					
				}
			}
		}
		g.setFont(new Font("Agency FB", Font.BOLD, 20));
		g.drawString("Life: " + player.getLife(), 400, 35);
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