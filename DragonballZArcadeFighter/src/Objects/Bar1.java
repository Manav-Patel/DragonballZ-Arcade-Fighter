/* Name: Sneh
 * Filename:
 * Purpose:
 * */
package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.LinkedList;

import Frame.GameObject;
import Frame.ObjectId;
import Main.Handler;
import Main.Camera1;

public class Bar1 extends GameObject {

	private Handler handler;

	Toolkit kit = Toolkit.getDefaultToolkit(); // Initializing the toolkit
	Image bar1;

	public static float xpos;

	public Bar1(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;

	}

	public void render(Graphics g) {

		bar1 = kit.getImage("HealthBar.png");
		g.drawImage(bar1, (int) -Camera1.getX()+8, 10, null);

		if (healthplayer1 > 0) {
			if (healthplayer1 > 400) {
				g.setColor(Color.GREEN);
			} else if (healthplayer1 > 163) {
				g.setColor(Color.YELLOW);
			} else if (healthplayer1 < 163) {
				g.setColor(Color.RED);
			}
			g.fillRect((int) -Camera1.getX()+10, 38, healthplayer1 / 2, 25);
		}

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBoundsTop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBoundsRightHitbox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBoundsLeftHitbox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub

	}

}
