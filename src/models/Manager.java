package models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Manager extends MyThread{

	private Player player;
	private ArrayList<Dog> dogs;
	private int time;
	private Timer timer;
	private Timer timerTwo;

	public Manager(String name) {
		super(name);
		player = new Player();
		dogs = new ArrayList<>();	
		addEnemy();
		addEnemyPitbull();
		start();
	}

	private void addEnemy() {
		timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dogs.add(new Dog("Pincher", DogType.PINCHER));
			}
		});
		timer.start();	
	}
	
	public void addEnemyPitbull() {
		timerTwo = new Timer(4000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (dogs.isEmpty()) {
					dogs.add(new Dog("Pitbull", DogType.PITBULL));
				}
			}
		});
		timerTwo.start();	
	}
	
	public ArrayList<Dog> getDogs() {
		return dogs;
	}

	public int getTime() {
		return time;
	}

	public void setTime() {
		time++;
	}
	
	public void movePlayer(int code, int posXFrame, int posYFrame){
		switch (code) {
		case 37:
			player.move(DirectionPlayer.LEFT, posXFrame, posYFrame);
			break;
		case 38:
			player.move(DirectionPlayer.UP, posXFrame, posYFrame);
			break;
		case 39:
			player.move(DirectionPlayer.RIGHT, posXFrame, posYFrame);
			break;
		case 40:
			player.move(DirectionPlayer.DOWN, posXFrame, posYFrame);
			break;
		}
	}
	
	@Override
	void executeTask() {
		try {
			checkCollisionDog();
			gameOver();
		} catch (Exception e) {
		}
	}

	public void pauseGame() {
		player.setStatusPlayer(true);
	}

	public void moveDog() {
		for (Dog dog : dogs) {
			dog.moveDog(player.getX(), player.getY());
			if (check(dog.getX(), dog.getY())) {
				dogs.remove(dog);
				System.out.println("Hey");
			}
		}
	}

	public void gameOver() {
		if (player.getLife() <= 0) {
			JOptionPane.showMessageDialog(null,"GAME OVER", "Game v1.0", JOptionPane.CLOSED_OPTION);
			stopGame();
			timer.stop();
			player.stop();
		}
	}

	private void checkCollisionDog() {
		for (Dog dog : dogs) {
			dog.moveDog(player.getX(), player.getY());
			if (check(dog.getX(), dog.getY())) {
				if (dog.getDogType().equals(DogType.PINCHER)) {
					player.setLife(player.getLife() -10 );
					dogs.remove(dog);
					System.out.println("BAN");
				}else {	
					player.setLife(0);
				}
			}
		}
	}

	public boolean checkCollisionShoot(int ex, int ey, int x, int y){
		return ((ex > x && ex < (x + 80)) || (ex + 80 > x && ex + 80 < (x + 80))) && ((ey > y) && ey < (y + 80)) || (ey + 80 > y && ey + 80 < (y + 80));
	}

	public void checkShoot(int x, int y) {
		for (Dog dog : dogs) {
			if (dog.getDogType().equals(DogType.PINCHER)) {
				if (checkCollisionShoot(dog.getX(),dog.getY(), x, y)) {
					dogs.remove(dog);
					timer.stop();
					System.out.println("eLIMINADO");
				}
			}
		}
	}

	private void stopGame() {
		for (Dog dog : dogs) {
			dog.stop();
		}
		stop();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean check(int x, int y) {
		return ((player.getX() > x && player.getX() < (x + 80)) ||
				(player.getX() + 80 > x && player.getX() + 80 < (x + 80))) && ((player.getY() > y && player.getY() < (y + 80)) || 
						(player.getY() +80 > y && player.getY() + 80 < (y + 80)));
	}
}