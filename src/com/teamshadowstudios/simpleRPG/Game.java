/**
 * 
 */
package com.teamshadowstudios.simpleRPG;


/**Represents the game itself.
 * Currently not in use.
 * @author Alvin Tan
 *
 */
public class Game {
	
	//instance variables
	MainCharacter mc;
	Tile[][][] map;
	int currentMap;
	
	/**Default Constructor
	 * 
	 */
	public Game(){
		//We have a game and a display, now we need the backend
		mc = new MainCharacter();
		//each map should take one window worth of space
		//with 20x20 tiles and a 800x600 resolution
		//therefore we have 40 horizontal tiles and 30 vertical
		//There is currently only 1 map
		map = new Tile[1][30][40];
		//initialize the first map to all grass
		for(int i=0;i<30;i++){
			Tile[] temp = {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), 
							new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), 
							new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), 
							new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), 
							new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), 
							new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), 
							new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), 
							new Tile(), new Tile(), new Tile(), new Tile(), new Tile()};
			map[0][i] = temp;
		}
		//start on the first map
		currentMap = 0;
	}
	
	/**
	 * @return the current map
	 */
	public Tile[][] getCurrentMap(){
		return map[currentMap];
	}
}
