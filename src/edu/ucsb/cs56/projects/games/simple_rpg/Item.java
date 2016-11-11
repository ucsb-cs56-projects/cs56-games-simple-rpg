package edu.ucsb.cs56.projects.games.simple_rpg;

/*
 * * * * * * * * * * * * *
 * @author Nick Perry    *
 * @version CS56-F16 1.0 *
 * * * * * * * * * * * * * 
*/

public abstract class Item {

    public static final int MULTIPLIER = 5;

    private double[] validCodes = {0, 1, 2, 3, 4, 5, 10, 11, 12, 13, 14, 15};
    protected String name;
    protected int code, price;

    public Item() {
	code = 0;
	name = "Nothing";
	price = 0;
    }

    public Item(int code) {
	this.code = code;
	this.name = retName();
	this.price = retPrice();
    }

    public double getCode() {
	return this.code;
    }

    public String getName() {
	return this.name;
    }

    private String retName() {
	switch(this.code) {
	    case 0:
	        return "Fists";
	    case 1:
	        return "Wooden Club";
	    case 2:
	        return "Battle Axe";
	    case 3:
	        return "Warhammer";
	    case 4:
	        return "Sword";
	    case 5:
	        return "Unique weapon";
	    case 10:
	        return "Empty Potion";
	    case 11:
	        return "HP Potion";
	    case 12:
	        return "MP Potion";
	    case 13:
	        return "XP Potion";
	    case 14:
	        return "Unknown Potion #1";
	    case 15:
	        return "Unknown Potion #2";
	}
	return "Nothing";
    }

    public int getPrice() {
	return this.price;
    }

    private int retPrice() {
	switch(this.code) {
	    case 1:
	        return 20;
	    case 2:
		return 40;
	    case 3:
		return 50;
	    case 4:
	        return 80;
	    case 5:
		return (int)(Math.random() * 100);
	    case 11:
	        return 15;
	    case 12:
	        return 30;
	    case 13:
	        return 45;
	    case 14:
	        return 60;
	    case 15:
	        return (int)(Math.random() * 100);
	}
	return 0;
    }

    protected boolean isValidItemCode(int code) {
	for (int i = 0; i<validCodes.length; i++) {
	    if(validCodes[i] == code)
		return true;
	}
	return false;
    }
}

