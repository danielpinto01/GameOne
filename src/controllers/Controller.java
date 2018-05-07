package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import models.Manager;
import views.MainWindow;

public class Controller implements KeyListener, MouseListener{

	private MainWindow mainWindow;
	private Manager manager;
	private boolean finalGame = true;
	private Timer timer;

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
					mainWindow.setGame(manager.getPlayer(), manager.getDogs());
					Thread.sleep(100);
				}
				return null;
			}
		};
		refreshBoard.execute();
	}

	public void countTime() {
		timer = new Timer(1000, new ActionListener() {
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
	public void keyPressed(KeyEvent e) {
		manager.movePlayer(e.getKeyCode(), mainWindow.getjPanelInit().getWidth(), mainWindow.getjPanelInit().getHeight());
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		try {
			manager.checkShoot(e.getX(), e.getY());
			
		} catch (Exception e2) {}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}