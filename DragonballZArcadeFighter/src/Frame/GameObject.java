/* Name: Manav Patel
 * Date:
 * Purpose: The parent class for the objects of the game to inherit
 * */
package Frame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {

	protected float x, y; // only child classes can use these values
	protected ObjectId id;
	protected float velocityX = 0, velocityY = 0;
	protected boolean falling = true;
	protected boolean jumping = false;
	protected boolean Kicking = false;
	protected boolean Punching = false;
	public static int healthplayer1 = 604;
	public static int healthplayer2 = 604;

	
	public GameObject(float x, float y, ObjectId id) {

		this.x = x;
		this.y = y;
		this.id = id;

	}

	public abstract void tick(LinkedList<GameObject> object);

	public abstract void render(Graphics g);
	
	public abstract Rectangle getBounds();
	public abstract Rectangle getBoundsLeft();
	public abstract Rectangle getBoundsRight();
	public abstract Rectangle getBoundsTop();
	public abstract Rectangle getBoundsRightHitbox();
	public abstract Rectangle getBoundsLeftHitbox();

	// getter and setter methods to get and set values (x, y positions, x, y velocities, etc)
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVelX() {
		return velocityX;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public float getVelY() {
		return velocityY;
	}

	public boolean isKicking() {
		return Kicking;
	}
	
	public void setKicking(boolean kicking) {
		 this.Kicking = kicking;
	}
	
	public boolean isPunching() {
		return Punching;
	}
	
	public void sPunching(boolean kicking) {
		 this.Punching = kicking;
	}
	
	public void setVelX(float velocityX) {
		this.velocityX = velocityX;
	}

	public void setVelY(float velocityY) {
		this.velocityY = velocityY;
	}

	// Check what the game objects are
	public ObjectId getId() {
		return id;
	}
}
