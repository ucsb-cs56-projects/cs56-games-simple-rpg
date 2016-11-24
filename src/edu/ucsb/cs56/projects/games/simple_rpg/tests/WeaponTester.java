package edu.ucsb.cs56.projects.games.simple_rpg.tests;

import static org.junit.Assert.*;

import edu.ucsb.cs56.projects.games.simple_rpg.*;
import org.junit.Test;

/**
 * JUnit Test for the Weapon Class
 *
 * @author Nick Perry
 */
public class WeaponTester {

  @Test
  public void testGetStrBonusDefWeapon() {
    Weapon wp = new Weapon();
    assertEquals(0, wp.getStrBonus());
  }

  @Test
  public void testGetDmgBonusDefWeapon() {
    Weapon wp = new Weapon();
    assertEquals(0, wp.getDmgBonus());
  }

  @Test
  public void testToString() {
    Weapon wp = new Weapon(2);
    assertEquals("Battle Axe - 40 gold",
                  wp.toString());
  }

}
