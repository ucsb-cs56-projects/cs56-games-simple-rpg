package edu.ucsb.cs56.projects.games.simple_rpg.tests;

import static org.junit.Assert.*;

import edu.ucsb.cs56.projects.games.simple_rpg.*;
import org.junit.Test;

/**
 * JUnit Test for the Shop Class
 *
 * @author Nick Perry
 */
public class ShopTester {

  @Test
  public void testAddItem() {
    Inventory inv;
    boolean isTrue;
    Shop sh = new Shop();
    Potion po = new Potion(11);
    sh.addItem(po);
    inv = sh.getInventory();
    isTrue = inv.itemInInv(po);
    assertEquals(true, isTrue);
  }

  @Test
  public void testBuyItem() {
    Inventory inv;
    boolean isTrue, isFalse;
    Shop sh = new Shop();
    Weapon wc = new Weapon(1);

    sh.addItem(wc);
    inv = sh.getInventory();
    isTrue = inv.itemInInv(wc);
    assertEquals(true, isTrue);

    sh.buyItem(wc);
    inv = sh.getInventory();
    isFalse = inv.itemInInv(wc);
    assertEquals(false, isFalse);
  }

  @Test
  public void testBuyItemMC() {
    Inventory inv, mcInv;
    boolean isTrue, isFalse;
    MainCharacter mc = new MainCharacter();
    Shop sh = new Shop();
    Weapon wc = new Weapon(1);

    sh.addItem(wc);
    inv = sh.getInventory();
    mcInv = mc.getInventory();
    isTrue = inv.itemInInv(wc);
    isFalse = mcInv.itemInInv(wc);
    assertEquals(true, isTrue);
    assertEquals(false, isFalse);

    sh.buyItem(wc, mc);
    inv = sh.getInventory();
    mcInv = mc.getInventory();
    isFalse = inv.itemInInv(wc);
    isTrue = mcInv.itemInInv(wc);
    assertEquals(false, isFalse);
    assertEquals(true, isTrue);
  }

  @Test
  public void testGetInventory(){
    Shop sh = new Shop();
    Inventory inventory = new Inventory();

    for (int i = 1; i <= 4; i++) {
			Weapon w = new Weapon(i);
			inventory.addItem(w);
		}
		for (int i = 11; i <= 13; i++) {
			Potion p = new Potion(i);
			inventory.addItem(p);
		}
    Inventory shopInv = sh.getInventory();
    assertEquals(inventory.toString(),
                 shopInv.toString());
  }



}
