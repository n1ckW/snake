package test;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Grid;
import core.Tile;

public class GridTest {

	@Test
	public void test1() {
		Grid testgrid = new Grid(20, 20);		
		assertEquals(Tile.EMPTY, testgrid.getTile(5, 5));		
	}
	
	@Test
	public void test2() {
		Grid testgrid = new Grid(20,20);		
		assertEquals(Tile.EMPTY, testgrid.getTile(4, 8));
		
		testgrid.setTile(4, 8, Tile.BLOCK);		
		assertEquals(Tile.BLOCK, testgrid.getTile(4, 8));
	}
}
