package core;

public class Grid {
		
	public final int width, height;
	private Tile[][] grid;		
	
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		grid = new Tile[width][height];	
		
		for (int x = 0; x<width; x++) {
			for (int y = 0; y<height; y++) {
				grid[x][y] = Tile.EMPTY;
			}
		}
	}		
	
	public void setTile(int x, int y, Tile t) {
		grid[x][y] = t;
	}	
	
	public Tile getTile(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) {
			return Tile.BLOCK;
		}
		else return grid[x][y];
	}	
}
