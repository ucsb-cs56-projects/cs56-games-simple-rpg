package Items;

import Items.Item;

/**
   -------------------------
   | @author Nick Perry    |
   | @version CS56-F16 1.0 |
   -------------------------
**/

public class Spell extends Item {

    public static final int MAX_FIRE_DMG = 50;
    public static final int MAX_WATER_DMG = 35;
    public static final int MAX_WIND_DMG = 20;
    public static final int MAX_ELEC_DMG = 40;

    private int waterDmg, fireDmg, windDmg, elecDmg;

    //no-arg constructor for Potion object
    public Spell() {
	super();
	waterDmg = 0;
	fireDmg = 0;
	windDmg = 0;
	elecDmg = 0;
    }

    // Constructor for Potion object by integer potion code
    public Spell(int code) {
	super(code);
	if (isValidItemCode(code) == true) {
	    this.waterDmg = genWaterDmg();
	    this.fireDmg = genFireDmg();
	    this.windDmg = genWindDmg();
	    this.elecDmg = genElecDmg();
	} else {
	    throw new IllegalArgumentException("String parameter is not valid potion code.");
	}
    }

    public int getWaterDmg() {
	return this.waterDmg;
    }

    private int genWaterDmg() {
	if (super.getCode() == 21)
	    return MAX_WATER_DMG;
	else if (super.getCode() == 25)
	    return this.randWaterDmg();
	else
	    return 0;
    }

    public int getFireDmg() {
	return this.fireDmg;

    }

    private int genFireDmg() {
	if (this.getCode() == 22)
	    return MAX_FIRE_DMG;
	else if (super.getCode() == 25)
	    return this.randFireDmg();
	else
	    return 0;
    }

    public int getWindDmg() {
	return this.windDmg;

    }

    private int genWindDmg() {
	if (super.getCode() == 23)
	    return MAX_WIND_DMG;
	else if (super.getCode() == 25)
	    return this.randWindDmg();
	else
	    return 0;
    }

    public int getElecDmg() {
	return this.elecDmg;
    }

    public int genElecDmg() {
	if (super.getCode() == 24)
	    return MAX_ELEC_DMG;
	else if (super.getCode() == 25)
	    return this.randElecDmg();
	else
	    return 0;
    }

    private int randFireDmg() {
	return (int)(Math.random() * MAX_FIRE_DMG);
    }

    private int randWaterDmg() {
	return (int)(Math.random() * MAX_WATER_DMG);
    }

    private int randWindDmg() {
	return (int)(Math.random() * MAX_WIND_DMG);
    }

    private int randElecDmg() {
	return (int)(Math.random() * MAX_ELEC_DMG);
    }
    
    public String toString() {
	return super.getName() + " - " + super.getPrice() + " gold";
    }
}
