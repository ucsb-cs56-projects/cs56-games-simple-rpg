/**
 * 
 */
package com.teamshadowstudios.simpleRPG;

/**Class to represent all the tiles the game is made of
 * @author Alvin Tan
 *
 */
public class Tile {
	//instance variables
	private int tileType;
	
	/**Default Constructor, makes a basic Tile
	 * 
	 */
	public Tile(){
		/*Tile Type:
		 * 0-grass
		 * 1-water
		 */
		tileType=0;
	}
	
	/**
	 * @return the type of tile
	 */
	public int getType(){
		return tileType;
	}
	
	public void setType(int type){
		tileType = type;
	}
}
