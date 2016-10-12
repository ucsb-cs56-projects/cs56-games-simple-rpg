/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg;

/**
 * Class to represent all the tiles the game is made of
 *
 * @author Alvin Tan
 */
public class Tile {
    //instance variables
    private int tileType;

    /**
     * Default Constructor, makes a basic Tile
     */
	public Tile() {
        	/*Tile Type:
		 * 0-grass (green)
		 * 1-water (blue)
		 */
		tileType = 0;
	}

	public Tile(int tileType) {
		if (tileType >= 0 && tileType <= 3) {
			this.tileType = tileType;
		} else {
			throw new IllegalArgumentException("Tile type parameter is not a legitimate tileType.");
		}
	}
	
	
    /**
     * @return the type of tile
     */
	public int getType() {
        	return tileType;
    	}

	public void setType(int type) {
        	tileType = type;
    	}
}
