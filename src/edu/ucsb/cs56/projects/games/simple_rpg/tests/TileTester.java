package edu.ucsb.cs56.projects.games.simple_rpg.tests;

import static org.junit.Assert.*;

import edu.ucsb.cs56.projects.games.simple_rpg.Tile;
import org.junit.Test;

/**
 * JUnit Test for the Tile Class
 *
 * @author Nick Perry
 */
public class TileTester {

  @Test
  public void testGetTypeDefTile() {
    Tile ti = new Tile();
    assertEquals(0, ti.getType());
  }

  @Test
  public void testGetTypeTileOne() {
    Tile ti = new Tile(1);
    assertEquals(1, ti.getType());
  }

  @Test
  public void testGetTypeTileTwo() {
    Tile ti = new Tile(2);
    assertEquals(2, ti.getType());
  }

  @Test
  public void testSetTypeTileZero() {
    Tile ti = new Tile();
    ti.setType(0);
    assertEquals(0, ti.getType());
  }

  @Test
  public void testSetTypeTileOne() {
    Tile ti = new Tile();
    ti.setType(1);
    assertEquals(1, ti.getType());
  }

  @Test
  public void testSetTypeTileTwo() {
    Tile ti = new Tile();
    ti.setType(2);
    assertEquals(2, ti.getType());
  }

}
