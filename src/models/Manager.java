package models;

public class Manager extends MyThread{
	
	private Player player;
	private Dog dog;
	private int time;

	public Manager(String name) {
		super(name);
		player = new Player();
		dog = new Dog();
		start();
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
	
	public void pauseGame() {
		player.setStatusPlayer(true);
	}
	
	public void moveDog() {
		dog.moveDog(player.getX(), player.getY());
	}
	
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	public boolean check() {
		return player.check(dog.getX(), dog.getY());
	}

	@Override
	void executeTask() {
		moveDog();
	}
}