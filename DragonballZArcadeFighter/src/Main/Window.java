/* Name: Manav Patel
 * Date:
 * Purpose:
 * */

package Main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {

	static JFrame frame = new JFrame();
	public Window(int width, int height, String title, Game game) {

		game.setPreferredSize(new Dimension(width, height)); // setting dimensions of the frame
		game.setMaximumSize(new Dimension(width, height));
		game.setMinimumSize(new Dimension(width, height));

		frame.setTitle(title);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();//starting the game made in the main method
	}
	
	public static void dispose() {
		frame.dispose();
	}

}
