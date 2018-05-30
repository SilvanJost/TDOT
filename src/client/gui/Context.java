package client.gui;

import java.awt.Graphics2D;

import client.main.ClientKernel;

public abstract class Context {
	
	public Context(){

	}
	
	public abstract void init();
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);
}
