
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.util.*;

/**
 * Represents the abstract structure for the RPG's shop
 *
 * @author Vivek Patel
 * @version CS56-W15 03/05, 1.0 
 */

public class Shop {

	private ArrayList<Weapon> inventory;
	
	/**
 	 * No-arg constructor for Shop class
 	 * Initializes Shop inventory with all weapons
 	 */ 
	public Shop() {
		inventory = new ArrayList<Weapon>();
		inventory.add(0, null);
		for (int i = 1; i <= 4; i++) {
			Weapon wp = new Weapon(i);
			inventory.add(i, wp);
		}
	}

	public void buyItem(Weapon wp) {
		inventory.remove(wp.getWeapon());	
	}
	
	/**
 	 * @return The inventory of the shop as an ArrayList
 	 */ 
	public ArrayList<Weapon> getInventory() {
		return this.inventory;
	}
}
