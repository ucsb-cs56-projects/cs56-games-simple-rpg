package Items;

/**
 * @author Vivek Patel, Nick Perry
 * @version CS56-W15 03/05, 1.0
 */

public class Weapon extends Item {

    public static final int MAX_STR_BONUS = 5;
    public static final int MAX_DMG_BONUS = 20;

	private int strBonus, dmgBonus;

	/**
 	 * No-arg constructor for Weapon object.
 	 */
	public Weapon() {
	        super();
		this.strBonus = 0;
		this.dmgBonus = 0;
	}

	/**
 	 * Constructor for Weapon object by integer weapon code.
 	 */
	public Weapon(int code) {
	    super(code);
	    if (isValidItemCode(code) == true) {
		this.strBonus = genStrBonus();
		this.dmgBonus = genDmgBonus();
	    } else {
       		throw new IllegalArgumentException("Integer parameter is not a valid weapon code.");
		}
	}

	public int getStrBonus() {
	    return this.strBonus;
	}

        private int genStrBonus() {
	    if (super.getCode() == 5)
		return this.randStrBonus();
	    else
		return super.getCode();
	}

	public int getDmgBonus() {
            return this.dmgBonus;
	}

	public int genDmgBonus() {
	    if (super.getCode() == 5)
		return randDmgBonus();
	    else
		return 0; //temp placeholder. should be read value
	}

        private int randStrBonus() {
	    return (int)(Math.random() * MAX_STR_BONUS);
        }

	private int randDmgBonus() {
	    return (int)(Math.random() * MAX_DMG_BONUS);
	}

	public String toString() {
	    return super.getName() + " - " + super.getPrice() + " gold";
	}

}
