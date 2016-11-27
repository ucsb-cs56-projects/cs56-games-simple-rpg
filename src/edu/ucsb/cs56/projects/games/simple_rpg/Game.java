/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.geom.*;
/**
 * Represents the game itself.
 * Currently not in use.
 *
 * @author Alvin Tan, Daniel Chojnacki, Nick Perry
 */
public class Game {

    //instance variables
    MainCharacter mc;
    Level gameLevel;
    static int currentMap;

    /**
     * Default Constructor
     */
    public Game() {
        //We have a game and a display, now we need the backend
        mc = new MainCharacter();
        //initialize a level with a game map of all grass tiles
        gameLevel = new Level();
	//set the integer that tells us which level we are on
	currentMap = gameLevel.levelNum;
    }

    /**
     * @return the current map
     */
    public Tile[][] getCurrentMap() {
        return gameLevel.getLevelMap().getOurMap();
    }

    /**
     * @return the current Level
     */
    public Level getGameLevel() {
	return gameLevel;
    }
    
}
