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
		
		boolean check = true;
		
		switch(key.getKeyChar()) {
		//cases for movement
		case KeyEvent.VK_W: case KeyEvent.VK_SPACE:
			upKeyPressed = true;
			break;
		case KeyEvent.VK_A:
			leftKeyPressed = true;
			break;
		case KeyEvent.VK_D:
			rightKeyPressed = true;
			break;
			
		//cases for attacks
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
			check = false;
			break;
		}
		
		if(check){
			
			registerKey(key.getKeyCode(), true);
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
		
		boolean check = true;
		
		switch(key.getKeyChar()) {
		//cases for movement
		case KeyEvent.VK_W: case KeyEvent.VK_SPACE:
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
			check = false;
			break;
		}
		
		if(check){
			
			registerKey(key.getKeyCode(), false);
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
