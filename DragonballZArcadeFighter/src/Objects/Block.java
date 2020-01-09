/* Name: Manav Patel
 * Date:
 * Purpose:
 * */

package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Frame.GameObject;
import Frame.ObjectId;

public class Block extends GameObject {

	public Block(float x, float y, ObjectId id) {
		super(x, y, id);

	}

	public void tick(LinkedList<GameObject> object) {

	}

	public void render(Graphics g) {


		Color randomColor = new Color(000, 000, 000, 000);//COLOUR INVISIBLE

		g.setColor(randomColor);
		g.drawRect((int) x, (int) y, 32, 32);

	}

	public Rectangle getBounds() {

		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public Rectangle getBoundsLeft() {
		
		return null;
	}

	public Rectangle getBoundsRight() {
	
		return null;
	}

	public Rectangle getBoundsTop() {
	
		return null;
	}

	public Rectangle getBoundsRightHitbox() {
		
		return null;
	}

	public Rectangle getBoundsLeftHitbox() {
		
		return null;
	}

}
