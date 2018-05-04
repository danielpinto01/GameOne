package models;

import java.util.Random;
import models.DirectionPlayer;

public class Player extends MyThread{

	private static final int MOVE_UNITS = 50;
	private int x;
	private int y;
	private boolean statusPlayer;

	public Player() {
		super("player");
		x = new Random().nextInt(500);
		y = new Random().nextInt(500);
		start();
	}

	public void move(DirectionPlayer directionPlayer, int posXFrame, int posYFrame){
		System.out.println(x + "-" + y);
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

	public boolean check(int x, int y) {
		return ((this.x > x && this.x < (x + 80))
				|| (this.x + 80 > x && this.x + 80 < (x + 80)))
				&& ((this.y > y && this.y < (y + 80))
						|| (this.y +80 > y && this.y + 80 < (y + 80)));
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

	@Override
	void executeTask() {
	}
}