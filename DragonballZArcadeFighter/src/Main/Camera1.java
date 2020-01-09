/* Name: Manav
 * Filename:
 * Purpose:
 * */
package Main;

import Frame.GameObject;

public class Camera1 {
	
	private static float x;
	private float y;
	
	public Camera1(float x, float y) {
		
		this.x = x;
		this.y = y;
		
	}

	public void tick(GameObject player) {
		
		x = -player.getX() - 128 + Game.WIDTH/2; //camera x position follows the first player

	}
	
	//getter/setter methods
	
	public static float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	
}
