package views;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelInit extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public JPanelInit() {
		setBackground(Color.LIGHT_GRAY);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawOval(200, 200, 50, 50);
	}
}