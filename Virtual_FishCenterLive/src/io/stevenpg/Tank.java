/**
 * Enclosing package for the entire application
 */
package io.stevenpg;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

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
	 * fish center fish.
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
	 * @throws IOException 
	 */
	public Tank() throws IOException {
		setTitle("Virtual_FishCenterLive");
		
		// Assign window attributes
		int SizeOfTaskBarInWindows = 40;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)screenSize.getWidth(), (int) screenSize.getHeight() - SizeOfTaskBarInWindows);
		setResizable(false);
		setVisible(true);
		
		// Retrieve fish graphics
		fishImages = getFishPix();
		
		// Handle background image and resize to window size
		tankImage = ImageIO.read(new File("images/Tank.gif"));
				
		// Create the double-buffer image
		memoryImage = createImage(getSize().width, getSize().height);
		memoryGraphics = memoryImage.getGraphics();
		
		// Create and start the thread
		thread = new Thread(this);
		thread.start();
		
		// Handle when the X button is clicked
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(
				WindowEvent windowEvent){
					continueSwimming = false;
					System.exit(0);
			}
		});
		
	}

	private Vector<Image> getFishPix() {
		Vector<Image> fishPix = new Vector<Image>();
		try {
			// Create Tang
			fishPix.add(ImageIO.read(new File("images/TangRight.gif")));
			fishPix.add(ImageIO.read(new File("images/TangLeft.gif")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fishPix;
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Rectangle edges = new Rectangle(
			0 + getInsets().left, // Get left edge
			0 + getInsets().top,  // Get top edge
			getSize().width - (getInsets().left + getInsets().right), // Get right edge
			getSize().height - (getInsets().top + getInsets().bottom) // Get left edge
		);
		
		// Create fish and add to fish vector
		for(int loopIndex = 0; loopIndex < numberOfFish; loopIndex++){
			Vector<Image> TangPix = new Vector<Image>();
			TangPix.add(fishImages.get(0));
			TangPix.add(fishImages.get(1));
			fishes.add(new Tang(TangPix, edges, this));
		}
		
		// Loop while fish swim
		while(continueSwimming){
			 for (int loopIndex = 0; loopIndex < numberOfFish; loopIndex++){
				// Get fish, tell it to swim
				Fish fish = (Fish)fishes.elementAt(loopIndex);
				fish.swim();
			}
			 
			// Wait between each execution
			try {
				Thread.sleep(sleepTime);
			}catch(Exception exp){
				System.out.println("Tried to wait between method calls...");
				System.out.println(exp.getMessage());
				exp.printStackTrace();
			}
			
			// Redraw the scene
			repaint();
		}
	}
	
	// Update method to handle the double-buffering
	public void update(Graphics g){
		// Draw the tank and the fish
		memoryGraphics.drawImage(tankImage, 0, 0, this);
		for(int loopIndex = 0; loopIndex < 1; loopIndex++){
			((Fish)fishes.elementAt(loopIndex)).drawFishImage
				(memoryGraphics);
		}
		g.drawImage(memoryImage, 0, 0, this);
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
		try{
		Tank fishCenter = new Tank();
		fishCenter.whoopwhoopImDone();
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
