/* Name: Sneh
 * Filename:
 * Purpose:
 * */
package Frame;

import java.awt.image.BufferedImage;

import Main.BufferedImageLoader;

public class Texture {

	SpriteSheet ps1;

	private BufferedImage player_sheet1 = null;
	public static String ch = "/VegetaSheet.png";
	public BufferedImage[] player1 = new BufferedImage[55];

	public Texture() {

		BufferedImageLoader loader = new BufferedImageLoader();

		try {
			
			player_sheet1 = loader.loadImage(ch);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		ps1 = new SpriteSheet(player_sheet1);//change this back to 1

		getTextures();
	}

	private void getTextures() {

		
		//RS Animations
		player1[1] = ps1.grabImage(1, 1, 165, 165);// Goku Idle Right1
		player1[2] = ps1.grabImage(2, 1, 165, 165);// Goku Idle Right2
		player1[3] = ps1.grabImage(3, 1, 165, 165);// Goku Idle Right3
		player1[4] = ps1.grabImage(4, 1, 165, 165);// Goku Idle Right4
		player1[5] = ps1.grabImage(5, 1, 165, 165);// Goku Idle Right5
		player1[6] = ps1.grabImage(6, 1, 165, 165);// Goku Idle Right6
		player1[7] = ps1.grabImage(7, 1, 165, 165);// Goku Idle Right7

		player1[8] = ps1.grabImage(1, 2, 165, 165);// Goku Towards Right1
		player1[9] = ps1.grabImage(2, 2, 165, 165);// Goku Towards Right2
		
		player1[10] = ps1.grabImage(1, 3, 165, 165);// Goku Away Right1
		player1[11] = ps1.grabImage(2, 3, 165, 165);// Goku Away Right2
		
		player1[12] = ps1.grabImage(1, 4, 165, 165);// Goku Jump Right1
		player1[13] = ps1.grabImage(2, 4, 165, 165);// Goku Jump Right2
		player1[14] = ps1.grabImage(3, 4, 165, 165);// Goku Jump Right3
		player1[15] = ps1.grabImage(4, 4, 165, 165);// Goku Jump Right4
		player1[16] = ps1.grabImage(5, 4, 165, 165);// Goku Jump Right5
		player1[17] = ps1.grabImage(6, 4, 165, 165);// Goku Jump Right6

		player1[18] = ps1.grabImage(1, 5, 165, 165);// Goku Kick Right6
		player1[19] = ps1.grabImage(2, 5, 165, 165);// Goku Kick Right6
		player1[20] = ps1.grabImage(3, 5, 165, 165);// Goku Kick Right6
		player1[21] = ps1.grabImage(4, 5, 165, 165);// Goku Kick Right6
		player1[22] = ps1.grabImage(5, 5, 165, 165);// Goku Kick Right6
		player1[23] = ps1.grabImage(6, 5, 165, 165);// Goku Kick Right6
		
		player1[24] = ps1.grabImage(1, 6, 165, 165);// Goku Punch Right6
		player1[25] = ps1.grabImage(2, 6, 165, 165);// Goku Punch Right6
		player1[26] = ps1.grabImage(3, 6, 165, 165);// Goku Punch Right6
		player1[27] = ps1.grabImage(4, 6, 165, 165);// Goku Punch Right6
		
		//LS Animations
		
		player1[28] = ps1.grabImage(18, 1, 165, 165);// Goku Idle Left1
		player1[29] = ps1.grabImage(17, 1, 165, 165);// Goku Idle Left2
		player1[30] = ps1.grabImage(16, 1, 165, 165);// Goku Idle Left3
		player1[31] = ps1.grabImage(15, 1, 165, 165);// Goku Idle Left4
		player1[32] = ps1.grabImage(14, 1, 165, 165);// Goku Idle Left5
		player1[33] = ps1.grabImage(13, 1, 165, 165);// Goku Idle Left6
		player1[34] = ps1.grabImage(12, 1, 165, 165);// Goku Idle Left7

		player1[35] = ps1.grabImage(18, 2, 165, 165);// Goku Towards Left1
		player1[36] = ps1.grabImage(17, 2, 165, 165);// Goku Towards Left2
		
		player1[37] = ps1.grabImage(18, 3, 165, 165);// Goku Away Left1
		player1[38] = ps1.grabImage(17, 3, 165, 165);// Goku Away Left2
		
		player1[39] = ps1.grabImage(18, 4, 165, 165);// Goku Jump Left1
		player1[40] = ps1.grabImage(17, 4, 165, 165);// Goku Jump Left2
		player1[41] = ps1.grabImage(16, 4, 165, 165);// Goku Jump Left3
		player1[42] = ps1.grabImage(15, 4, 165, 165);// Goku Jump Left4
		player1[43] = ps1.grabImage(14, 4, 165, 165);// Goku Jump Left5
		player1[44] = ps1.grabImage(13, 4, 165, 165);// Goku Jump Left6

		player1[45] = ps1.grabImage(18, 5, 165, 165);// Goku Kick Left1
		player1[46] = ps1.grabImage(17, 5, 165, 165);// Goku Kick Left2
		player1[47] = ps1.grabImage(16, 5, 165, 165);// Goku Kick Left3
		player1[48] = ps1.grabImage(15, 5, 165, 165);// Goku Kick Left4
		player1[49] = ps1.grabImage(14, 5, 165, 165);// Goku Kick Left5
		player1[50] = ps1.grabImage(13, 5, 165, 165);// Goku Kick Left6
		
		player1[51] = ps1.grabImage(18, 6, 165, 165);// Goku Punch Left1
		player1[52] = ps1.grabImage(17, 6, 165, 165);// Goku Punch Left2
		player1[53] = ps1.grabImage(16, 6, 165, 165);// Goku Punch Left3
		player1[54] = ps1.grabImage(15, 6, 165, 165);// Goku Punch Left4
		
	}

}
