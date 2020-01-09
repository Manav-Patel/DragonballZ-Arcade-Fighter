/* Name: Manav Patel
 * Date:
 * Purpose:
 * */

package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import Frame.KeyInput;
import Frame.ObjectId;
import Frame.Texture;
import Frame.Texture2;
import Objects.Bar1;
import Objects.Bar2;
import Objects.Player1;
import Objects.Player2;

public class Game extends Canvas implements Runnable {

	// Initializes serial ID to ensure that the program responds correctly

	private static final long serialVersionUID = -7095258141958202843L;
	private boolean running = false; // variable to track if the program is running
	private Thread thread; // allows thread initialization

	public static int WIDTH, HEIGHT;

	public static int p1x;

	public Handler handler;// Handler object
	Camera1 camera; // Camera object
	static Texture tex; // texture object
	static Texture2 tex2; // texture2 object

	Image Background; // Initializing an image to use as the background

	private void init() {

		WIDTH = getWidth();
		HEIGHT = getHeight();

		tex = new Texture();
		tex2 = new Texture2();

		handler = new Handler();

		camera = new Camera1(0, 0);// creating camera and setting coords to 0,0

		handler.addObject(new Player1(420, 300, handler, ObjectId.Player1));
		handler.addObject(new Player2(630, 300, handler, ObjectId.Player2));
		handler.addObject(new Bar1(206, 10, handler, ObjectId.Bar1));
		handler.addObject(new Bar2(206, 10, handler, ObjectId.Bar2));

		handler.createLevel();

		// initializing keyboard input
		this.addKeyListener(new KeyInput(handler));

	}

	public synchronized void start() {
		// tells the program if a thread has already been made
		if (running)
			return;

		running = true;
		// adding a new thread
		thread = new Thread(this);
		thread.start();

	}

	public void run() {
		init();
		// Requests focus for this component
		this.requestFocusInWindow();

		// Variables to calculate the frames per second (fps) and ticks
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0; // running/updating the game at 60 fps
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;

		Toolkit kit = Toolkit.getDefaultToolkit(); // Initializing the toolkit
		Background = kit.getImage("TournamentBackground.png");
		Background = Background.getScaledInstance(1800, 700, java.awt.Image.SCALE_SMOOTH);

		// while loop for the fps and ticks calculation and updates the entire
		// game (game loop)
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick(); 
				delta--;
			}
			render();
		}

		// Renders interface and objects
		while (running) {
			render();
		}

	}

	private void tick() {

		handler.tick();

		for (int i = 0; i < handler.object.size(); i++) {

			if (handler.object.get(i).getId() == ObjectId.Player1) { // if the object is the player
				camera.tick(handler.object.get(i));
			}

		}

	}

	private void render() {
		// creating (3) screens that do the job of preparing images before they are put
		// onto the screen

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);// creation of (3) screens that buffer
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;

		//////////////////////

		g2d.translate(camera.getX(), camera.getY()); // camera beginning
		// anything is between will also be translated accordingly with the camera
		g.drawImage(Background, p1x - 735, -100, this);
		// DRAW HERE

		handler.render(g);// updating graphics

		g2d.translate(-camera.getX(), -camera.getY());// camera end

		//////////////////////
		g.dispose(); // disposing images that were not used
		bs.show();

	}

	public static Texture getInstanceGoku() {
		return tex;
	}

	public static Texture2 getInstanceVegeta() {
		return tex2;
	}

	public static void main(String args[]) {

	}

}
