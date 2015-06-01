/**
 * Enclosing package for the entire application
 */
package io.stevenpg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author StevenPG
 * @see https://github.com/StevenPG
 * Date: 5/31/2015
 * These unit tests should cover all general
 * case scenarios as well as object instantiations
 * and method calls.
 * JUnit Assertions can be found:
 * 	https://github.com/junit-team/junit/wiki/Assertions
 */
public class ObjectInstantiationTesting {

	private Fish testHamburger;
	private Fish testTang;
	private Tank fishCenter;
	
	@Before
	public void setUp(){
		testHamburger = new Hamburger(null, null, null);
		testTang = new Tang(null, null, null);
	}
	
	@Test
	public void testHambugerCreation() {
		assertNotNull("Hamburger exists...", testHamburger);
	}
	
	@Test
	public void testTangCreation() {
		assertNotNull("Tang exists...", testTang);
	}
	
	@Test
	public void HamburgerNameTest() {
		assertEquals("Fish's name is Hamburger", "Hamburger", testHamburger.name);
	}
	
	@Test
	public void TangNameTest() {
		assertEquals("Fish's name is Tang", "Tang", testTang.name);
	}

	@Test
	public void testTank(){
		try{
			this.fishCenter = new Tank();
			this.fishCenter.whoopwhoopImDone();
		} catch(Exception ex){
			System.out.println("Some Exception occurred...");
			ex.printStackTrace();
			assertNotNull("Exception found in Tank...", this.fishCenter);
		}
	}
}
