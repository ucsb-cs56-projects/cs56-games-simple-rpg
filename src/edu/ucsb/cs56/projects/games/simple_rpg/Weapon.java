

package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.Graphics2D;
import java.awt.geom.Area;

/** 
 * @author Vivek Patel
 * @version CS56-W15 03/05, 1.0
 */

public class Weapon {

	private int weapon;
	private int price;
	private String weaponName;
	
	/**
 	 * No-arg constructor for Weapon object.
 	 */ 
	public Weapon() {
		this.weapon = 0;
		this.weaponName = this.getWeaponName();
	}

	/**
 	 * Constructor for Weapon object by integer weapon code. 
 	 */	 	
	public Weapon(int weapon) {
		try {
			if (weapon > -1 && weapon < 5) {
				this.weapon = weapon;
				this.weaponName = this.getWeaponName();
				this.price = this.getPrice();
			} else {
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}	
	}	

	/**
 	 * Gets the weapon code for the Weapon object.
 	 * @return Integer code for weapon 
 	 */
	public int getWeapon() {
		return this.weapon;
	}

	public int getPrice() {
		switch(this.weapon) {
			case 1 :
				return 20;								
			case 2:
				return 40;
			case 3: 
				return 50;
			case 4:
				return 80;

		}
		return 0;	
	}	
	
	public String getWeaponName() {
		switch(this.weapon) {
			case 0 :
				return "Fists";
			case 1 :
				return "Wooden sword";
			case 2 :
				return "Axe";
			case 3 :
				return "Warhammer";
			case 4 :
				return "Iron sword";
		}
		return "NULL";		
	}
		
}
