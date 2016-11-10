package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.Graphics2D;
import java.awt.geom.Area;

/** 
 * @author Vivek Patel
 * @version CS56-W15 03/05, 1.0
 */

public class Weapon {

    public static final int MAX_STR_BONUS = 5;
    
	private int weapon;
	private int price;
	private String weaponName;
	private int strBonus;
	
	/**
 	 * No-arg constructor for Weapon object.
 	 */ 
	public Weapon() {
		this.weapon = 0;
		this.weaponName = this.getWeaponName();
		this.price = 0;
		this.strBonus = 0;
	}

	/**
 	 * Constructor for Weapon object by integer weapon code. 
 	 */	 	
	public Weapon(int weapon) {
		// This constructor only takes weapon codes for Weapons 1-5.
		if (weapon > 0 && weapon <= 5) {
			this.weapon = weapon;
			this.weaponName = this.retWeaponName();
			this.price = this.retPrice();
			this.strBonus = this.retStrBonus();
		} else {
			throw new IllegalArgumentException("Integer parameter is not a valid weapon code.");
		}
	}	

	/**
 	 * Gets the weapon code for the Weapon object.
 	 * @return Integer code for weapon
	 */
        public int getWeapon() {
            return this.weapon;
	}

	/**
 	 * Gets the price of the Weapon object.
 	 * @return Price of weapon
	 */
	public int getPrice() {
	    return this.price;
	}

        private int retPrice() {
		switch(this.weapon) {
			case 1 :
				return 20;				       
			case 2:
				return 40;
			case 3: 
				return 50;
			case 4:
				return 80;
		        case 5:
			    return (int)(10 + Math.random() * 100);
		}
		return 0;	
	}	
	
	/**
 	 * Gets the name of the Weapon as a String.
 	 * @return Name of weapon
 	 */  
	public String getWeaponName() {
	    return this.weaponName;
	}

        public String retWeaponName() {
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
		        case 5:
		                return "Random weapon";
		}
		return "NULL";		
	}
	
	public int getStrBonus() {
	    return this.strBonus;
	}

        private int retStrBonus() {
	    if (weapon == 5)
		return this.generateStrBonus();
	    else
		return weapon;
	}

        private int generateStrBonus() {
	    return (int)(Math.random() * MAX_STR_BONUS);
        }

	public String toString() {
	    return this.getWeaponName() + " - " + this.getPrice() + " gold";
	}

}
