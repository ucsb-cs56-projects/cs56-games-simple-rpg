package edu.ucsb.cs56.projects.games.simple_rpg.tests;

import static org.junit.Assert.*;

import edu.ucsb.cs56.projects.games.simple_rpg.*;
import org.junit.Test;

/**
 * JUnit Test for the Spell Class
 *
 * @author Nick Perry
 */
public class SpellTester {

  /*
  * lBound inclusive, rBound exclusive
  */
  private int genRandom(int lBound, int rBound){
    return (int)(lBound + Math.random() * rBound);
  }

  @Test
  public void testGetWaterDmgDefSpell() {
    Spell sp = new Spell();
    assertEquals(0, sp.getWaterDmg());
  }

  @Test
  public void testGetFireDmgDefSpell() {
    Spell sp = new Spell();
    assertEquals(0, sp.getFireDmg());
  }

  @Test
  public void testGetWindDmgDefSpell() {
    Spell sp = new Spell();
    assertEquals(0, sp.getWindDmg());
  }

  @Test
  public void testGetElecDmgDefSpell() {
    Spell sp = new Spell();
    assertEquals(0, sp.getElecDmg());
  }

/*
  @Test
  public void testToString() {
    Spell sp = new Spell();
    assertEquals(" - 30 gold",
                  sp.toString());
  }
*/
}
