/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.util.ArrayList;
/**
 * A class used in the implementation of the Game class
 *
 * @author Daniel Chojnacki
 *
 */
public class Level {
    // instance variables
    GameMap levelMap;
    ArrayList<GoblinFigure> levelEnemies;
    int levelNum;

    /**
     * our default constructor
     */
    public Level() {
	levelMap = new GameMap();
	levelEnemies = new ArrayList<GoblinFigure>();
	levelNum = 0;
    }

    /**
     * a constructor that creates a Level based on in index value
     * @param newLevelNum the value we would like to pass into the GameMap constructor to create a map
     */
    public Level(int newLevelNum) {
	levelMap = new GameMap(newLevelNum);
	levelEnemies = new ArrayList<GoblinFigure>();
	int levelNum = newLevelNum;
    }

    /**
     * @param levelEnemies the GoblinFigures that we would like to set as this level's enemies
     */
    public void setLevelEnemies(ArrayList<GoblinFigure> levelEnemies) {
	this.levelEnemies = new ArrayList<GoblinFigure>();
	for (int i = 0; i < levelEnemies.size(); i++) {
	    this.levelEnemies.add(levelEnemies.get(i));
	}
    }

    /**
     * @param levelEnemy the GoblinFigure that we would like to set as this level's enemy
     */
    public void setLevelEnemies(GoblinFigure levelEnemy) {
	this.levelEnemies = new ArrayList<GoblinFigure>();
	this.levelEnemies.add(levelEnemy);
    }

    /**
     * @param newLevelEnemies the ArrayList of GoblinFigures that we would like to add to this level's enemies
     */
    public void addLevelEnemies(ArrayList<GoblinFigure> newLevelEnemies) {
	for (int i = 0; i < newLevelEnemies.size(); i++) {
	    this.levelEnemies.add(newLevelEnemies.get(i));
	}
    }

    /**
     * @param newLevelEnemy the GoblinFigure that we would like to set as this level's enemies
     */
    public void addLevelEnemies(GoblinFigure newLevelEnemy) {
	this.levelEnemies.add(newLevelEnemy);
    }

    /**
     * to clear all the enemies on this level
     */
    public void clearLevelEnemies() {
	this.levelEnemies.clear();
    }

    /**
     * @param removedEnemy the GoblinFigure we would like to remove from our level
     */
    public void removeLevelEnemies(GoblinFigure removedEnemy) {
	int enemyIndex = this.levelEnemies.indexOf(removedEnemy);
	if (enemyIndex != -1) {
	    this.levelEnemies.remove(enemyIndex);
	}
    }

    /**
     * @param removedEnemies the ArrayList of GoblinFigures we would like to remove from our level
     */
    public void removeLevelEnemies(ArrayList<GoblinFigure> removedEnemies) {
	for (int i = 0; i < removedEnemies.size(); i++) {
	    this.removeLevelEnemies(removedEnemies.get(i));
	}
    }

    /**
     * @return this level's enemies as an ArrayList of GoblinFigures
     */
    public ArrayList<GoblinFigure> getLevelEnemies() {
	return this.levelEnemies;
    }

    /**
     * @return the GoblinFigure at a certain index of this level's list of enemies
     */
    public GoblinFigure getLevelEnemy(int index) {
	return this.levelEnemies.get(index);
    }

    /**
     * @return this level's GameMap
     */
    public GameMap getLevelMap() {
	return this.levelMap;
    }

    /**
     * @param newLevelMap the GameMap we would like to set as this level's new GameMap
     */
    public void setLevelMap(GameMap newLevelMap) {
	this.levelMap = newLevelMap;
    }

    /**
     * @param levelNumber the index of this level
     * @return the maximum number of enemies we can have on this floor (always <=4)
     */
    public int maxEnemyNum(int levelNumber) {
	if (Math.abs(levelNumber) <= 3) {
	    return Math.abs(levelNumber);
	}
	else {
	    return 4;
	}
    }
    
}
