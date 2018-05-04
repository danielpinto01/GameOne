package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import views.MainWindow;

public class Controller implements KeyListener{

	private MainWindow mainWindow;
	
	public Controller() {
		mainWindow = new MainWindow(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}