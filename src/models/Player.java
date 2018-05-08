package models;

import java.util.Random;
import models.DirectionPlayer;

public class Player extends MyThread{

	private static final int MOVE_UNITS = 50;
	private int x;
	private int y;
	private boolean statusPlayer;
	private int life;
	private int timeGmePlayer;

	public Player() {
		super("player");
		x = new Random().nextInt(500);
		y = new Random().nextInt(500);
		life = 100;
		start();
	}
	
	public Player(int posX, int posY, int life, int timeGamePlayer) {
		super("player");
		this.x = posX;
		this.y = posY;
		this.life = life;
		this.timeGmePlayer = timeGamePlayer;
	}

	public void move(DirectionPlayer directionPlayer, int posXFrame, int posYFrame){
		if (!statusPlayer) {
			switch (directionPlayer) {
			case DOWN:
				if (y+MOVE_UNITS < posYFrame) {
					y += MOVE_UNITS;
				}
				break;
			case LEFT:
				if (x- MOVE_UNITS > 0) {
					x -= MOVE_UNITS;
				}
				break;
			case RIGHT:
				if (x+ MOVE_UNITS+6 < posXFrame) {
					x += MOVE_UNITS;
				}
				break;
			case UP:
				if (y-MOVE_UNITS > 0) {
					y -= MOVE_UNITS;
				}
				break;
			default:
				break;
			}
		}
	}

	public int getTimeGmePlayer() {
		return timeGmePlayer;
	}

	public void setTimeGmePlayer(int timeGmePlayer) {
		this.timeGmePlayer = timeGmePlayer;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isStatusPlayer() {
		return statusPlayer;
	}

	public void setStatusPlayer(boolean statusPlayer) {
		this.statusPlayer = statusPlayer;
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	@Override
	void executeTask() {
	}
}