/* Name: Sneh
 * Filename:
 * Purpose:
 * */
package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import Frame.GameObject;
import Frame.GameOver;
import Frame.KeyInput;
import Frame.ObjectId;
import Frame.Texture;
import Main.Animation;
import Main.Game;
import Main.Handler;
import Main.Window;
import Objects.Player2;

public class Player1 extends GameObject {

	private float width = 80, height = 148;

	private float gravity = 1.3f;

	private final float MAX_VELOCITY = 20f;

	private Handler handler;

	Texture tex = Game.getInstanceGoku();

	private Animation playerWalkTowardsLeft, playerWalkTowardsRight;
	private Animation playerWalkAwayLeft, playerWalkAwayRight;
	private Animation playerIdleLeft, playerIdleRight;
	private Animation playerJumpLeft, playerJumpRight;
	private Animation playerKickLeft, playerKickRight;
	private Animation playerPunchLeft, playerPunchRight;

	public static boolean moveRight = true;
	public static boolean moveLeft = true;

	public static float xpos;

	public Player1(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;

		Game.p1x = (int) x;

		// left animations
		playerWalkTowardsLeft = new Animation(8, tex.player1[35], tex.player1[36]);
		playerWalkAwayLeft = new Animation(30, tex.player1[37], tex.player1[38]);
		playerIdleLeft = new Animation(2, tex.player1[30], tex.player1[31], tex.player1[32], tex.player1[33],
				tex.player1[34], tex.player1[29]);
		playerJumpLeft = new Animation(6, tex.player1[39], tex.player1[40], tex.player1[41], tex.player1[42],
				tex.player1[43], tex.player1[44]);
		playerKickLeft = new Animation(4, tex.player1[45], tex.player1[46], tex.player1[47], tex.player1[48],
				tex.player1[49], tex.player1[50]);
		playerPunchLeft = new Animation(3, tex.player1[51], tex.player1[52], tex.player1[53], tex.player1[54]);

		// right animations

		playerWalkTowardsRight = new Animation(8, tex.player1[8], tex.player1[9]);
		playerWalkAwayRight = new Animation(30, tex.player1[10], tex.player1[11]);
		playerIdleRight = new Animation(2, tex.player1[3], tex.player1[4], tex.player1[5], tex.player1[6],
				tex.player1[7], tex.player1[2]);
		playerJumpRight = new Animation(6, tex.player1[12], tex.player1[13], tex.player1[14], tex.player1[15],
				tex.player1[16], tex.player1[17]);
		playerKickRight = new Animation(4, tex.player1[18], tex.player1[19], tex.player1[20], tex.player1[21],
				tex.player1[22], tex.player1[23]);
		playerPunchRight = new Animation(3, tex.player1[24], tex.player1[25], tex.player1[26], tex.player1[27]);

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

	@SuppressWarnings("null")
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

			if (tempObject.getId() == ObjectId.Player2) {
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
					Player2.healthplayer2 = Player2.healthplayer2 - 1;
				}
				if ((getBoundsRightHitbox().intersects(tempObject.getBoundsTop())
						|| getBoundsLeftHitbox().intersects(tempObject.getBoundsTop())) && Punching == true
						&& !(Player2.healthplayer2 <= 0)) {
					Player2.healthplayer2 = Player2.healthplayer2 - 2;
				}

				if (Player2.healthplayer2 <= 0) {

					VariableHolder hold = new VariableHolder();

					hold.p2dead = true;
					hold.p1dead = false;
					GameOver g = new GameOver();
					Window.dispose();
					Player1.healthplayer1 = 604;
					Player2.healthplayer2 = 604;
				}
				if (Player1.healthplayer1 <= 0) {
					VariableHolder hold = new VariableHolder();
					hold.p2dead = false;
					hold.p1dead = true;
					GameOver g = new GameOver();
					Window.dispose();
					Player1.healthplayer1 = 604;
					Player2.healthplayer2 = 604;
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

		if (x < Player2.xpos) {
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

		if (x >= Player2.xpos) {
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
