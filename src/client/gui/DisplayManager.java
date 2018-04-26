package client.gui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class DisplayManager {

	private static JFrame frame;
	
	private static Canvas canvas;
	
	private static int width, height;
	
	public static void createDisplay(int w, int h){
		
		width = w;
		height = h;
		
		frame = new JFrame("Game");
		
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		canvas = new Canvas();
	
		canvas.setSize(new Dimension(width, height));
		canvas.setVisible(true);
		
		
		
		frame.setVisible(true);
		
		frame.add(canvas);
	}
	
	public static void clearDisplay(Graphics2D g){
		
		g.clearRect(0, 0, width, height);
	}
	
	public static void destroyDispaly(){
		
		frame.dispose();
		
		frame = null;
	}
	
	public static Canvas getCanvas(){
		return canvas;
	}
}
