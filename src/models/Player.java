package models;

import java.util.Random;
import models.DirectionPlayer;

public class Player extends MyThread{
	
	private static final int MOVE_UNITS = 50;
	private int x;
	private int y;
	
	public Player() {
		super("player");
		x = new Random().nextInt(500);
		y = new Random().nextInt(500);
		start();
	}
	
	public void move(DirectionPlayer directionPlayer){
		switch (directionPlayer) {
		case DOWN:
			y += MOVE_UNITS;
			break;
		case LEFT:
			x -= MOVE_UNITS;
			break;
		case RIGHT:
			x += MOVE_UNITS;
			break;
		case UP:
			y -= MOVE_UNITS;
			break;
		default:
			break;
		}
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	void executeTask() {
	}
}