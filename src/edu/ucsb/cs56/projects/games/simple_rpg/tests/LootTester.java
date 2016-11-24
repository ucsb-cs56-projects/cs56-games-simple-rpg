package edu.ucsb.cs56.projects.games.simple_rpg.tests;


import static org.junit.Assert.*;

import edu.ucsb.cs56.projects.games.simple_rpg.*;
import org.junit.Test;

/**
 * JUnit Test for the Loot Class
 *
 * @author Nick Perry
 */
public class LootTester {

  public static final int DEF_LOOT_XP = 0;
  public static final int DEF_LOOT_GOLD = 0;

  /*
  * lBound inclusive, rBound exclusive
  */
  private int genRandom(int lBound, int rBound){
    return (int)(lBound + Math.random() * rBound);
  }

  @Test
  public void testGetXPDefLoot() {
    Loot lt = new Loot();
    assertEquals(DEF_LOOT_XP, lt.getXP());
  }

  @Test
  public void testGetAndSetXPRandLoot() {
    Loot lt = new Loot();
    int rand = genRandom(0, 101);
    lt.setXP(rand);
    assertEquals(rand, lt.getXP());
  }

  @Test
  public void testGetAndSetNegXPDefLoot() {
    Loot lt = new Loot();
    int neg = -1;
    lt.setXP(neg);
    assertEquals(0, lt.getXP());
  }

  @Test
  public void testGetGoldDefLoot() {
    Loot lt = new Loot();
    assertEquals(DEF_LOOT_GOLD, lt.getGold());
  }

  @Test
  public void testGetAndSetGoldRandLoot() {
    Loot lt = new Loot();
    int rand = genRandom(0, 101);
    lt.setXP(rand);
    assertEquals(rand, lt.getXP());
  }

  @Test
  public void testGetAndSetNegGoldDefLoot() {
    Loot lt = new Loot();
    int neg = -1;
    lt.setXP(neg);
    assertEquals(0, lt.getXP());
  }

}
