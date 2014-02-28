package edu.ucsb.cs56.projects.games.simple_rpg;

/**Abstract class that every enemy shall inherit from
 * @author Alvin Tan
 *
 */
public abstract class Enemy {
	protected int hp,mp,lvl;
	protected int maxHP,maxMP,minDMG,maxDMG;
	protected int agi,str,sta,intel;
	protected Reward r;
	protected String name;
	
	/**Constructor that initializes the name/type of the enemy represented
	 * @param s String to represent the name (ie. type) of enemy
	 */
	protected Enemy(String s){
		r = new Reward();
		name = s;
	}
	
	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}
	/**
	 * @return the mp
	 */
	public int getMp() {
		return mp;
	}
	/**
	 * @return the lvl
	 */
	public int getLvl() {
		return lvl;
	}
	/**
	 * @return the maxHP
	 */
	public int getMaxHP() {
		return maxHP;
	}
	/**
	 * @return the maxMP
	 */
	public int getMaxMP() {
		return maxMP;
	}
	/**
	 * @return the agi
	 */
	public int getAgi() {
		return agi;
	}

	/**
	 * @return the str
	 */
	public int getStr() {
		return str;
	}

	/**
	 * @return the sta
	 */
	public int getSta() {
		return sta;
	}

	/**
	 * @return the intel
	 */
	public int getIntel() {
		return intel;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**method to check if enemy is alive or dead.
	 * @return true if the Enemy is Dead, and false otherwise
	 */
	public boolean isDead(){
		return (hp<=0);
	}
	/**abstract method to calculate true damage from raw damage.
	 * @param dmg amount of damage the enemy is about to take.
	 * @return true damage taken
	 */
	public abstract int attacked(int dmg);
	/**abstract method to calculate raw damage of attack towards main character
	 * @param mc MainCharacter
	 * @return raw damage
	 */
	public abstract int attack(MainCharacter mc);
	/**abstract method to get the reward after a battle
	 * @return the reward that this enemy holds if it's dead otherwise, returns empty reward
	 */
	public abstract Reward giveReward();
}
