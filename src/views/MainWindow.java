package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public MainWindow() {
		setLayout(new BorderLayout());
		setBackground(Color.BLUE);
		setTitle("Game v1.0");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
}