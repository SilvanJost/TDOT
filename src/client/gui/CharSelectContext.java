package client.gui;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import client.assets.Assets;
import client.main.ClientKernel;

public class CharSelectContext extends Context{

	private int selectedChar = 0;
	
	public CharSelectContext() {
		
	}

	@Override
	public void init() {
		
		System.out.println("AYYE");
		
		DisplayManager.destroyDispaly();
		DisplayManager.createDisplay(ClientKernel.RESOLUTION);
		
		JPanel panel = DisplayManager.getPanel();
		
		final JButton appliCard = new JButton();
		appliCard.setBounds(165, 400, 225, 317);
		appliCard.setIcon(Assets.cardAppi);
		appliCard.setVisible(true);
		appliCard.setText("APPLI");
		panel.add(appliCard);
		
		
		final JButton systemerCard = new JButton();
		systemerCard.setBounds(415, 400, 225, 317);
		systemerCard.setIcon(Assets.cardSystemer);
		systemerCard.setVisible(true);
		systemerCard.setText("SYSTEMER");
		panel.add(systemerCard);
		
		
		final JButton betrieblerCard = new JButton();
		betrieblerCard.setBounds(665, 400, 225, 317);
		betrieblerCard.setIcon(Assets.cardBetriebler);
		betrieblerCard.setVisible(true);
		betrieblerCard.setText("BETRIEBLER");
		panel.add(betrieblerCard);
		
		//          START ACTIONS
		appliCard.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				selectedChar = ClientKernel.CHAR_APPLI;
				
				appliCard.setEnabled(false);
				systemerCard.setEnabled(true);
				betrieblerCard.setEnabled(true);
			}
			
		});
		
		systemerCard.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				selectedChar = ClientKernel.CHAR_SYSTEMER;
				
				appliCard.setEnabled(true);
				systemerCard.setEnabled(false);
				betrieblerCard.setEnabled(true);
			}
			
		});
		
		betrieblerCard.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedChar = ClientKernel.CHAR_BETRIEBLER;
				
				appliCard.setEnabled(true);
				systemerCard.setEnabled(true);
				betrieblerCard.setEnabled(false);
			}
			
		});
		
		//          STOP ACTIONS
		
		final JButton submitButton = new JButton();
		submitButton.setBounds(760, 800, 400, 100);
		submitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				if(selectedChar != 0){
					ClientKernel.selectCharacter(selectedChar);
					submitButton.setEnabled(false);
				}
			}
			
		});
		submitButton.setVisible(true);
		submitButton.setText("Lock");
		panel.add(submitButton);
		
		panel.validate();
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics2D g) {

		g.drawImage(Assets.menuBackground, 0, 0, ClientKernel.RESOLUTION.getX(), ClientKernel.RESOLUTION.getY(), null);
		
	}

}
