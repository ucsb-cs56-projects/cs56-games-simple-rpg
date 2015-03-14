/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.geom.*;
/**
 * Represents the game itself.
 * Currently not in use.
 *
 * @author Alvin Tan
 */
public class Game {

    //instance variables
    MainCharacter mc;
    Tile[][][] map;
    static int currentMap;

    /**
     * Default Constructor
     */
    public Game() {
        //We have a game and a display, now we need the backend
        mc = new MainCharacter();
        //each map should take one window worth of space
        //with 20x20 tiles and a 800x800 resolution
        //therefore we have 40 horizontal tiles and 30 vertical
		//there is also an 800x200 grey status bar
        //There is currently only 1 map
        map = new Tile[4][30][40];
        //initialize the first map to all grass
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 30; j++) {
                map[1][j][i] = new Tile(1);
            }
        }
	for (int i = 8; i < 32; i++) {
		for (int j = 0; j < 30; j++) {
			map[1][j][i] = new Tile();
		}
	}
	for (int i = 32; i < 40; i++) {
		for (int j = 0; j < 30; j++) {
			map[1][j][i] = new Tile(1);
		}
	}
        //start on the first map
        currentMap = 1;
    }
	 	 
    /**
     * @return the current map
     */
    public Tile[][] getCurrentMap() {
        return map[currentMap];
    }
}
