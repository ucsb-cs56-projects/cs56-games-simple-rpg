/**
 * 
 */
package com.teamshadowstudios.simpleRPG;

import static org.junit.Assert.*;
import org.junit.Test;

/**JUnit Test for the MainCharacter Class
 * @author Alvin Tan
 *
 */
public class MainCharacterTest {

	/**
	 * Test method for {@link com.teamshadowstudios.simpleRPG.MainCharacter#moveLeft(int[][])}.
	 */
	@Test
	public void testMoveLeft() {
		int[][] map = {{0,0,0,0,0},
						{0,0,0,0,0},
						{0,0,0,0,0},}; 
		MainCharacter mc = new MainCharacter();
        assertEquals(false,mc.moveLeft(map));
        assertEquals(true,mc.moveRight(map));
        assertEquals(true,mc.moveLeft(map));
        assertEquals(false,mc.moveLeft(map));
	}

	/**
	 * Test method for {@link com.teamshadowstudios.simpleRPG.MainCharacter#moveRight(int[][])}.
	 */
	@Test
	public void testMoveRight() {
		int[][] map = {{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},}; 
		MainCharacter mc = new MainCharacter();
		assertEquals(true,mc.moveRight(map));
		assertEquals(true,mc.moveRight(map));
		assertEquals(true,mc.moveRight(map));
		assertEquals(true,mc.moveRight(map));
		assertEquals(false,mc.moveRight(map));
		assertEquals(true,mc.moveLeft(map));
		assertEquals(true,mc.moveRight(map));
	}

	/**
	 * Test method for {@link com.teamshadowstudios.simpleRPG.MainCharacter#moveUp(int[][])}.
	 */
	@Test
	public void testMoveUp() {
		int[][] map = {{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},}; 
		MainCharacter mc = new MainCharacter();
		assertEquals(false,mc.moveUp(map));
		assertEquals(true,mc.moveDown(map));
		assertEquals(true,mc.moveUp(map));
		assertEquals(false,mc.moveUp(map));
	}

	/**
	 * Test method for {@link com.teamshadowstudios.simpleRPG.MainCharacter#moveDown(int[][])}.
	 */
	@Test
	public void testMoveDown() {
		int[][] map = {{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},}; 
		MainCharacter mc = new MainCharacter();
		assertEquals(true,mc.moveDown(map));
		assertEquals(true,mc.moveDown(map));
		assertEquals(false,mc.moveDown(map));
		assertEquals(true,mc.moveUp(map));
		assertEquals(true,mc.moveDown(map));
	}
}
