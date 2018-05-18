package client.gui;

import java.awt.Graphics2D;

public abstract class GUIElement {

	public abstract void tick();
	
	public abstract void render(Graphics2D g);
}
