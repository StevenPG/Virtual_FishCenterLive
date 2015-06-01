/**
 * Enclosing package for the entire application
 */
package io.stevenpg;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Vector;

/**
 * @author StevenPG
 * @see https://github.com/StevenPG
 * Date: 5/31/2015
 * This class represents Tang and contains
 * his relevant information throughout the
 * life of the application.
 */
public class Tang extends Fish {

	public Tang(Vector<Fish> fishImage, Rectangle edges, Component tank){
		this.tank = tank;
		this.fishImage = fishImage;
		this.edges = edges;
		this.random = new Random(System.currentTimeMillis());
		this.name = "Tang";
		this.location = new Point(
				100 + (Math.abs(random.nextInt()) % 300),
				100 + (Math.abs(100 + random.nextInt()) % 100)
				);
		this.velocity = new Point(random.nextInt() % 8, random.nextInt() % 8);
	}

	/**
	 * @see io.stevenpg.Fish#swim()
	 */
	@Override
	public void swim() {
		// TODO Auto-generated method stub

	}

	/**
	 * @see io.stevenpg.Fish#drawFishImage()
	 */
	@Override
	public void drawFishImage() {
		// TODO Auto-generated method stub

	}

}