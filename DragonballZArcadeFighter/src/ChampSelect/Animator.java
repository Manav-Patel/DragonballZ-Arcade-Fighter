/* Name: Sneh
 * Filename:
 * Purpose:
 * */
package ChampSelect;

import java.util.ArrayList;
import java.awt.image.*;

public class Animator {

	private ArrayList<BufferedImage> frames;

	public BufferedImage sprite;

	private boolean running = false;

	private double previousTime, speed;
	private int frameAtPause, currentFrame;
	
	/* Purpose:
	 * Parameters:
	 * Return:
	 * */
	public Animator(ArrayList<BufferedImage> frames) {
		this.frames = frames;
	}

	public void update(long time) {
		if(running) {
			if(time - previousTime >= speed) {
			
				currentFrame++;
				try {
					sprite = frames.get(currentFrame);
				} catch(IndexOutOfBoundsException e) {
					currentFrame = 0;
					sprite = frames.get(currentFrame);
				}				
				previousTime = time;
			}
		}
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void play() {
		running = true;
		previousTime = 0;
		frameAtPause = 0;
		currentFrame = 0;
	}

	public void stop() {
		running = false;
		previousTime = 0;
		frameAtPause = 0;
		currentFrame = 0;
	}

	public void pause() {
		frameAtPause = currentFrame;
		running = false;
	}

	public void resume() {
		currentFrame = frameAtPause;
		running = true;
	}
}
