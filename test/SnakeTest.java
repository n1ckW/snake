package test;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Direction;
import core.Grid;
import core.Snake;

public class SnakeTest {

	@Test
	public void test() {
		Snake testsnake = new Snake(4, 6, new Grid(20, 20));
		assertEquals(Direction.UP,testsnake.getHeadDirection());		
	}
}
