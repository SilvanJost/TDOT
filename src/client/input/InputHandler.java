package client.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import client.main.ClientKernel;
import client.net.PacketHandler;
import client.net.packets.KeyboardInputPacket;
import client.net.packets.Packet;

public class InputHandler implements KeyListener {

	private boolean upKeyPressed = false;
	private boolean leftKeyPressed = false;
	private boolean rightKeyPressed = false;
	
	private boolean punchKeyPressed = false;
	private boolean throwKeyPressed = false;
	private boolean specialKeyPressed = false;
	
	@Override
	public void keyPressed(KeyEvent key) {
		
		switch(key.getKeyCode()) {
		//cases for movement
		case KeyEvent.VK_W: case KeyEvent.VK_SPACE:
			upKeyPressed = true;
			registerKey(key.getKeyCode(), true);
			break;
		case KeyEvent.VK_A:
			leftKeyPressed = true;
			registerKey(key.getKeyCode(), true);
			break;
		case KeyEvent.VK_D:
			rightKeyPressed = true;
			registerKey(key.getKeyCode(), true);
			break;
			
		//cases for attacks
		case KeyEvent.VK_J:
			punchKeyPressed = true;
			registerKey(key.getKeyCode(), true);
			break;
		case KeyEvent.VK_K:
			throwKeyPressed = true;
			registerKey(key.getKeyCode(), true);
			break;
		case KeyEvent.VK_L:
			specialKeyPressed = true;
			registerKey(key.getKeyCode(), true);
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
		
		switch(key.getKeyCode()) {
		//cases for movement
		case KeyEvent.VK_W: case KeyEvent.VK_SPACE:
			upKeyPressed = false;
			registerKey(key.getKeyCode(), false);
			break;
		case KeyEvent.VK_A:
			leftKeyPressed = false;
			registerKey(key.getKeyCode(), false);
			break;
		case KeyEvent.VK_D:
			rightKeyPressed = false;
			registerKey(key.getKeyCode(), false);
			break;
			
		//cases for attack
		case KeyEvent.VK_J:
			punchKeyPressed = false;
			registerKey(key.getKeyCode(), false);
			break;
		case KeyEvent.VK_K:
			throwKeyPressed = false;
			registerKey(key.getKeyCode(), false);
			break;
		case KeyEvent.VK_L:
			specialKeyPressed = false;
			registerKey(key.getKeyCode(), false);
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}
	
	public void registerKey(int keyId, boolean flag){
		
		String data = keyId+","+flag;
		
		Packet packet = PacketHandler.buildPacket(PacketHandler.PACKET_KEYBOARD_INPUT, null, data);
		
		ClientKernel.getClientSocket().send(packet);
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
