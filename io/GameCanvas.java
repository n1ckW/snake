package io;

import java.awt.Canvas;
import java.awt.Graphics;

import core.Grid;

public class GameCanvas extends Canvas {	
	private Grid grid;	
	
	public GameCanvas(Grid g) {
		super();
		this.grid = g;
	}	
	
	@Override
	public void paint(Graphics g) {
		for (int x = 0; x < grid.width; x++) {			
			for (int y=0; y < grid.height; y++) {				
				g.setColor(grid.getTile(x, y).color);
				g.fillRect(25 + 25*x, 25 + 25*y, 25, 25);
			}
		}	
	}	
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}

}
