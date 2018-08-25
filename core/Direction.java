package core;

public enum Direction {	
	UP(0,-1),
	DOWN(0,1),
	LEFT(-1,0),
	RIGHT(1,0);
	
	public final int xMove, yMove;
	
	private Direction(int xm, int ym) {
		xMove = xm;
		yMove = ym;;
	}
	
	public Direction getOpposite() {
	switch (this) {
		case UP: return DOWN;
		case DOWN: return UP;
		case LEFT: return RIGHT;
		case RIGHT: return LEFT;
		}
	return null;
	}
}
