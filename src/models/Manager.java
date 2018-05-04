package models;

public class Manager extends MyThread{
	
	private Player player;

	public Manager(String name) {
		super(name);
		player = new Player();
		start();
	}
	
	public void moveHero(int code){
		switch (code) {
		case 37:
			player.move(DirectionPlayer.LEFT);
			break;
		case 38:
			player.move(DirectionPlayer.UP);
			break;
		case 39:
			player.move(DirectionPlayer.RIGHT);
			break;
		case 40:
			player.move(DirectionPlayer.DOWN);
			break;
		}
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	void executeTask() {
	}

}