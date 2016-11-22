
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.util.*;

/**
 * Represents the abstract structure for the RPG's shop
 *
 * @author Vivek Patel, Daniel Chojnacki, Nick Perry
 * @version CS56-W15 03/05, 1.0
 */

public class Shop {

	//private ArrayList<Weapon> inventory;
	private Inventory inventory;
	/**
 	 * No-arg constructor for Shop class
 	 * Initializes Shop inventory with all weapons
 	 */
	public Shop() {
		inventory = new Inventory();
		for (int i = 1; i <= 5; i++) {
			Weapon w = new Weapon(i);
			inventory.addItem(w);
		}
		for (int i = 11; i <= 15; i++) {
			Potion p = new Potion(i);
			inventory.addItem(p);
		}
	}

       /**
        * @param i the Item we will remove from our Shop
        */
	public void buyItem(Item i) {
			inventory.removeItem(i);
	}

	/**
 	 * @return The inventory of the shop as an ArrayList
 	 */
	public Inventory getInventory() {
		return this.inventory;
	}

        /**
         * @param i the Item from our Shop we would like our MainCharacter to buy
         * @param mc our MainCharacter
         */
        public boolean buyItem(Item i, MainCharacter mc) {
	    if ((mc.getGold() >= i.getPrice()) && inventory.itemInInv(i)) {
	        mc.addItemToInv(i);
	        mc.setGold(mc.getGold() - i.getPrice());
					int iIndex = inventory.itemIndex(i);
					inventory.removeItem(iIndex);
					return true;
	    }
			else
					return false;
	}
}
