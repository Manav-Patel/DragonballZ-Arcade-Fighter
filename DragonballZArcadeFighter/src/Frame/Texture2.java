package Frame;

import java.awt.image.BufferedImage;

import Main.BufferedImageLoader;

public class Texture2 {

	SpriteSheet ps2;

	private BufferedImage player_sheet2 = null;
	public static String ch = "/GokuSheet.png";
	public BufferedImage[] player2 = new BufferedImage[55];


	public Texture2() {

		BufferedImageLoader loader = new BufferedImageLoader();

		try {
			
			player_sheet2 = loader.loadImage(ch);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		ps2 = new SpriteSheet(player_sheet2);//change this back to 1

		getTextures();
	}

	private void getTextures() {

		// VEGETA
		// RS Animations
		player2[1] = ps2.grabImage(1, 1, 165, 165);// Vegeta Idle Right1
		player2[2] = ps2.grabImage(2, 1, 165, 165);// Vegeta Idle Right2
		player2[3] = ps2.grabImage(3, 1, 165, 165);// Vegeta Idle Right3
		player2[4] = ps2.grabImage(4, 1, 165, 165);// Vegeta Idle Right4
		player2[5] = ps2.grabImage(5, 1, 165, 165);// Vegeta Idle Right5
		player2[6] = ps2.grabImage(6, 1, 165, 165);// Vegeta Idle Right6
		player2[7] = ps2.grabImage(7, 1, 165, 165);// Vegeta Idle Right7

		player2[8] = ps2.grabImage(1, 2, 165, 165);// Vegeta Towards Right1
		player2[9] = ps2.grabImage(2, 2, 165, 165);// Vegeta Towards Right2

		player2[10] = ps2.grabImage(1, 3, 165, 165);// Vegeta Away Right1
		player2[11] = ps2.grabImage(2, 3, 165, 165);// Vegeta Away Right2

		player2[12] = ps2.grabImage(1, 4, 165, 165);// Vegeta Jump Right1
		player2[13] = ps2.grabImage(2, 4, 165, 165);// Vegeta Jump Right2
		player2[14] = ps2.grabImage(3, 4, 165, 165);// Vegeta Jump Right3
		player2[15] = ps2.grabImage(4, 4, 165, 165);// Vegeta Jump Right4
		player2[16] = ps2.grabImage(5, 4, 165, 165);// Vegeta Jump Right5
		player2[17] = ps2.grabImage(6, 4, 165, 165);// Vegeta Jump Right6

		player2[18] = ps2.grabImage(1, 5, 165, 165);// Vegeta Kick Right6
		player2[19] = ps2.grabImage(2, 5, 165, 165);// Vegeta Kick Right6
		player2[20] = ps2.grabImage(3, 5, 165, 165);// Vegeta Kick Right6
		player2[21] = ps2.grabImage(4, 5, 165, 165);// Vegeta Kick Right6
		player2[22] = ps2.grabImage(5, 5, 165, 165);// Vegeta Kick Right6
		player2[23] = ps2.grabImage(6, 5, 165, 165);// Vegeta Kick Right6

		player2[24] = ps2.grabImage(1, 6, 165, 165);// Vegeta Punch Right6
		player2[25] = ps2.grabImage(2, 6, 165, 165);// Vegeta Punch Right6
		player2[26] = ps2.grabImage(3, 6, 165, 165);// Vegeta Punch Right6
		player2[27] = ps2.grabImage(4, 6, 165, 165);// Vegeta Punch Right6

		// LS Animations

		player2[28] = ps2.grabImage(18, 1, 165, 165);// Vegeta Idle Left1
		player2[29] = ps2.grabImage(17, 1, 165, 165);// Vegeta Idle Left2
		player2[30] = ps2.grabImage(16, 1, 165, 165);// Vegeta Idle Left3
		player2[31] = ps2.grabImage(15, 1, 165, 165);// Vegeta Idle Left4
		player2[32] = ps2.grabImage(14, 1, 165, 165);// Vegeta Idle Left5
		player2[33] = ps2.grabImage(13, 1, 165, 165);// Vegeta Idle Left6
		player2[34] = ps2.grabImage(12, 1, 165, 165);// Vegeta Idle Left7

		player2[35] = ps2.grabImage(18, 2, 165, 165);// Vegeta Towards Left1
		player2[36] = ps2.grabImage(17, 2, 165, 165);// Vegeta Towards Left2

		player2[37] = ps2.grabImage(18, 3, 165, 165);// Vegeta Away Left1
		player2[38] = ps2.grabImage(17, 3, 165, 165);// Vegeta Away Left2

		player2[39] = ps2.grabImage(18, 4, 165, 165);// Vegeta Jump Left1
		player2[40] = ps2.grabImage(17, 4, 165, 165);// Vegeta Jump Left2
		player2[41] = ps2.grabImage(16, 4, 165, 165);// Vegeta Jump Left3
		player2[42] = ps2.grabImage(15, 4, 165, 165);// Vegeta Jump Left4
		player2[43] = ps2.grabImage(14, 4, 165, 165);// Vegeta Jump Left5
		player2[44] = ps2.grabImage(13, 4, 165, 165);// Vegeta Jump Left6

		player2[45] = ps2.grabImage(18, 5, 165, 165);// Vegeta Kick Left1
		player2[46] = ps2.grabImage(17, 5, 165, 165);// Vegeta Kick Left2
		player2[47] = ps2.grabImage(16, 5, 165, 165);// Vegeta Kick Left3
		player2[48] = ps2.grabImage(15, 5, 165, 165);// Vegeta Kick Left4
		player2[49] = ps2.grabImage(14, 5, 165, 165);// Vegeta Kick Left5
		player2[50] = ps2.grabImage(13, 5, 165, 165);// Vegeta Kick Left6

		player2[51] = ps2.grabImage(18, 6, 165, 165);// Vegeta Punch Left1
		player2[52] = ps2.grabImage(17, 6, 165, 165);// Vegeta Punch Left2
		player2[53] = ps2.grabImage(16, 6, 165, 165);// Vegeta Punch Left3
		player2[54] = ps2.grabImage(15, 6, 165, 165);// Vegeta Punch Left4
	}

}
