/**
 *
 */
package Game;

import Characters.MainCharacter;
import Characters.Goblin;
import java.awt.geom.*;
/**
 * Represents the game itself.
 * Currently not in use.
 *
 * @author Alvin Tan, Daniel Chojnacki, Nick Perry
 */
public class Game {

    //instance variables
<<<<<<< HEAD:src/Game/Game.java
    public MainCharacter mc;
    public Goblin gob;
    public GameMap gameMap;
    public static int currentMap;
=======
    MainCharacter mc;
    Goblin gob, cow; // normal goblin, cowardly goblin
    GameMap gameMap;
    static int currentMap;
>>>>>>> master:src/edu/ucsb/cs56/projects/games/simple_rpg/Game.java

    /**
     * Default Constructor
     */
    public Game() {
        //We have a game and a display, now we need the backend
        mc = new MainCharacter();
        //initialize a map with all grass tiles
        gob = new Goblin();
        cow = new Goblin();
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
