/**
 * Enclosing package for the entire application
 */
package io.stevenpg;

/**
 * @author StevenPG
 * @see https://github.com/StevenPG
 * Date: 5/31/2015
 * This interface allows for polymorphic access
 * to all fish while keeping their consistent mannerisms.
 */
public interface FishActions {
	
	/**
	 * Change the fish's location randomly with each call
	 * within the bounds the fish has been allocated.
	 */
	public void swim();
	
	/**
	 * Draw the fish to the screen at its current location.
	 */
	public void drawFishImage();
	
}
