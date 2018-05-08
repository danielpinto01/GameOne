package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import models.Manager;
import persistence.FileManager;
import views.MainWindow;

public class Controller implements KeyListener, MouseListener{

	private MainWindow mainWindow;
	private Manager manager;
	private boolean finalGame = true;
	private Timer timer;
	private Timer autoSave;
	private FileManager fileManager;

	public Controller() {
//		mainWindow = new MainWindow(this);
		manager = new Manager("player");
		fileManager = new FileManager();
		init();
		countTime();
		autoSave();
		start();
	}

	public void init() {
		int option = JOptionPane.showConfirmDialog(mainWindow, "Nueva partida");
		if (option == JOptionPane.NO_OPTION) {
			try {
				manager.setPlayer(fileManager.readPlayer());
				manager.setDogs(fileManager.readEnemys());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if (option == JOptionPane.CANCEL_OPTION) {
			System.exit(0);
		}
		mainWindow = new MainWindow(this);
	}
	

	private void start() {
		SwingWorker<Void, Void> refreshBoard = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				while (!manager.isStop()) {
					mainWindow.setGame(manager.getPlayer(), manager.getDogs());
					Thread.sleep(100);
				}
				
				return null;
			}
		};
		refreshBoard.execute();
	}

	private void autoSave() {
		autoSave = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					fileManager.writeFileEnemy(manager.getDogs());
					fileManager.writeFilePlayer(manager.getPlayer());
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		autoSave.start();
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