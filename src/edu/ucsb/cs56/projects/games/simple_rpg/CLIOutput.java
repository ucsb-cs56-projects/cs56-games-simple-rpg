/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg;

/**
 * Handles output for CLI implementation.
 *
 * @author Alvin Tan
 */
public class CLIOutput {
    /**
     * Prints the default options for the Main Character 
     * when not in a battle or an interaction.
     */
    public void printDefaultOptions() {
        System.out.println("1: Move Left");
        System.out.println("2: Move Right");
        System.out.println("3: Move Up");
        System.out.println("4: Move Down");
        System.out.println("5: Quit Game");
        System.out.println("***End Output***");
    }

    /**
     * Prints the commands the Main Character
     * can choose from when in a Battle
     */
    public void printBattleOptions() {
        System.out.println("1: Attack");
        System.out.println("2: Run Away");
        System.out.println("***End Output***");
    }

    /**
     * Prints out Main Character stats;
     * level; HP, MP, XP; Gold; Location
     *
     * @param mc MainCharacter
     */
    public void printMCStatus(MainCharacter mc) {
        System.out.println("~~~Info~~~");	 
        System.out.println("MainCharacter LV: " + mc.getLvl());
        System.out.println("HP: " + mc.getHp() + "/" + mc.getMaxHP() + " MP: " + mc.getMp() + "/"
                + mc.getMaxMP() + " XP: " + mc.getXp() + "/" + mc.getNeedXP());
        System.out.println("Gold: " + mc.getGold());
        System.out.println("Current Location: (" + mc.getX() + "," + mc.getY() + ")");
        System.out.println();
    }

    /**
     * Prints out the Enemy's stats;
     * name; level; HP; MP
     *
     * @param e Enemy
     */
    public void printEStatus(Enemy e) {
        System.out.println(e.getName() + " LV: " + e.getLvl());
        System.out.println("HP: " + e.getHp() + "/" + e.getMaxHP() + " MP: " + e.getMp() + "/"
                + e.getMaxMP());
        System.out.println();
    }

    /**
     * Prints the amount of Gold/Exp you gain
     *
     * @param e Enemy
     */
    public void printReward(Enemy e) {
        System.out.println("You gained " + e.loot().getXp() + " XP!");
        System.out.println("You got " + e.loot().getGold() + " gold!");
	System.out.println("~~~End Results~~~");
        System.out.println();
    }

    /**
     * Prints options for stats allocation (LVL UP)
     */
    public void printStatOptions() {
        System.out.println("1: Add 1 Agility");
        System.out.println("2: Add 1 Inteligence");
        System.out.println("3: Add 1 Stamina");
        System.out.println("4: Add 1 Strength");
        System.out.println("***End Output***");
    }
}
