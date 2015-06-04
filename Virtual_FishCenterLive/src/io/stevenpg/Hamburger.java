/**
 * Enclosing package for the entire application
 */
package io.stevenpg;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Vector;

/**
 * @author StevenPG
 * @see https://github.com/StevenPG
 * Date: 5/31/2015
 * This class represents Hamburger and contains
 * his relevant information throughout the
 * life of the application.
 */
public class Hamburger extends Fish {
	
	public Hamburger(Vector<Image> images, Rectangle edges, Component tank){
		this.tank = tank;
		this.fishImage = images;
		this.edges = edges;
		// Tang is allowed to move beyond the tank, so increase edges by 25% (Do not increase top)
		int extraBounds = (int) ((int)this.edges.width * .25);
		this.edges.x = this.edges.x - extraBounds;
		this.edges.width += extraBounds;
		this.random = new Random(System.currentTimeMillis() + 1000);
		this.name = "Hamburger";
		this.location = new Point(
				255,
				716
				);
		this.velocity = new Point(random.nextInt() % 8, random.nextInt() % 8);
	}

	/**
	 * @see io.stevenpg.Fish#swim()
	 */
	@Override
	public void swim() {

	}

	/**
	 * @see io.stevenpg.Fish#drawFishImage()
	 */
	@Override
	public void drawFishImage(Graphics g) {
		g.drawImage(fishImage.get(0), location.x, location.y, tank);

	}

}
