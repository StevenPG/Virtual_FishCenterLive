/**
 * Enclosing package for the entire application
 */
package io.stevenpg;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

/**
 * @author StevenPG
 * @see https://github.com/StevenPG
 * Date: 5/31/2015
 * This class implements FishActions, and contains
 * a blueprint for each fish to extend
 */
public abstract class Fish implements FishActions {

	Component tank;
	Random random;
	Point location;
	Point velocity;
	Rectangle edges;
	Vector<Image> fishImage;
	
	/**
	 * @see io.stevenpg.FishActions#swim()
	 */
	@Override
	public void swim(){
		if(random.nextInt() % 7 <= 1){
			velocity.x += random.nextInt() % 4;
			
			// Keep the velocity within -8 and 8
			velocity.x = Math.min(velocity.x, 8);
			velocity.x = Math.max(velocity.x, -8);
			
			velocity.y += random.nextInt() % 4;
			
			velocity.y = Math.min(velocity.y, 8);
			velocity.y = Math.max(velocity.y, -8);
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
	 * @see io.stevenpg.FishActions#drawFishImage()
	 */
	@Override
	public abstract void drawFishImage();

}
