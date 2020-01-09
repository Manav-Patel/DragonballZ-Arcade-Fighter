/* Name: Sneh
 * Filename:
 * Purpose:
 * */
package Main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {

	private BufferedImage image;

	/* Takes the image from whatever path the programmer had written in the parameters of the method call and loads it onto the [private BufferedImage image]
	 * */
	
	public BufferedImage loadImage(String path) {


			try {
				image = ImageIO.read(getClass().getResource(path));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	
		return image;

	}

}
