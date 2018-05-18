package client.gui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.utils.Vector2;

public class DisplayManager {

	private static JFrame frame;
	
	private static Canvas canvas;
	
	private static JPanel panel;
	
	private static int width, height;
	
	public static void createDisplay(Vector2 resolution){
		
		width = resolution.getX();
		height = resolution.getY();
		
		frame = new JFrame("Game");
		
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		
		
		canvas = new Canvas();
	
		canvas.setSize(new Dimension(width, height));
		canvas.setVisible(true);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(width, height);
		panel.setVisible(true);
		
		frame.setVisible(true);
		
		frame.add(canvas);
		frame.add(panel);
	}
	
	public static void clearDisplay(Graphics2D g){
		
		g.clearRect(0, 0, width, height);
	}
	
	public static JPanel getPanel() {
		return panel;
	}

	public static void destroyDispaly(){
		
		frame.dispose();
		
		frame = null;
	}
	
	public static Canvas getCanvas(){
		return canvas;
	}
}
