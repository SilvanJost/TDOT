package client.net.packets;

import client.net.PacketHandler;

public class KeyboardInputPacket extends Packet{

	public KeyboardInputPacket() {
		super(PacketHandler.PACKET_KEYBOARD_INPUT);
		
	}

	@Override
	public void execute() {
		
		
	}
}
