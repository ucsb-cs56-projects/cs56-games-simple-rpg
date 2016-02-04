package edu.ucsb.cs56.projects.games.simple_rpg;

import java.io.*;

/**
 * CLI version of the game. VERY basic.
 * 
 * @author Alvin Tan
 * 
 */
public class CLI {

	private int[][] map = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 }, };
	private double encounterChance = .30;
	private MainCharacter mc;
	private CLIOutput tb;
	private BufferedReader is = new BufferedReader(new InputStreamReader(
			System.in));

	/**
	 * Method for Starting the Game
	 * 
	 */
	public void start() {
		load();
		String s;
		allocateStats();
		tb.printMCStatus(mc);
		tb.printDefaultOptions();
		try {
			s = is.readLine();
			while (s != null && s.length() != 0) {
				switch (Integer.parseInt(s)) {
				case 1:
					if (mc.moveLeft(map)) {
						if (Math.random() <= encounterChance) {
							if (!battleState()) {
								return;
							}
							break;
						}
					} else {
						System.out.println("Can't move that way.");
					}
					break;
				case 2:
					if (mc.moveRight(map)) {
						if (Math.random() <= encounterChance) {
							if (!battleState()) {
								return;
							}
							break;
						}
					} else {
						System.out.println("Can't move that way.");
					}
					break;
				case 3:
					if (mc.moveUp(map)) {
						if (Math.random() <= encounterChance) {
							if (!battleState()) {
								return;
							}
							break;
						}
					} else {
						System.out.println("Can't move that way.");
					}
					break;
				case 4:
					if (mc.moveDown(map)) {
						if (Math.random() <= encounterChance) {
							if (!battleState()) {
								return;
							}
							break;
						}
					} else {
						System.out.println("Can't move that way.");
					}
					break;
				case 5:
					return;
				default:
					System.out
							.println("***This is NOT an option! Try again.***");
					break;
				}
				if (mc.levelUp()) {
					System.out
							.println("***Congratulations, You've leveled up!***");
					allocateStats();
				}
				tb.printMCStatus(mc);
				tb.printDefaultOptions();
				s = is.readLine();
				while (s == null || s.length() == 0) {
					s = is.readLine();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Private method used by class CLI
	 * 
	 */
	private void load() {
		mc = new MainCharacter();
		tb = new CLIOutput();
	}

	/**
	 * Method to handle the Battle State of the game.
	 * 
	 * @return true if player won the battle and false if otherwise
	 */
	private boolean battleState() {
		tb.printMCStatus(mc);
		System.out.println("You've encountered an enemy.");
		System.out.println();
		Enemy en = generateEnemy();
		tb.printEStatus(en);
		tb.printBattleOptions();
		String s;
		int temp;
		try {
			s = is.readLine();
			while (s != null && s.length() != 0) {
				if (mc.getAgi() > en.getAgi()) {
					switch (Integer.parseInt(s)) {
					case 1:
						if (!en.isDead()) {
							temp = mc.attack(en);
							if (temp == -1) {
								System.out.println("You missed!");
							} else {
								temp = en.attacked(temp);
								System.out.println("You hit it for " + temp
										+ " damage!");
							}
						}
						if (en.isDead()) {
							System.out.println("You've defeated the enemy!");
							mc.retrieveReward(en);
							tb.printReward(en);
							return true;
						}
						if (!en.isDead()) {
							temp = en.attack(mc);
							if (temp == -1) {
								System.out.println("You dodged it's attack!");
							} else {
								temp = mc.attacked(temp);
								System.out.println("You lost " + temp + " hp!");
							}
						}
						if (mc.isDead()) {
							System.out.println("You've died. GAME OVER.");
							System.out.println("---");
							return false;
						}
						break;
					case 2:
						System.out.println("You managed to get away!");
						return true;
					default:
						break;
					}
				} else {
					switch (Integer.parseInt(s)) {
					case 1:
						if (!en.isDead()) {
							temp = en.attack(mc);
							if (temp == -1) {
								System.out.println("You dodged it's attack!");
							} else {
								temp = mc.attacked(temp);
								System.out.println("You lost " + temp + " hp!");
							}
						}
						if (mc.isDead()) {
							System.out.println("You've died. GAME OVER.");
							return false;
						}
						if (!mc.isDead()) {
							temp = mc.attack(en);
							if (temp == -1) {
								System.out.println("You missed!");
							} else {
								temp = en.attacked(temp);
								System.out.println("You hit it for " + temp
										+ " damage!");
							}
						}
						if (en.isDead()) {
							System.out.println("You've defeated the enemy!");
							mc.retrieveReward(en);
							tb.printReward(en);
							return true;
						}
						break;
					case 2:
						System.out.println("You managed to get away!");
						return true;
					default:
						break;
					}
				}
				tb.printMCStatus(mc);
				tb.printEStatus(en);
				tb.printBattleOptions();
				s = is.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Method to generate a random enemy.
	 * 
	 * @return a random Enemy
	 */
	public Enemy generateEnemy() {
		switch ((int) (Math.random() * 2)) {
		case 1:
			return new Goblin();
		default:
			return new Goblin();
		}
	}

	/**
	 * Method to let the player allocate his/her stat points.
	 * 
	 */
	public void allocateStats() {
		String s;
		try {
			while (mc.getStatPoints() > 0) {
				System.out.println("You must use all stat points.");
				System.out.println("Stat Points Remaining: "
						+ mc.getStatPoints());
				System.out.println("Current Stats: ");
				System.out.println("Agi: " + mc.getAgi() + " Intel: "
						+ mc.getIntel() + " Sta: " + mc.getSta() + " Str: "
						+ mc.getStr());
				tb.printStatOptions();
				s = is.readLine();
				switch (Integer.parseInt(s)) {
				case 1:
					mc.incrementAgi();
					break;
				case 2:
					mc.incrementIntel();
					break;
				case 3:
					mc.incrementSta();
					break;
				case 4:
					mc.incrementStr();
					break;
				default:
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
