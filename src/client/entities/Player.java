package client.entities;

import java.awt.image.BufferedImage;

import client.assets.Assets;

public class Player extends Entity{

    private static final int HEIGHT = 150;
    private static final int WIDTH = 75;
	public Player(int xPosition, int yPosition) {
		super(Assets.player,WIDTH,HEIGHT,xPosition,yPosition);
	}

}
