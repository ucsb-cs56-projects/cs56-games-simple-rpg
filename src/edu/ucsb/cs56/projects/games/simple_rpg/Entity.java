/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg;

/**
 * Abstract class that every entity shall inherit from
 *
 * @author Daniel Chojnacki
 */
public abstract class Entity {
    protected int hp, mp, lvl;
    protected int x, y;
    protected int maxHP, maxMP, minDMG, maxDMG;
    protected int agi, str, sta, intel;
    protected String name;
    protected Inventory inv;
    protected int direction;

    /**
     * Constructor that initializes the name/type of the entity represented
     *
     * @param s String to represent the name (ie. type) of entity
     */
    protected Entity(String s) {
        name = s;
    }

    /**
     * @return the hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * @return the inventory
     */
    public Inventory getInventory() {
	return inv;
    }

    /**
     * @param hp sets the entity's hp
     **/
    public void setHp(int hp) {
	this.hp = hp;
    }

    /**
     * @return the mp
     */
    public int getMp() {
        return mp;
    }

    /**
     * @param mp sets the entity's mp
     **/
    public void setMp(int mp) {
	this.mp = mp;
    }

    /**
     * @return the lvl
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * @param lvl sets the entity's level
     **/
    public void setLvl(int lvl) {
	this.lvl = lvl;
    }

    /**
     * @return the entity's x position
     **/
    public int getX() {
	return x;
    }

    /**
     * @return the entity's y position
     **/
    public int getY() {
	return y;
    }

    /**
     * @param x sets the entity's x position
     **/
    public void setX(int x) {
	this.x = x;
    }

    /**
     * @param y sets the entity's y position
     **/
    public void setY(int y) {
	this.y = y;
    }

   /**
     * Attempts to move the entity left
     *
     * @param map int[][] that represents the map
     * @return true if successful and false otherwise
     */
    public boolean moveLeft(int[][] map) {
        if (x <= 0) {
            return false;
        } else if (map[y][x - 1] != 0) {
            return false;
        } else {
            x = x - 1;
            return true;
        }
    }

    /**
     * Attempts to move the entity right.
     *
     * @param map int[][] that represents the map
     * @return true if successful and false otherwise
     */
    public boolean moveRight(int[][] map) {
        if (x >= 4) {
            return false;
        } else if (map[y][x + 1] != 0) {
            return false;
        } else {
            x = x + 1;
            return true;
        }
    }

    /**
     * Attempts to move the entity up.
     *
     * @param map int[][] that represents the map
     * @return true if successful and false otherwise
     */
    public boolean moveUp(int[][] map) {
        if (y <= 0) {
            return false;
        } else if (map[y - 1][x] != 0) {
            return false;
        } else {
            y = y - 1;
            return true;
        }
    }

    /**
     * Attempts to move the entity down.
     *
     * @param map int[][] that represents the map
     * @return true if successful and false otherwise
     */
    public boolean moveDown(int[][] map) {
        if (y >= 2) {
            return false;
        } else if (map[y + 1][x] != 0) {
            return false;
        } else {
            y = y + 1;
            return true;
        }
    }

    /**
     * @return the entity's max HP
     **/
    public int getMaxHP() {
	return maxHP;
    }

    /**
     * @param maxHP sets the entity's max hp
     **/
    public void setMaxHP(int maxHP) {
	this.maxHP = maxHP;
    }

    /**
     * @return the entity's max MP
     **/
    public int getMaxMP() {
	return maxMP;
    }

    /**
     * @param maxMP sets the entity's max mp
     **/
    public void setMaxMP(int maxMP) {
	this.maxMP = maxMP;
    }

    /**
     * @return the entity's minimum damage
     **/
    public int getMinDMG() {
	return minDMG;
    }

    /**
     * @param minDMG sets the entity's minimum damage
     **/
    public void setMinDMG(int minDMG) {
	this.minDMG = minDMG;
    }

    /**
     * @return the entity's minimum damage
     **/
    public int getMaxDMG() {
	return maxDMG;
    }

    /**
     * @param maxDMG sets the entity's minimum damage
     **/
    public void setMaxDMG(int maxDMG) {
	this.maxDMG = maxDMG;
    }

    /**
     * @return the agi
     */
    public int getAgi() {
        return agi;
    }

    /**
     * @param agi sets the entity's agility
     **/
    public void setAgi(int agi) {
	this.agi = agi;
    }

    /**
     * @return the str
     */
    public int getStr() {
        return str;
    }

    /**
     * @param str sets the entity's str
     **/
    public void setStr(int str) {
	this.str = str;
    }

    /**
     * @return the sta
     */
    public int getSta() {
        return sta;
    }

    /**
     * @param sta sets the entity's stamina
     **/
    public void setSta(int sta) {
	this.sta = sta;
    }

    /**
     * @return the intel
     */
    public int getIntel() {
        return intel;
    }

    /**
     * @param intel sets the entity's intelligence
     **/
    public void setIntel(int intel) {
	this.intel = intel;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name sets the entity's name
     **/
    public void setName(String name) {
	this.name = name;
    }

    /**
     * method to check if the entity is alive or dead.
     *
     * @return true if the Entity is Dead, and false otherwise
     */
    public boolean isDead() {
        return (hp <= 0);
    }

    /**
     * @return the direction the entity is facing (in degrees)
     */
    public int getDirection() {
	return direction;
    }

    /**
     * @param direction set's the direction the entity is facing (in degrees)
     **/
    public void setDirection(int direction) {
	this.direction = direction;
    }

}
