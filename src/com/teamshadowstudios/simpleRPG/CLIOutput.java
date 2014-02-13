/**
 * 
 */
package com.teamshadowstudios.simpleRPG;

/**Handles output for CLI implementation.
 * @author Alvin Tan
 *
 */
public class CLIOutput {
	/**Prints default options
	 * 
	 */
	public void printDefaultOptions(){
		System.out.println("1: Move Left");
		System.out.println("2: Move Right");
		System.out.println("3: Move Up");
		System.out.println("4: Move Down");
		System.out.println("5: Quit Game");
		System.out.println("---");
	}
	/**prints battle options.
	 * 
	 */
	public void printBattleOptions(){
		System.out.println("1: Attack");
		System.out.println("2: Run Away");
		System.out.println("---");
	}
	/**prints the MainCharacter's Status
	 * @param mc MainCharacter
	 */
	public void printMCStatus(MainCharacter mc){
		System.out.println("MainCharacter LV: "+mc.getLvl());
		System.out.println("HP: "+mc.getHp()+"/"+mc.getMaxHP()+" MP: "+mc.getMp()+"/"
							+mc.getMaxMP()+" XP: "+mc.getXp()+"/"+mc.getNeedXP());
		System.out.println("Gold: "+mc.getGold());
		System.out.println("Current Location: ("+mc.getX()+","+mc.getY()+")");
		System.out.println();
	}
	/**prints the enemy's status
	 * @param e Enemy
	 */
	public void printEStatus(Enemy e){
		System.out.println(e.getName()+" LV: "+e.getLvl());
		System.out.println("HP: "+e.getHp()+"/"+e.getMaxHP()+" MP: "+e.getMp()+"/"
							+e.getMaxMP());
		System.out.println();
	}
	/**prints the reward from the enemy.
	 * @param e Enemy
	 */
	public void printReward(Enemy e){
		System.out.println("You gained "+e.giveReward().getXp()+" XP!");
		System.out.println("You got "+e.giveReward().getGold()+" gold!");
		System.out.println();
	}
	/**prints the options for using stat points
	 * 
	 */
	public void printStatOptions(){
		System.out.println("1: Add 1 Agility");
		System.out.println("2: Add 1 Inteligence");
		System.out.println("3: Add 1 Stamina");
		System.out.println("4: Add 1 Strength");
		System.out.println("---");
	}
}
