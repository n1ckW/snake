package core;

import java.util.Random;

public class Game {
	
	public final int width, height;
	private Grid grid;
	private Snake snake;
	private Random ran;
	private boolean running, paused;
	
	public Game (int w, int h, int startX, int startY) {
		width = w;
		height = h;
		grid = new Grid(w, h);	
		snake = new Snake(startX, startY, grid);
		running = true;
		paused = false;
		ran = new Random();
		spawnFood();
	};	

	public void tick() {
		Direction dir = snake.getHeadDirection();	
		Tile tar = grid.getTile(snake.getHead().x + dir.xMove, snake.getHead().y + dir.yMove);
		
		if (tar.solid) {
			System.out.println("invalid move");
			running = false;
		} else {
			boolean eating = tar.equals(Tile.FOOD);
			snake.tick(eating);
			if (eating) 
				spawnFood();
		}
	}		
	
/**
 *  this is dangerous<p>
 * 	bad RNG = infinite loop<p>
 * 	
 */
	private void spawnFood() {
		int rx = ran.nextInt(height);
		int ry = ran.nextInt(width);
		while (!grid.getTile(rx, ry).equals(Tile.EMPTY)) {
			rx = ran.nextInt(height);
			ry = ran.nextInt(width);
		}
		grid.setTile(rx, ry, Tile.FOOD);
	}
		
	public Grid getGrid() {
		return grid;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public boolean isPaused() {
		return paused;
	}
	
	public void pause() {
		paused = true;
	}
	
	public void unpause() {
		paused = false;
	}

	public Snake getSnake() {
		return snake;
	}
}
