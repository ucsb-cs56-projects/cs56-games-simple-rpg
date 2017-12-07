/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg.Characters;

import edu.ucsb.cs56.projects.games.simple_rpg.Items.Inventory;
import edu.ucsb.cs56.projects.games.simple_rpg.Items.Weapon;

/**
 * Class to represent a Goblin enemy, inherits Enemy Class
 *
 * @author Alvin Tan, Nick Perry
 */
public class Goblin extends Enemy {

    private Loot loot;
    private Weapon currentWpn;
    /**
     * Default constructor. Creates a Goblin of lvl1-3 with random loot.
     */
    public Goblin() {
        super("Goblin");
        loot = new Loot();
        Weapon fist = new Weapon();
	      inv = new Inventory("Bag");
	      inv.addItem(fist);
        currentWpn = fist;
        agi = (int) (3 + lvl * 1.2);
        str = (int) (5 + lvl * 1.2);
        sta = (int) (1 + lvl * 1.2);
        intel = (int) (0 + lvl * 1.2);
        lvl = (int) (Math.random() * 3 + 1);
        x = 0;
        y = 0;
        hp = (int) ((10 + sta + str * 0.2) + lvl * 2.7);
        maxHP = (int) ((10 + sta + str * 0.2) + lvl * 2.7);
        mp = (int) ((intel * 1.7) + lvl * 1.7);
        maxMP = (int) ((intel * 1.7) + lvl * 1.7);
        loot.setExp((int) ((4 * Math.random() + 4) + lvl * 1.3));
        loot.setGold((int) ((5 * Math.random() + 2) + lvl * 1.3));
        minDMG = (int) ((str + agi * 0.1) + lvl * 1.4);
        maxDMG = (int) ((str * 1.1 + agi * 0.2) + lvl * 1.6);
    }

    /* (non-Javadoc)
     * @see edu.ucsb.cs56.projects.games.simple_rpg.Enemy#attacked(int)
     */
    //@Override
    public int attacked(int dmg) {
        dmg = (int) (dmg * .90);
        hp -= dmg;
        return dmg;
    }

    /* (non-Javadoc)
<<<<<<< HEAD:src/edu/ucsb/cs56/projects/games/simple_rpg/Goblin.java
     * @see edu.ucsb.cs56.projects.games.simple_rpg.Enemy#attack(edu.ucsb.cs56.projects.games.simple_rpg.MainCharacter)
=======
     * @see com.teamshadowstudios.simpleRPG.Enemy#attack(com.teamshadowstudios.simpleRPG.MainCharacter)
     * method to make a Goblin attack the MainCharacter
>>>>>>> 0226a4c671e41716902772bbc2985153ed9ee82d:src/com/teamshadowstudios/simpleRPG/Goblin.java
     */
    //@Override
    public int attack(MainCharacter mc) {
        int x = Math.abs(mc.getAgi() - agi);
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

    /* (non-Javadoc)
<<<<<<< HEAD:src/edu/ucsb/cs56/projects/games/simple_rpg/Goblin.java
     * @see edu.ucsb.cs56.projects.games.simple_rpg.Enemy#giveReward()
=======
     * @see com.teamshadowstudios.simpleRPG.Enemy#giveReward()
     * Checks if the Goblin is dead and returns the reward if it's dead
>>>>>>> 0226a4c671e41716902772bbc2985153ed9ee82d:src/com/teamshadowstudios/simpleRPG/Goblin.java
     */
    //@Override
    public Loot loot() {
        if (isDead()) {
            return this.loot;
        } else {
            return new Loot(-1, -1);
        }
    }

}
