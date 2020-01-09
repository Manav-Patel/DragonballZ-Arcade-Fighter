/*
 * Name: Sneh Patel
 * Date: Dec 20, 2017
 * FileName: ChampSelect1.java
 * Purpose:  To practice the use of ChampSelect1.java
 */
package ChampSelect;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;

import javax.swing.*;

import Frame.SpriteSheet;
import Frame.Texture;
import Frame.Texture2;
import Main.BufferedImageLoader;
import Main.Game;
import Main.Window;

public class Main extends JPanel implements KeyListener {

	Image background, rect, player;

	BufferedImage sprite;
	Image dbImage, dbImage2;
	Graphics dbg, dbg2;
	Animator character, character2;

	static int speed = 100, x;

	Boolean p1 = true;
	Toolkit kit = Toolkit.getDefaultToolkit();
	int xCoord = 92, yCoord = 28, charPosX = 150, charPosY = 200, char2PosX = 0, char2PosY = 0;

	JFrame frame = new JFrame();
	Texture tx1 = new Texture();
	Texture2 tx2 = new Texture2();

	public static void main(String[] args) {

	}

	public Main() {

		frame.setTitle("Character Select");
		frame.setSize(700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);

		rect = kit.getImage("Player1rect.png");
		background = kit.getImage("ChampSelect.jpg");
		player = kit.getImage("Player1.png");

		frame.addKeyListener(this);

		frame.setResizable(false);
		frame.setVisible(true);

	}

	public void keyPressed(KeyEvent event) {

		if (p1 == true) {
			if (event.getKeyCode() == KeyEvent.VK_D && xCoord < 588) {
				xCoord = xCoord + 83;

			} else if (event.getKeyCode() == KeyEvent.VK_A && xCoord > 105) {
				xCoord = xCoord - 83;
			}

			if (event.getKeyCode() == KeyEvent.VK_ENTER && (xCoord == 590 ^ xCoord == 341)) {

				if (xCoord == 590) {
					tx1.ch = "/VegetaSheet.png";
				} else if (xCoord == 341) {
					tx1.ch = "/GokuSheet.png";
				}

				rect = kit.getImage("Player2rect.png");
				player = kit.getImage("Player2.png");
				p1 = false;
				x = xCoord;
			}

		} else if (p1 == false) {
			if (event.getKeyCode() == KeyEvent.VK_RIGHT && xCoord < 588) {
				xCoord = xCoord + 83;
			} else if (event.getKeyCode() == KeyEvent.VK_LEFT && xCoord > 105) {
				xCoord = xCoord - 83;
			}
			if (event.getKeyCode() == KeyEvent.VK_ENTER && (xCoord == 590 ^ xCoord == 341)) {
				if (xCoord == 590) {
					tx2.ch = "/VegetaSheet.png";
				} else if (xCoord == 341) {
					tx2.ch = "/GokuSheet.png";
				}
				new Window(700, 500, "Dragon Ball Fighters", new Game());
				frame.dispose();

			}
		}

	}

	@Override
	public void paint(Graphics g) {

		if (p1 == true) {
			dbImage = createImage(getWidth(), getHeight());
			dbg = dbImage.getGraphics();
			paintComponent(dbg, charPosX, charPosY, char2PosX, char2PosY);
			g.drawImage(dbImage, 0, 0, null);
		} else if (p1 == false) {

			dbImage = createImage(getWidth(), getHeight());
			dbg = dbImage.getGraphics();
			paintComponent(dbg, charPosX, charPosY, char2PosX, char2PosY);
			g.drawImage(dbImage, 0, 0, null);

			dbImage2 = createImage(getWidth(), getHeight());
			dbg2 = dbImage2.getGraphics();
			paintComponent(dbg2, charPosX, charPosY, char2PosX, char2PosY);
			g.drawImage(dbImage2, 0, 0, null);
		}

	}

	public void paintComponent(Graphics g, int x1, int y1, int x, int y) {
		g.drawImage(background, 0, 0, this);
		g.drawImage(player, 5, 36, this);
		g.drawImage(rect, xCoord, yCoord, 77, 66, this);

		if (character != null) {
			character.update(System.currentTimeMillis());
			g.drawImage(character.sprite, x1, y1, null);

			if (p1 == false && character2 != null) {
				character2.update(System.currentTimeMillis());
				g.drawImage(character2.sprite, x, y, null);
			}
		}

		repaint();

	}

	public void init(String sheet, int ar[][]) {
		BufferedImageLoader loader = new BufferedImageLoader();

		BufferedImage spriteSheet = null;

		spriteSheet = loader.loadImage("/" + sheet + ".png");

		SpriteSheeet ss = new SpriteSheeet(spriteSheet);

		ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();

		for (int row = 0; row < ar.length; row++) {
			sprites.add(ss.grabSprite(ar[row][0], ar[row][1], ar[row][2], ar[row][3]));
		}

		character = new Animator(sprites);
		character.setSpeed(speed);
		character.play();

	}

	public void init2(String sheet, int ar[][]) {
		BufferedImageLoader loader = new BufferedImageLoader();

		BufferedImage spriteSheet = null;

		spriteSheet = loader.loadImage("/" + sheet + ".png");

		SpriteSheeet ss = new SpriteSheeet(spriteSheet);

		ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();

		for (int row = 0; row < ar.length; row++) {
			sprites.add(ss.grabSprite(ar[row][0], ar[row][1], ar[row][2], ar[row][3]));
		}

		character2 = new Animator(sprites);
		character2.setSpeed(speed);
		character2.play();

	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

}
