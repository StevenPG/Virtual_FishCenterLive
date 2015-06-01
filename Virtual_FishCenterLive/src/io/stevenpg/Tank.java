/**
 * Enclosing package for the entire application
 */
package io.stevenpg;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Vector;

/**
 * @author StevenPG
 * @see https://github.com/StevenPG
 * Date: 5/31/2015
 */
public class Tank extends Frame implements Runnable {

	/**
	 * Default serialVersionUID for multi-threading
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Handle all visuals within awt.Frame.
	 */
	MediaTracker tracker;
	
	/**
	 * Contains visuals for application.
	 */
	Image tankImage, memoryImage;
	Vector<Image> fishImages;
	
	/**
	 * Main thread that controls the fish
	 * and implements Runnable.
	 */
	Thread thread;
	
	/**
	 * Handle fish objects
	 */
	int numberOfFish = 9;
	int sleepTime = 110;
	
	/**
	 * Boolean to determine whether the
	 * fish should be actively moving
	 */
	boolean continueSwimming = true;
	
	/**
	 * Thread safe vector of all 9
	 * fishcenter fish.
	 */
	Vector<Fish> fishes = new Vector<Fish>();
	
	/**
	 * Perform double buffering to avoid
	 * flickering in visuals.
	 */
	Graphics memoryGraphics;
	
	/**
	 * Instantiates objects and kicks off
	 * the thread running the remainder of
	 * the application.
	 */
	public Tank() {
		setTitle("Virtual_FishCenterLive");
		
		// Initialize graphical elements
		tracker = new MediaTracker(this);
		
		// Retrieve fish graphics from function
		// fishImages = getFishPix();
		
		// Add trackers in function
		
		// Handle background image and add tracker
		
		try{
			// tracker.waitForId(0);
		} catch(Exception ex){
			System.out.println("Waiting for IDs to load... failed...");
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Created to keep eclipse from yelling at me
	 * for doing everything in the constructor.
	 */
	public void whoopwhoopImDone() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		Tank fishCenter = new Tank();
		fishCenter.whoopwhoopImDone();
	}

}