/* Name: Sneh
 * Filename:
 * Purpose:
 * */
package ChampSelect;

import java.awt.image.*;

public class SpriteSheeet {

	public BufferedImage spriteSheet;

	public SpriteSheeet(BufferedImage ss) {
		this.spriteSheet = ss;
	}

	public BufferedImage grabSprite(int x, int y, int width, int height) {
		BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
		return sprite;
	}

}