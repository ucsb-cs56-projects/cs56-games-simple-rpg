/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.geom.Area;

/**
 * Represents the Player/MainCharacter
 *
 * @author Alvin Tan
 */
public class MainCharacter {
    private int hp, mp, xp, lvl, x, y;
    private int maxHP, maxMP, needXP;
    private int agi, str, sta, intel;
    private int statPoints;
    private int minDMG, maxDMG;
    private int gold;
    private Weapon[] wpns;
    private Weapon currentWpn;

    /**
     * Default Constructor. Creates a lvl 1 Main Character
     */
    public MainCharacter() {
        agi = 1;
        str = 1;
        sta = 1;
        intel = 1;
        statPoints = 5;
        xp = 0;
        gold = 0;
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
    }

    /**
     * @return main character's hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * @return main character's mp
     */
    public int getMp() {
        return mp;
    }

    /**
     * @return main character's xp
     */
    public int getXp() {
        return xp;
    }

    /**
     * @return main character's lvl
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * @return main character's x position
     */
    public int getX() {
        return x;
    }

    /**
     * @return main character's y position
     */
    public int getY() {
        return y;
    }

    /**
     * @return main character's max HP
     */
    public int getMaxHP() {
        return maxHP;
    }

    /**
     * @return main character's max MP
     */
    public int getMaxMP() {
        return maxMP;
    }

    /**
     * @return how much XP the main character needs to level up
     */
    public int getNeedXP() {
        return needXP;
    }

    /**
     * @return main character's agility
     */
    public int getAgi() {
        return agi;
    }

    /**
     * @return main character's strength
     */
    public int getStr() {
        return str;
    }

    /**
     * @return main character's stamina
     */
    public int getSta() {
        return sta;
    }

    /**
     * @return main character's intelligence
     */
    public int getIntel() {
        return intel;
    }

    /**
     * @return how much gold the main character has
     */
    public int getGold() {
        return gold;
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
     * checks if MainCharacter is dead (i.e. has no hp left).
     *
     * @return true if dead and false if not dead
     */
    public boolean isDead() {
        return (hp <= 0);
    }

    /**
     * Attempts to move the main character left.
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
     * Attempts to move the main character right.
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
     * Attempts to move the main character up.
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
     * Attempts to move the main character down.
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
     * attempts to retrieve reward from enemy.
     *
     * @param e enemy defeated
     * @return true if successful and false otherwise
     */
    public boolean retrieveReward(Enemy e) {
        Reward r = e.giveReward();
        if (r.getXp() == -1 || r.getGold() == -1) {
            return false;
        } else {
            xp += r.getXp();
            gold += r.getGold();
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
        maxHP = (int) ((15 + sta * 1.2 + str * 0.15) + lvl * 3.4);
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
        hp -= dmg;
        return dmg;
    }

}
