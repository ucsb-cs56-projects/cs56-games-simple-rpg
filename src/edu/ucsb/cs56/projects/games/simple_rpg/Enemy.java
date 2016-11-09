/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg;

/**
 * Abstract class that every enemy shall inherit from
 *
 * @author Alvin Tan, Daniel Chojnacki
 */
public abstract class Enemy extends Entity{
    protected Reward r;

    /**
     * Constructor that initializes the name/type of the enemy represented
     *
     * @param s String to represent the name (ie. type) of enemy
     */
    protected Enemy(String s) {
	super(s);
        r = new Reward();
    }

    /**
     * abstract method to calculate true damage from raw damage.
     *
     * @param dmg amount of damage the enemy is about to take.
     * @return true damage taken
     */
    public abstract int attacked(int dmg);

    /**
     * abstract method to calculate raw damage of attack towards main character
     *
     * @param mc MainCharacter
     * @return raw damage
     */
    public abstract int attack(MainCharacter mc);

    /**
     * abstract method to get the reward after a battle
     *
     * @return the reward that this enemy holds if it's dead otherwise, returns empty reward
     */
    public abstract Reward giveReward();
}
