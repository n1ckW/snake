package io;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import core.Direction;
import core.Snake;

public class InputManager extends JComponent {	
	
	private Snake snake;	
		
	public InputManager(Snake s) {
		super();
		snake = s;
		
		class ChangeDirAction extends AbstractAction {				
			Direction dir;
		
			ChangeDirAction(Direction d) {
				dir = d;
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {						
				snake.setHeadDirection(dir);
			}						
		}
		
		InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = getActionMap();
		
		ChangeDirAction up = new ChangeDirAction(Direction.UP);
		ChangeDirAction down = new ChangeDirAction(Direction.DOWN);
		ChangeDirAction left = new ChangeDirAction(Direction.LEFT);
		ChangeDirAction right = new ChangeDirAction(Direction.RIGHT);
		
		im.put(KeyStroke.getKeyStroke("W"), Direction.UP);
		im.put(KeyStroke.getKeyStroke("A"), Direction.LEFT);
		im.put(KeyStroke.getKeyStroke("S"), Direction.DOWN);
		im.put(KeyStroke.getKeyStroke("D"), Direction.RIGHT);
		
		am.put(Direction.UP, up);
		am.put(Direction.DOWN, down);
		am.put(Direction.LEFT, left);
		am.put(Direction.RIGHT, right);
	}		
}
