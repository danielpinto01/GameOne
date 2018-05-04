package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import models.Manager;
import views.MainWindow;

public class Controller implements KeyListener{

	private MainWindow mainWindow;
	private Manager manager;
	private boolean finalGame = true;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		manager = new Manager("player");
		start();
		countTime();
	}
	
	private void start() {
		SwingWorker<Void, Void> refreshBoard = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				while (finalGame) {
					mainWindow.setGame(manager.getPlayer(), manager.getDog());
					if (manager.check()) {
						JOptionPane.showMessageDialog(null,"GAME OVER", "Game v1.0", JOptionPane.CLOSED_OPTION);
						finalGame = false;
						manager.pauseGame();
						manager.stop();
					}
					Thread.sleep(100);
				}
				return null;
			}
		};
		refreshBoard.execute();
	}
	
	public void countTime() {
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!manager.getPlayer().isStatusPlayer()) {
					manager.setTime();
					mainWindow.setTime(manager.getTime());
				}
			}
		});
		timer.start();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
//		System.out.println(mainWindow.getWidth() + "-" + mainWindow.getHeight());
		manager.movePlayer(e.getKeyCode(), mainWindow.getjPanelInit().getWidth(), mainWindow.getjPanelInit().getHeight());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}