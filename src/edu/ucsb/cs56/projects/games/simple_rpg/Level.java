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

    public Level() {
	levelMap = new GameMap();
	levelEnemies = new ArrayList<GoblinFigure>();
	levelNum = 0;
    }

    public Level(int newLevelNum) {
	levelMap = new GameMap(newLevelNum);
	levelEnemies = new ArrayList<GoblinFigure>();
	int levelNum = newLevelNum;
    }

    public void setLevelEnemies(ArrayList<GoblinFigure> levelEnemies) {
	this.levelEnemies = new ArrayList<GoblinFigure>();
	for (int i = 0; i < levelEnemies.size(); i++) {
	    this.levelEnemies.add(levelEnemies.get(i));
	}
    }

    public void setLevelEnemies(GoblinFigure levelEnemy) {
	this.levelEnemies = new ArrayList<GoblinFigure>();
	this.levelEnemies.add(levelEnemy);
    }

    public void addLevelEnemies(ArrayList<GoblinFigure> newLevelEnemies) {
	for (int i = 0; i < newLevelEnemies.size(); i++) {
	    this.levelEnemies.add(newLevelEnemies.get(i));
	}
    }

    public void addLevelEnemies(GoblinFigure newLevelEnemy) {
	this.levelEnemies.add(newLevelEnemy);
    }

    public void clearLevelEnemies() {
	this.levelEnemies.clear();
    }

    public void removeLevelEnemies(GoblinFigure removedEnemy) {
	int enemyIndex = this.levelEnemies.indexOf(removedEnemy);
	if (enemyIndex != -1) {
	    this.levelEnemies.remove(enemyIndex);
	}
    }

    public void removeLevelEnemies(ArrayList<GoblinFigure> removedEnemies) {
	for (int i = 0; i < removedEnemies.size(); i++) {
	    this.removeLevelEnemies(removedEnemies.get(i));
	}
    }

    public ArrayList<GoblinFigure> getLevelEnemies() {
	return this.levelEnemies;
    }

    public GoblinFigure getLevelEnemy(int index) {
	return this.levelEnemies.get(index);
    }

    public GameMap getLevelMap() {
	return this.levelMap;
    }

    public void setLevelMap(GameMap newLevelMap) {
	this.levelMap = newLevelMap;
    }

    public int maxEnemyNum(int levelNumber) {
	if (Math.abs(levelNumber) <= 3) {
	    return Math.abs(levelNumber);
	}
	else {
	    return 4;
	}
    }
    
}
