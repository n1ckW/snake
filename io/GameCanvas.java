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
		final int w = grid.width;		
		for (int x = 0; x < w; x++) {			
			final int h = grid.height;			
			for (int y=0; y < h; y++) {				
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
