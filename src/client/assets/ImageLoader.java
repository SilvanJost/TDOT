package client.assets;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageLoader {

	public BufferedImage loadImage(String path){
		
		BufferedImage image  = null;
		InputStream fileStream = getClass().getResourceAsStream(path);
		
		try {
			image = ImageIO.read(fileStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
}
