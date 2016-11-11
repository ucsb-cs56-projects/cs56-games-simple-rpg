package edu.ucsb.cs56.projects.games.simple_rpg;

/** 
 * @author Vivek Patel, Nick Perry
 * @version CS56-W15 03/05, 1.0
 */

public class Weapon extends Item {

    public static final int MAX_STR_BONUS = 5;
    
	private int strBonus;
	
	/**
 	 * No-arg constructor for Weapon object.
 	 */ 
	public Weapon() {
	        super();
		this.strBonus = 0;
	}

	/**
 	 * Constructor for Weapon object by integer weapon code. 
 	 */	 	
	public Weapon(int code) {
	    super(code);
	    if (isValidItemCode(code) == true) {
		this.strBonus = retStrBonus();
	    } else {
       		throw new IllegalArgumentException("Integer parameter is not a valid weapon code.");
		}
	}    

	public int getStrBonus() {
	    return this.strBonus;
	}

        private int retStrBonus() {
	    if (this.getCode() == 5)
		return this.generateStrBonus();
	    else
		return (int) (this.getCode()*10);
	}

        private int generateStrBonus() {
	    return (int)(Math.random() * MAX_STR_BONUS);
        }

	public String toString() {
	    return this.getName() + " - " + this.getPrice() + " gold";
	}

}
