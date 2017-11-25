package Items;

/**
 * To represent a "reward" that can be received by the MainCharacter
 * from things like a quest, treasure chest, or defeating enemies.
 *
 * @author Alvin Tan
 */
public class Loot {
    private int xp, gold;

    /**
     * Default constructor, makes a Reward with 0xp and 0gold.
     */
    public Loot() {
        xp = 0;
        gold = 0;
    }

    /**
     * Constructor to initialize the gold and xp.
     *
     * @param e xp
     * @param g gold
     */
    public Loot(int e, int g) {
        xp = e;
        gold = g;
    }

    /**
     * @return the xp
     */
    public int getXp() {
        return xp;
    }

    /**
     * @param xp the xp to set
     */
    public void setExp(int xp) {
        if (xp >= 0) {
            this.xp = xp;
        }
    }

    /**
     * @return the gold
     */
    public int getGold() {
        return gold;
    }

    /**
     * @param gold the gold to set
     */
    public void setGold(int gold) {
        if (gold >= 0) {
            this.gold = gold;
        }
    }

}
