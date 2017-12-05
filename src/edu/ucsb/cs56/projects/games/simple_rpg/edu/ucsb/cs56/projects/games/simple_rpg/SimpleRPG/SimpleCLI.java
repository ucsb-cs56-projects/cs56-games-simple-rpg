/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg.SimpleRPG;

import edu.ucsb.cs56.projects.games.simple_rpg.CLI.CLI;

/**
 * Contains Main() for CLI implementation of the game.
 *
 * @author Alvin Tan
 */
public class SimpleCLI {

    /**
     * the Main() function 
     *
     * @param args
     */
    public static void main(String[] args) {
        CLI game = new CLI();
        game.start();
    }

}
