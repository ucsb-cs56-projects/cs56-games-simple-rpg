
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.util.*;

public class Shop {

	private ArrayList<Weapon> inventory;
	
	public Shop() {
		for (int i = 1; i <= 4; i++) {
			Weapon wp = new Weapon(i);
			inventory.add(i, wp);
		}
	}
}
