package client.gui;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.assets.Assets;
import client.main.ClientKernel;

public class MenuContext extends Context{

	public MenuContext() {
		
	}

	@Override
	public void init() {

		DisplayManager.createDisplay(ClientKernel.RESOLUTION);
		
		JPanel panel = DisplayManager.getPanel();
		
		JButton playButton = new JButton("Play");
		playButton.setBounds(900, 450, 150, 120);
		playButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ClientKernel.joinGame();
				
			}
			
		});
		
		playButton.setVisible(true);
		
		panel.add(playButton);
		
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics2D g) {

		g.drawImage(Assets.menuBackground, 0, 0, ClientKernel.RESOLUTION.getX(), ClientKernel.RESOLUTION.getY(), null);
		
	}

}
