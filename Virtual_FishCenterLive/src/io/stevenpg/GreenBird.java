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
 * This class represents GreenBird and contains
 * his relevant information throughout the
 * life of the application.
 */
public class GreenBird extends Fish {

	public GreenBird(Vector<Image> images, Rectangle edges, Component tank){
		this.tank = tank;
		this.fishImage = images;
		this.edges = edges;
		// Tang is allowed to move beyond the tank, so increase edges by 25% (Do not increase top)
		int extraBounds = (int) ((int)this.edges.width * .25);
		this.edges.x = this.edges.x - extraBounds;
		this.edges.width += extraBounds;
		this.random = new Random(System.currentTimeMillis() + 1000);
		this.name = "GreenBird";
		this.location = new Point(
				400 + (Math.abs(random.nextInt()) % 300),
				100 + (Math.abs(100 + random.nextInt()) % 100)
				);
		this.velocity = new Point(random.nextInt() % 8, random.nextInt() % 8);
	}
	
	/**
	 * @see io.stevenpg.Fish#swim()
	 */
	@Override
	public void swim() {
		if(random.nextInt() % 7 <= 1){
			// Prefer fast horizontal motion and slow vertical motion
			velocity.x += random.nextInt() % 20;
			
			velocity.x = Math.min(velocity.x, 20);
			velocity.x = Math.max(velocity.x, -20);
			
			velocity.y += random.nextInt() % 15;
			
			velocity.y = Math.min(velocity.y, 15);
			velocity.y = Math.max(velocity.y, -15);
		}
		
		// Assign new location
		location.x += velocity.x;
		location.y += velocity.y;
		
		// Determine if the fish's position has put it beyond the
		//	edge of the tank. This creates the "bounce-off" effect.
		if(location.x < edges.x){
			location.x = edges.x;
			velocity.x = -velocity.x;
		}
		if((location.x + fishImage.get(0).getWidth(tank)) > (edges.x + edges.width)){
			location.x = edges.x + edges.width - fishImage.get(0).getWidth(tank);
			velocity.x = -velocity.x;
		}
		if(location.y < edges.y){
			location.y = edges.y;
			velocity.y = -velocity.y;
		}
		if((location.y + fishImage.get(0).getHeight(tank)) > (edges.y + edges.height)){
			location.y = edges.y + edges.height - fishImage.get(0).getHeight(tank);
			velocity.y = -velocity.y;
		}

	}

	/**
	 * @see io.stevenpg.Fish#drawFishImage()
	 */
	@Override
	public void drawFishImage(Graphics g) {
		if(velocity.x < 0){
			g.drawImage(fishImage.get(1), location.x, location.y, tank);
		}
		else {
			g.drawImage(fishImage.get(0), location.x, location.y, tank);
		}
	}

}
