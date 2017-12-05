/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucsb.cs56.projects.games.simple_rpg.test.Game;

import edu.ucsb.cs56.projects.games.simple_rpg.Game.Game;
import edu.ucsb.cs56.projects.games.simple_rpg.Game.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCurrentMap method, of class Game.
     */
    @Test
    public void testGetCurrentMap() {
        System.out.println("getCurrentMap");
        Game instance = new Game();
        Tile[][] expResult = null;
        Tile[][] result = instance.getCurrentMap();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
