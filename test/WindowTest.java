package test;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Game;
import io.MainWindow;

public class WindowTest {

	@Test
	public void test() {		
		Game game = new Game(25, 25, 12,13);
		
		MainWindow window = new MainWindow(game.getGrid(), game.getSnake());		
		assertTrue(window.isFocusable());		
	}
}
