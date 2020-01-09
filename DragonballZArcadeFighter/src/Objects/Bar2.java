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
import Main.Camera1;
import Main.Handler;

public class Bar2 extends GameObject {

	private Handler handler;
	int missingHealth = 0;

	Toolkit kit = Toolkit.getDefaultToolkit(); // Initializing the toolkit
	Image bar1;

	public static float xpos;

	public Bar2(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;

	}

	public void render(Graphics g) {

		if (healthplayer2 > 0) {
			if (healthplayer2 > 400) {
				g.setColor(Color.GREEN);
			} else if (healthplayer2 > 163) {
				g.setColor(Color.YELLOW);
			} else if (healthplayer2 < 163) {
				g.setColor(Color.RED);
			}
		g.fillRect((int) -Camera1.getX()+390 + missingHealth, 38, healthplayer2 / 2, 25);
		missingHealth = (604 - healthplayer2) / 2;
		
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
