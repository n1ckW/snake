package io;

import javax.swing.JFrame;

import core.Grid;
import core.Snake;

public class MainWindow extends JFrame{	
	
	private GameCanvas canvas;
	
	public MainWindow(Grid g, Snake s) {
		setSize(1024,768);
		setTitle("Snake!");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		canvas = new GameCanvas(g);
		add(canvas);
		setVisible(true);
		
		add(new InputManager(s));
		addWindowListener(new WindowTerminator());
	}	
	

	public void update() {
		canvas.repaint();
	}	
}
