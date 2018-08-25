package io;

import javax.swing.JFrame;

import core.Grid;
import core.Snake;

public class MainWindow extends JFrame{	
	
	private GameCanvas canvas;
	private InputManager im;	
	
	public MainWindow(Grid g, Snake s) {
		//this.addWindowListener(new WindowCloser());
		
		canvas = new GameCanvas(g);
		im = new InputManager(s);
		
		setSize(1024,768);
		setTitle("Snake!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		add(canvas);
		setVisible(true);
		
		add(im);
	}	
	

	public void update() {
		canvas.repaint();
	}	
}
