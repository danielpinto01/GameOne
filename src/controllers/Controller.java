package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingWorker;

import models.Manager;
import views.MainWindow;

public class Controller implements KeyListener{

	private MainWindow mainWindow;
	private Manager manager;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		manager = new Manager("player");
		start();
	}
	
	private void start() {
		SwingWorker<Void, Void> refreshBoard = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				while (true) {
					mainWindow.setGame(manager.getPlayer());
					Thread.sleep(100);
				}
			}
		};
		refreshBoard.execute();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
		manager.movePlayer(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}