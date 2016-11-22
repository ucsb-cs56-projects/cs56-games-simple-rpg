/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.geom.*;
/**
 * A class used in the implementation of the Game class
 *
 * @author Daniel Chojnacki
 *
 */
public class GameMap {
    // instance variable
    Tile[][] ourMap;

    //each map should take one window worth of space
    //with 20x20 tiles and a 800x800 resolution
    //therefore we have 40 horizontal tiles and 30 vertical
	    //there is also an 800x200 grey status bar
    
    /**
     * create a default GameMap
     */
    public GameMap() {
	ourMap = new Tile[30][40];
	for (int i = 0; i < 8; i++) {
	    for (int j = 0; j < 30; j++) {
		ourMap[j][i] = new Tile(1);
	    }
	}
	for (int i = 8; i < 32; i++) {
	    for (int j = 0; j < 30; j++) {
		ourMap[j][i] = new Tile();
	    }
	}
	for (int i = 32; i < 40; i++) {
	    for (int j = 0; j < 30; j++) {
		ourMap[j][i] = new Tile(1);
	    }
	}
    }

    /**
     * a getter function for our gameMap
     * @return a Tile[][] of our map
     */
    public Tile[][] getOurMap() {
	return ourMap;
    }

    /**
     * this is to implement various kinds of maps
     * the GameMap will be created based on which level we are on
     * @param level is the number of the level we are on
     */
    public GameMap (int level) {
	ourMap = new Tile[30][40];
	for (int i = 0; i < 40; i++) {
	    for (int j = 0; j < 30; j++) {
		ourMap[j][i] = new Tile();
	    }
	}
	if (level == 2) {
	    this.addRock(15, 10, 1);
	}
	else if (level == 3) {
	    this.addRock(12, 9, 2);
	    this.addRock(24, 18, 1);
	}
    }

    /**
     * this function is used to add rock tiles to our gameMap variable
     * @param x the x coordinate of the northwest corner of our rock
     * @param y the y coordinate of the northwest corner of our rock
     * @param size the width and length of our rock
     */
    public void addRock(int x, int y, int size) {
	if ((size <= 3) && (size > 0)) {
	    for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
		    if ((y+j<this.ourMap.length) && (x+i<this.ourMap[j].length)) {
			this.ourMap[y+j][x+i] = new Tile(2);
		    }
		}
	    }
	}
    }
}
