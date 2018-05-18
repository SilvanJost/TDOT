package server.net.packets;

import com.sun.glass.events.KeyEvent;

import server.net.Connection;
import server.net.InputHandler;

public class KeyboardInputPacket extends Packet{
	
	public KeyboardInputPacket(int packetID, String senderIP, String data) {
		super(packetID, senderIP, data);
	}
	
	
	@Override
	public Packet getAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute(Connection conn) {
		
		InputHandler handler = conn.getInputHandler();
		boolean flag = Boolean.parseBoolean(this.data.split(",")[1]);
		char keyPressed = this.data.split(",")[0].toCharArray()[0];
		
		if(keyPressed == KeyEvent.VK_SPACE || keyPressed == KeyEvent.VK_W){
			handler.pressKeyUp(flag);
		} else if(keyPressed == KeyEvent.VK_A){
			handler.pressKeyLeft(flag);
		} else if(keyPressed == KeyEvent.VK_D){
			handler.pressKeyRight(flag);
		} else if(keyPressed == KeyEvent.VK_J){
			handler.pressKeyPunch(flag);
		} else if(keyPressed == KeyEvent.VK_K){
			handler.pressKeyThrow(flag);
		} else if(keyPressed == KeyEvent.VK_L){
			handler.pressKeySpecial(flag);
		}
	}

}
