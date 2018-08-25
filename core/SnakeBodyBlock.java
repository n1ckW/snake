package core;

public class SnakeBodyBlock {
	
	public final int x, y;
	private SnakeBodyBlock next;
	private SnakeBodyBlock prev;	

	public SnakeBodyBlock(int x, int y) {
		this.x = x;
		this.y = y;
		next = null;
		prev = null;
	}		

	public SnakeBodyBlock getTail() {
		if (next == null) return this;
		else return next.getTail();
	}	
	
	public SnakeBodyBlock getNext() {
		return next;
	}	
	
	public void setNext(SnakeBodyBlock newnext) {
		next = newnext;
	}	
	
	public SnakeBodyBlock getPrev() {
		return prev;
	}		
	
	public void setPrev(SnakeBodyBlock newprev) {
		prev = newprev;
	}		
}
