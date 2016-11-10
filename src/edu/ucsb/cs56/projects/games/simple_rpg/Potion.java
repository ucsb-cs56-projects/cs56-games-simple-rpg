package edu.ucsb.cs56.projects.games.simple_rpg;

/*
   * * * * * * * * * * * * *
   * @author Nick Perry    *
   * @version CS56-F16 1.0 *
   * * * * * * * * * * * * *
*/

public class Potion {

    public static final int MAX_HP_EFFECT = 100;
    public static final int MAX_MP_EFFECT = 100;
    public static final int MAX_XP_EFFECT = 100;
    
    private String potionName;
    private int potion;
    private int price;
    private int hpEffect;
    private int mpEffect;
    private int xpEffect;

    //no-arg constructor for Potion object
    public Potion() {	
	this.potionName = this.getPotionName();
	this.potion = 0;
	this.price = 0;
	this.hpEffect = 0;
	this.mpEffect = 0;
	this.xpEffect = 0;
    }

    // Constructor for Potion object by integer potion code
    public Potion(int potion) {

	if (potion > 0 && potion < 5) {
	    this.potion = potion;
	    this.potionName = this.getPotionName();
	    this.price = this.getPrice();
	    this.hpEffect = this.getHPEffect();
	    this.mpEffect = this.getMPEffect();
	    this.xpEffect = this.getXPEffect();
	} else {
	    throw new IllegalArgumentException("Integer parameter is not valid potion code.");
	}
    }

    // Gets the potion code for the Potion object
    // @return Integer code for potion
    public int getPotion() {
	return this.potion;
    }

    // Gets the price of the potion
    // @return Price of potion
    public int getPrice() {
	switch(this.potion) {
	case 1:
	    return 15;
	case 2:
	    return 30;
	case 3:
	    return 45;
	case 4:
	    return 60;
	}

	return 0;
    }

    // Gets the name of the potion as a String
    // @return Name of potion
    public String getPotionName(){
	switch(this.potion) {
	case 0:
	    return "Suspicious Potion";
	case 1:
	    return "Health Potion";
	case 2:
	    return "Manna Potion";
	case 3:
	    return "Experience Potion";
	case 4:
	    return "Unknown Potion";
	}

	return "NULL";
    }

    public int getHPEffect() {
	if (potion == 1)
	    return MAX_HP_EFFECT;
	else if (potion == 4)
	    return this.generateHPEffect();
	else
	    return 0;
    }

    public int getMPEffect() {
	if (potion == 2)
	    return MAX_MP_EFFECT;
	else if (potion == 4)
	    return this.generateMPEffect();
	else
	    return 0;
    }

    public int getXPEffect() {
	if (potion == 3)
	    return MAX_XP_EFFECT;
	else if (potion == 4)
	    return this.generateXPEffect();
	else
	    return 0;
    }

    private int generateHPEffect() {
	return (int)(Math.random() * MAX_HP_EFFECT);
    }

    private int generateMPEffect() {
	return (int)(Math.random() * MAX_MP_EFFECT);
    }

    private int generateXPEffect() {
	return (int)(Math.random() * MAX_XP_EFFECT);
    }
    
    public String toString() {
	return this.getPotionName() + " - " + this.getPrice() + " gold";
    }
}
	
	   
