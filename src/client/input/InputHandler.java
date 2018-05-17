package client.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	private boolean upKeyPressed = false;
	private boolean leftKeyPressed = false;
	private boolean rightKeyPressed = false;
	
	private boolean punchKeyPressed = false;
	private boolean throwKeyPressed = false;
	private boolean specialKeyPressed = false;
	
	@Override
	public void keyPressed(KeyEvent key) {
		switch(key.getKeyChar()) {
		//cases for movement
		case KeyEvent.VK_W:
			upKeyPressed = true;
			break;
		case KeyEvent.VK_A:
			leftKeyPressed = true;
			break;
		case KeyEvent.VK_D:
			rightKeyPressed = true;
			break;
			
		//cases for attack
		case KeyEvent.VK_J:
			punchKeyPressed = true;
			break;
		case KeyEvent.VK_K:
			throwKeyPressed = true;
			break;
		case KeyEvent.VK_L:
			specialKeyPressed = true;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
		switch(key.getKeyChar()) {
		//cases for movement
		case KeyEvent.VK_W:
			upKeyPressed = false;
			break;
		case KeyEvent.VK_A:
			leftKeyPressed = false;
			break;
		case KeyEvent.VK_D:
			rightKeyPressed = false;
			break;
			
		//cases for attack
		case KeyEvent.VK_J:
			punchKeyPressed = false;
			break;
		case KeyEvent.VK_K:
			throwKeyPressed = false;
			break;
		case KeyEvent.VK_L:
			specialKeyPressed = false;
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
	
	public boolean isPunchPressed() {
		return punchKeyPressed;
	}
	
	public boolean isThrowPressed() {
		return throwKeyPressed;
	}
	
	public boolean isSpecialPressed() {
		return specialKeyPressed;
	}
}
