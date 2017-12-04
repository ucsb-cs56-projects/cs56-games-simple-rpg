package Characters;

import Items.Inventory;
import Items.Item;
import Items.Weapon;
import java.util.*;
import java.awt.geom.Area;

/**
 * Represents the Player/MainCharacter
 *
 * @author Alvin Tan, Daniel Chojnacki, Nick Perry
 *
*/

public class MainCharacter extends Entity{
    private int xp;
    private int needXP;
    private int statPoints;
    private int gold;
    private Weapon currentWpn;

    /**
     * Default Constructor. Creates a lvl 1 Main Character
     */
    public MainCharacter() {
	     super("Main Character");
	      agi = 1;
	       str = 1;
	        sta = 1;
	         intel = 1;
           statPoints = 5;
           xp = 0;
           gold = 50;
	          lvl = 1;
	           x = 0;
	            y = 0;
	             hp = (int) ((15 + sta * 1.2 + str * 0.15) + lvl * 3.4);
        mp = (int) ((10 + intel * 1.2) + lvl * 1.3);
        maxHP = (int) ((15 + sta * 1.2 + str * 0.15) + lvl * 3.4);
        maxMP = (int) ((10 + intel * 1.2) + lvl * 1.3);
        minDMG = (int) ((str * 2 + agi * 0.15 + intel * 0.17) + lvl * 0.8);
        maxDMG = (int) ((str * 2.3 + agi * 0.22 + intel * 0.2) + lvl * 0.8);
        needXP = (int) (Math.pow(2, lvl / 3) * 3 + 100);
        Weapon fist = new Weapon();
	      inv = new Inventory("Bag");
	      inv.addItem(fist);
        currentWpn = fist;
    }

    public void addItemToInv(Item i){
      inv.addItem(i);
    }

    /**
     * @return main character's xp
     */
    public int getXp() {
        return xp;
    }

    /**
     * @param xp sets the main character's xp
     **/
    public void setXp(int xp) {
	this.xp = xp;
    }

    /**
     * @return how much XP the main character needs to level up
     */
    public int getNeedXP() {
        return needXP;
    }

    /**
     * @return main character's strength
     */
    public int getStr() {
        return str + currentWpn.getStrBonus();
    }

    /**
     * @return how much gold the main character has
     */
    public int getGold() {
        return gold;
    }

    /**
     * @param gold set the amount of gold the main character has
     **/
    public void setGold(int gold) {
	this.gold = gold;
    }

    /**
     * @return main character's available stat points
     */
    public int getStatPoints() {
        return statPoints;
    }

    /**
     * use one stat point to increase agility by 1
     */
    public void incrementAgi() {
        if (statPoints > 0) {
	    agi++;
            statPoints--;
            updateStats();
        }
    }

    /**
     * use one stat point to increase strength by 1
     */
    public void incrementStr() {
        if (statPoints > 0) {
	    str++;
            statPoints--;
            updateStats();
        }
    }

    /**
     * use one stat point to increase stamina by 1
     */
    public void incrementSta() {
        if (statPoints > 0) {
	    sta++;
            statPoints--;
            updateStats();
        }
    }

    /**
     * use one stat point to increase inteligence by 1
     */
    public void incrementIntel() {
        if (statPoints > 0) {
	    intel++;
            statPoints--;
            updateStats();
        }
    }

    /**
     * attempts to retrieve reward from enemy.
     *
     * @param e enemy defeated
     * @return true if successful and false otherwise
     */
    public boolean getLoot(Enemy e) {
        Loot l = e.loot();
        if (l.getXp() == -1 || l.getGold() == -1) {
            return false;
        } else {
            xp += l.getXp();
            gold += l.getGold();
            return true;
        }
    }

    /**
     * method to check if main character leveled up.
     *
     * @return true if gained enough experience to level up, false otherwise
     */
    public boolean levelUp() {
        if (xp >= needXP) {
	    lvl++;
            needXP = (int) (Math.pow(2, lvl / 3) * 3 + 100);
            statPoints += 2;
            return true;
        } else {
            return false;
        }
    }

    /**
     * private method to update stats after using a stat point
     */
    private void updateStats() {
        maxHP =(int) ((15 + sta * 1.2 + str * 0.15) + lvl * 3.4);
	maxMP = (int) ((10 + intel * 1.2) + lvl * 1.3);
        minDMG = (int) ((str * 2 + agi * 0.15) + lvl * 0.8);
        maxDMG = (int) ((str * 2.3 + agi * 0.22) + lvl * 0.8);
	hp = maxHP;
    }

    /**
     * calculates raw damage
     *
     * @param e enemy to attack
     * @return raw damage
     */
    public int attack(Enemy e) {
        int x = Math.abs(e.getAgi() - agi);
        if (x >= 100) {
            if (Math.random() > .5) {
                return (int) ((maxDMG - minDMG + 1) * Math.random() + minDMG);
            } else {
                return -1;
            }
        } else {
            if (Math.random() > (x * .5) / 100) {
                return (int) ((maxDMG - minDMG + 1) * Math.random() + minDMG);
            } else {
                return -1;
            }
        }
    }

    /**
     * calculates true damage
     *
     * @param dmg raw damage from enemy
     * @return true damage
     */
    public int attacked(int dmg) {
        dmg = (int) (dmg * .90);
	hp = hp-=dmg;
        return dmg;
    }

}
