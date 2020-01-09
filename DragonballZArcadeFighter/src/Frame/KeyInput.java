/* Name: Manav Patel
 * Date:
 * Purpose:
 * */
package Frame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Main.Handler;

import Objects.Player1;
import Objects.Player2;

public class KeyInput extends KeyAdapter {

	Handler handler;

	public KeyInput(Handler handler) {

		this.handler = handler;

	}

	public void keyPressed(KeyEvent event) {

		int key = event.getKeyCode();// storing key number

		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			// p1

			if (tempObject.getId() == ObjectId.Player1) { // is the player the one using keyinput

				if (key == KeyEvent.VK_D && Player1.moveRight == true) {
					tempObject.setVelX(6);
				} else if (key == KeyEvent.VK_A && Player1.moveLeft == true) {
					tempObject.setVelX(-6);
				} else if (key == KeyEvent.VK_W && !tempObject.isJumping()) {
					tempObject.setJumping(true);
					tempObject.setVelY(-24);
				} else if (key == KeyEvent.VK_R && !tempObject.Kicking && tempObject.getVelX() == 0) {

					tempObject.Kicking = true;

				} else if (key == KeyEvent.VK_T && !tempObject.Punching && tempObject.getVelX() == 0) {

					tempObject.Punching = true;

				}
			}

			// p2

			if (tempObject.getId() == ObjectId.Player2) { // is the player the one using keyinput

				if (key == KeyEvent.VK_RIGHT && Player2.moveRight == true) {
					tempObject.setVelX(6);
				} else if (key == KeyEvent.VK_LEFT && Player2.moveLeft == true) {
					tempObject.setVelX(-6);
				} else if (key == KeyEvent.VK_UP && !tempObject.isJumping()) {
					tempObject.setJumping(true);
					tempObject.setVelY(-24);
				} else if (key == KeyEvent.VK_P && !tempObject.Kicking && tempObject.getVelX() == 0) {

					tempObject.Kicking = true;

				} else if (key == KeyEvent.VK_O && !tempObject.Punching && tempObject.getVelX() == 0) {

					tempObject.Punching = true;

				}
			}

		}

		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}

	public void keyReleased(KeyEvent event) {
		int key = event.getKeyCode();// storing key number

		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			// p1

			if (tempObject.getId() == ObjectId.Player1) { // is the player the one using keyinput
				if (key == KeyEvent.VK_D) {
					tempObject.setVelX(0);
				} else if (key == KeyEvent.VK_A) {
					tempObject.setVelX(0);
				} else if (key == KeyEvent.VK_R) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tempObject.Kicking = false;
				} else if (key == KeyEvent.VK_T) {

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					tempObject.Punching = false;
				}
			}

			// p2

			if (tempObject.getId() == ObjectId.Player2) { // is the player the one using keyinput
				if (key == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(0);
				} else if (key == KeyEvent.VK_LEFT) {
					tempObject.setVelX(0);
				} else if (key == KeyEvent.VK_P) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tempObject.Kicking = false;
				} else if (key == KeyEvent.VK_O) {

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					tempObject.Punching = false;
				}
			}

		}
	}
}
