package core;

import java.awt.Color;

public enum Tile {	
	EMPTY(Color.LIGHT_GRAY, false),
	BLOCK(Color.BLACK, true),
	SNAKE(Color.RED, true),
	FOOD(Color.GREEN, false);	
	
	public final Color color;
	public final boolean solid;
	
	private Tile(Color color, boolean solid){
		this.color = color;
		this.solid = solid;
	}
}
