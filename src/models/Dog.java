package models;

public class Dog {

	private int x;
	private int y;

	public Dog() {
		this.x = x;
		this.y = y;
	}

	public void moveDog(int posX, int posY) {
		if (x < posX) {
			x += 5;
		}if (x > posX) {
			x -= 5;
		}if (y < posY) {
			y += 5;
		}if (y > posY) {
			y -= 5;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}