package client.gui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.KeyListener;

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
		frame.setFocusable(true);
		
		panel = new JPanel();

		panel.setLayout(null);
		panel.setSize(width, height);
		panel.setVisible(true);
		
		frame.setVisible(true);
		
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
	
	public static void removePanel(){
		frame.remove(panel);
		frame.validate();
	}
	
	public static void initCanvas(){
		
		canvas = new Canvas();
		
		canvas.setSize(new Dimension(width, height));
		canvas.setVisible(true);
		
		frame.setVisible(true);
		frame.add(canvas);
	}
	
	public static void clearPanel(){
		
		panel.removeAll();
	}
	
	public static Canvas getCanvas(){
		return canvas;
	}
	
	public static void addKeyListener(KeyListener listener){
		
		canvas.addKeyListener(listener);
	}
	
	public static JFrame getFrame(){
		return frame;
	}
}
