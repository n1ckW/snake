package core;

public class Snake {
	
	private Direction headDir = Direction.UP;
	private Direction prevHeadDir = Direction.UP;
	private Direction nextDir = Direction.UP;
	private SnakeBodyBlock snakeHead;
	public final Grid grid;	
	
	public Snake(int x, int y, Grid g) {
		snakeHead = new SnakeBodyBlock(x, y);
		grid = g;
	}		

	public synchronized void tick(boolean eating) {		
		int tarX = snakeHead.x + headDir.xMove;
		int tarY = snakeHead.y + headDir.yMove;		
		
		SnakeBodyBlock newhead = new SnakeBodyBlock(tarX, tarY);
		newhead.setNext(snakeHead);
		snakeHead.setPrev(newhead);
		snakeHead = newhead;
		prevHeadDir = headDir;
		setHeadDirection(nextDir);
		
		grid.setTile(tarX, tarY, Tile.SNAKE);
		
		if(!eating) {
			SnakeBodyBlock tail = snakeHead.getTail();
			grid.setTile(tail.x, tail.y, Tile.EMPTY);
			tail.getPrev().setNext(null);
		}
	}	
	
	public SnakeBodyBlock getHead() {
		return snakeHead;
	}	
	
	public Direction getHeadDirection() {
		return headDir;
	}		
	
	public synchronized void setHeadDirection (Direction newDir) {
		if (newDir.getOpposite() != prevHeadDir) headDir = newDir;
		nextDir = newDir;
	}
}
