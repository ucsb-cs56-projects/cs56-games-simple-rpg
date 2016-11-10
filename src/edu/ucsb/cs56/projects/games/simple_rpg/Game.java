/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.geom.*;
/**
 * Represents the game itself.
 * Currently not in use.
 *
 * @author Alvin Tan, Daniel Chojnacki
 */
public class Game {

    //instance variables
    MainCharacter mc;
    GameMap gameMap;
    static int currentMap;

    /**
     * Default Constructor
     */
    public Game() {
        //We have a game and a display, now we need the backend
        mc = new MainCharacter();
        //initialize a map with all grass tiles
        gameMap = new GameMap();
	currentMap = 1;
    }
	 	 
    /**
     * @return the current map
     */
    public Tile[][] getCurrentMap() {
        return gameMap.getOurMap();
    }
}
