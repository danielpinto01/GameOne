package models;

public class Dog extends MyThread{

	private int x;
	private int y;
	private String name;
	private DogType dogType;

	public Dog(String name, DogType dogType) {
		super(name);
		setX(0);
		setY(0);
		this.name = name;
		this.dogType = dogType;
		start();
	}
	
	public Dog(int posX, int posY, DogType dogType) {
		super("n");
		this.x = posX;
		this.y = posY;
		this.dogType = dogType;
		start();
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
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DogType getDogType() {
		return dogType;
	}

	public void setDogType(DogType dogType) {
		this.dogType = dogType;
	}

	@Override
	void executeTask() {
	}
}