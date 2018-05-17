package client.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	private boolean upKeyPressed = false;
	private boolean leftKeyPressed = false;
	private boolean rightKeyPressed = false;
	
	@Override
	public void keyPressed(KeyEvent key) {
		switch(key.getKeyChar()) {
		case KeyEvent.VK_W:
			upKeyPressed = true;
			break;
		case KeyEvent.VK_A:
			leftKeyPressed = true;
			break;
		case KeyEvent.VK_D:
			rightKeyPressed = true;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
		switch(key.getKeyChar()) {
		case KeyEvent.VK_W:
			upKeyPressed = false;
			break;
		case KeyEvent.VK_A:
			leftKeyPressed = false;
			break;
		case KeyEvent.VK_D:
			rightKeyPressed = false;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}

	public boolean isUpPressed() {
		return upKeyPressed;
	}
	
	public boolean isLeftPressed() {
		return leftKeyPressed;
	}
	
	public boolean isRightPressed() {
		return rightKeyPressed;
	}
}
