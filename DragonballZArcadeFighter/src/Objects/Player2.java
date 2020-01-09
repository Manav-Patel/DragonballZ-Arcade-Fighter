/* Name: Manav
 * Filename:
 * Purpose:
 * */
package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import Frame.GameObject;
import Frame.ObjectId;
import Frame.Texture2;
import Main.Animation;
import Main.Game;
import Main.Handler;

public class Player2 extends GameObject {

	private float width = 80, height = 148;

	private float gravity = 1.3f;

	private final float MAX_VELOCITY = 20f;

	private Handler handler;

	Texture2 tex2 = Game.getInstanceVegeta();

	private Animation playerWalkTowardsLeft, playerWalkTowardsRight;
	private Animation playerWalkAwayLeft, playerWalkAwayRight;
	private Animation playerIdleLeft, playerIdleRight;
	private Animation playerJumpLeft, playerJumpRight;
	private Animation playerKickLeft, playerKickRight;
	private Animation playerPunchLeft, playerPunchRight;

	public static boolean moveRight = true;
	public static boolean moveLeft = true;

	public static float xpos;

	public Player2(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;

		// left animations
		playerWalkTowardsLeft = new Animation(8, tex2.player2[35], tex2.player2[36]);
		playerWalkAwayLeft = new Animation(30, tex2.player2[37], tex2.player2[38]);
		playerIdleLeft = new Animation(2, tex2.player2[30], tex2.player2[31], tex2.player2[32], tex2.player2[33],
				tex2.player2[34], tex2.player2[29]);
		playerJumpLeft = new Animation(6, tex2.player2[39], tex2.player2[40], tex2.player2[41], tex2.player2[42],
				tex2.player2[43], tex2.player2[44]);
		playerKickLeft = new Animation(4, tex2.player2[45], tex2.player2[46], tex2.player2[47], tex2.player2[48],
				tex2.player2[49], tex2.player2[50]);
		playerPunchLeft = new Animation(3, tex2.player2[51], tex2.player2[52], tex2.player2[53], tex2.player2[54]);

		// right animations
		playerWalkTowardsRight = new Animation(8, tex2.player2[8], tex2.player2[9]);
		playerWalkAwayRight = new Animation(30, tex2.player2[10], tex2.player2[11]);
		playerIdleRight = new Animation(2, tex2.player2[3], tex2.player2[4], tex2.player2[5], tex2.player2[6],
				tex2.player2[7], tex2.player2[2]);
		playerJumpRight = new Animation(6, tex2.player2[12], tex2.player2[13], tex2.player2[14], tex2.player2[15],
				tex2.player2[16], tex2.player2[17]);
		playerKickRight = new Animation(4, tex2.player2[18], tex2.player2[19], tex2.player2[20], tex2.player2[21],
				tex2.player2[22], tex2.player2[23]);
		playerPunchRight = new Animation(3, tex2.player2[24], tex2.player2[25], tex2.player2[26], tex2.player2[27]);

	}

	public void tick(LinkedList<GameObject> object) {

		x += velocityX;
		y += velocityY;

		xpos = x;

		if (falling || jumping) {
			velocityY += gravity;

			if (velocityY > MAX_VELOCITY) {
				velocityY = MAX_VELOCITY;
			}

		}
		Collision(object);

		playerWalkTowardsLeft.runAnimation();
		playerWalkAwayLeft.runAnimation();
		playerIdleLeft.runAnimation();
		playerJumpLeft.runAnimation();
		playerKickLeft.runAnimation();
		playerPunchLeft.runAnimation();

		playerWalkTowardsRight.runAnimation();
		playerWalkAwayRight.runAnimation();
		playerIdleRight.runAnimation();
		playerJumpRight.runAnimation();
		playerKickRight.runAnimation();
		playerPunchRight.runAnimation();
	}

	private void Collision(LinkedList<GameObject> object) {
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ObjectId.Block) {
				if (getBounds().intersects(tempObject.getBounds())) {
					y = tempObject.getY() - height;
					velocityY = 0;
					falling = false;
					jumping = false;
				} else {
					falling = true;
				}

				if (getBoundsLeft().intersects(tempObject.getBounds())) {
					x = tempObject.getX() + width / 2 - 20;
				}

				if (getBoundsRight().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - width + 10;
				}
			}

			if (tempObject.getId() == ObjectId.Player1) {
				if (getBoundsRight().intersects(tempObject.getBoundsLeft())) {
					moveRight = false;
					velocityX = 0;
				} else {
					moveRight = true;

				}

				if (getBoundsLeft().intersects(tempObject.getBoundsRight())) {
					moveLeft = false;
					velocityX = 0;
				} else {
					moveLeft = true;

				}

				// damage

				if ((getBoundsRightHitbox().intersects(tempObject.getBoundsTop())
						|| getBoundsLeftHitbox().intersects(tempObject.getBoundsTop())) && Kicking == true
						&& !(Player1.healthplayer1 <= 0)) {
					Player1.healthplayer1 = Player1.healthplayer1 - 1;

				}
				if ((getBoundsRightHitbox().intersects(tempObject.getBoundsTop())
						|| getBoundsLeftHitbox().intersects(tempObject.getBoundsTop())) && Punching == true
						&& !(Player2.healthplayer2 <= 0)) {
					Player1.healthplayer1 = Player1.healthplayer1 - 2;
				}

			}

		}
	}

	public void render(Graphics g) {

		/*
		 * g.setColor(Color.BLACK); g.fillRect((int) x, (int) y, (int) width, (int)
		 * height); // hitbox
		 * 
		 * Graphics2D g2d = (Graphics2D) g; g.setColor(Color.blue);
		 * g2d.draw(getBounds()); g2d.draw(getBoundsTop()); g2d.draw(getBoundsLeft());
		 * g2d.draw(getBoundsRight()); g2d.draw(getBoundsRightHitbox());
		 * g2d.draw(getBoundsLeftHitbox());
		 */

		if (x <= Player1.xpos) {
			if (velocityX < 0) {
				playerWalkAwayLeft.drawAnimation(g, (int) x - 30, (int) y - 7, 148, 158);
			} else if (velocityX > 0) {
				playerWalkTowardsLeft.drawAnimation(g, (int) x - 30, (int) y - 7, 148, 158);
			} else if (jumping && !Kicking) {
				playerJumpLeft.drawAnimation(g, (int) x - 30, (int) y - 7, 148, 158);
			} else if (Kicking) {

				playerKickLeft.drawAnimation(g, (int) x - 30, (int) y - 7, 148, 158);

			} else if (Punching) {
				playerPunchLeft.drawAnimation(g, (int) x - 30, (int) y - 7, 148, 158);
			} else {

				playerIdleLeft.drawAnimation(g, (int) x - 30, (int) y - 7, 148, 158);

			}
		}

		if (x > Player1.xpos) {
			if (velocityX < 0) {
				playerWalkTowardsRight.drawAnimation(g, (int) x - 30, (int) y - 7, 148, 158);
			} else if (velocityX > 0) {
				playerWalkAwayRight.drawAnimation(g, (int) x - 30, (int) y - 7, 148, 158);
			} else if (jumping && !Kicking) {
				playerJumpRight.drawAnimation(g, (int) x - 30, (int) y - 7, 148, 158);
			} else if (Kicking) {

				playerKickRight.drawAnimation(g, (int) x - 30, (int) y - 7, 148, 158);

			} else if (Punching) {
				playerPunchRight.drawAnimation(g, (int) x - 30, (int) y - 7, 148, 158);
			} else {

				playerIdleRight.drawAnimation(g, (int) x - 30, (int) y - 7, 148, 158);

			}

		}
	}

	public Rectangle getBounds() {// bottom box

		return new Rectangle((int) ((int) x + (width / 2) - ((width / 2) / 2)), (int) ((int) y + (height / 2)),
				(int) width / 2, (int) height / 2);
	}

	public Rectangle getBoundsTop() {// top box

		return new Rectangle((int) ((int) x + (width / 2) - ((width / 2)) / 2), (int) y, (int) width / 2,
				(int) height / 2);
	}

	public Rectangle getBoundsRight() {// right box

		return new Rectangle((int) ((int) x + width - 27), (int) y + 100, (int) 15, (int) height - 105);
	}

	public Rectangle getBoundsLeft() {// left box

		return new Rectangle((int) x + 10, (int) y + 100, (int) 15, (int) height - 105);
	}

	public Rectangle getBoundsRightHitbox() {

		return new Rectangle((int) x + 95, (int) y + 50, (int) 20, (int) height - 120);
	}

	public Rectangle getBoundsLeftHitbox() {

		return new Rectangle((int) x - 27, (int) y + 50, (int) 20, (int) height - 120);
	}
}
