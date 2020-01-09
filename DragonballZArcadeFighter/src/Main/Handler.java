/* Name: Manav Patel
 * Date:
 * Purpose: A class that can both add and remove objects
 * */

package Main;

import java.awt.Graphics;
import java.util.LinkedList;

import Frame.GameObject;
import Frame.ObjectId;
import Objects.Block;

public class Handler {

	// creates a list array that organizes objects
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	private GameObject tempObject;

	// Method to update game logic
	public void tick() {

		// each object gets run through
		for (int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			tempObject.tick(object);
		}
	}
	// Method to update what is shown on screen
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			tempObject.render(g);
		}

	}
	// Method to add an object into the game/interface
	public void addObject(GameObject object) {

		this.object.add(object);

	}
	// Method to remove an object from the game/interface
	public void removeObject(GameObject object) {

		this.object.remove(object);

	}
	
	public void createLevel() {

		
		for (int xx = 0; xx < Game.WIDTH*1.5; xx+=32) { //base platform
			addObject(new Block(xx, Game.HEIGHT-32, ObjectId.Block));
		}
		
		for (int xx = 0; xx < Game.WIDTH+32; xx+=32) {//left wall
			addObject(new Block( 0,xx, ObjectId.Block));
		}
		
		for (int xx = 0; xx < Game.WIDTH+32; xx+=32) {
			addObject(new Block( (float) (Game.WIDTH*1.5 - 10) ,xx, ObjectId.Block)); //right wall
		}
	}

}
