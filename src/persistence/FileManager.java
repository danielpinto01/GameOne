package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.Dog;
import models.DogType;
import models.Player;

public class FileManager {

	private static final File FILE_ENEMY = new File("src/dog.txt");
	private static final File FILE_PLAYER = new File("src/player.txt");

	public void writeFileEnemy(ArrayList<Dog> dogs) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_ENEMY));
		for (Dog dog : dogs) {
			bufferedWriter.write(dog.getX() + "," + dog.getY() + "," + dog.getDogType().toString()+ ",");
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}

	public void writeFilePlayer(Player player) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PLAYER));
		bufferedWriter.write(player.getX() + "," + player.getY() + "," + player.getLife() + "," + player.getTimeGmePlayer());
		bufferedWriter.newLine();
		bufferedWriter.close();
	}

	public ArrayList<Dog> readEnemys() throws NumberFormatException, IOException{
		ArrayList<Dog> dogList = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_ENEMY));
		String data = "";
		while ((data = bufferedReader.readLine()) != null) {
			String[] information = data.split(",");
			DogType dogType = information[2].equals(DogType.PINCHER.toString()) ? DogType.PINCHER:DogType.PITBULL;
			dogList.add(new Dog(Integer.parseInt(information[0]), Integer.parseInt(information[1]), dogType));
		}
		bufferedReader.close();
		return dogList;
	}

	public Player readPlayer() throws IOException {
		Player player = null;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PLAYER));
		String data = "";
		while ((data = bufferedReader.readLine()) != null) {
			String[] information = data.split(",");
			player = new Player(Integer.parseInt(information[0]), Integer.parseInt(information[1]), Integer.parseInt(information[2]),Integer.parseInt(information[3]));
		}
		bufferedReader.close();
		return player;
	}
}