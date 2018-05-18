package client.gui;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import client.assets.Assets;
import client.main.ClientKernel;

public class WaitingContext extends Context{

	public WaitingContext(ClientKernel kernel) {
		super(kernel);
		
	}

	@Override
	public void init() {

		DisplayManager.createDisplay(ClientKernel.RESOLUTION);
		
		JPanel panel = DisplayManager.getPanel();
		
		JButton exitButton = new JButton("Exit to Menu");
		exitButton.setBounds(1700, 980, 220, 100);
		exitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				ClientKernel.exitToMenu();
				
			}
			
		});
		
		exitButton.setVisible(true);
		
		panel.add(exitButton);
		
	}

	@Override
	public void tick() {

		
	}

	@Override
	public void render(Graphics2D g) {
		
		g.drawImage(Assets.menuBackground, 0, 0, ClientKernel.RESOLUTION.getX(), ClientKernel.RESOLUTION.getY(), null);
		
	}

}
