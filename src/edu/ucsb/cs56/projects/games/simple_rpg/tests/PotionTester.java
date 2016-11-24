package edu.ucsb.cs56.projects.games.simple_rpg.tests;

import static org.junit.Assert.*;

import edu.ucsb.cs56.projects.games.simple_rpg.*;
import org.junit.Test;

/**
 * JUnit Test for the Potion Class
 *
 * @author Nick Perry
 */
public class PotionTester {

  /*
  * lBound inclusive, rBound exclusive
  */
  private int genRandom(int lBound, int rBound){
    return (int)(lBound + Math.random() * rBound);
  }

  @Test
  public void testGetHPEffectDefPotion() {
    Potion po = new Potion();
    assertEquals(0, po.getHPEffect());
  }

  @Test
  public void testGetMPEffectDefPotion() {
    Potion po = new Potion();
    assertEquals(0, po.getMPEffect());
  }

  @Test
  public void testGetXPEffectDefPotion() {
    Potion po = new Potion();
    assertEquals(0, po.getXPEffect());
  }

  @Test
  public void testToString() {
    Potion po = new Potion(12);
    assertEquals("MP Potion - 30 gold",
                  po.toString());
  }

}
