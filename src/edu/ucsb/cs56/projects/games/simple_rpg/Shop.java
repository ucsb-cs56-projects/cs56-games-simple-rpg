
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.util.*;

/**
 * @author Vivek Patel
 * @version CS56-W15 03/05, 1.0 
 */

public class Shop {

	public ArrayList<Weapon> inventory;
	
	/**
 	 * No-arg constructor for Shop class
 	 * Initializes Shop inventory with all weapons
 	 */ 
	public Shop() {
		for (int i = 1; i <= 4; i++) {
			Weapon wp = new Weapon(i);
			inventory.add(i, wp);
		}
	}

	public void buyItem(Weapon wp) {
		inventory.remove(wp.getWeapon());	
	}
}
