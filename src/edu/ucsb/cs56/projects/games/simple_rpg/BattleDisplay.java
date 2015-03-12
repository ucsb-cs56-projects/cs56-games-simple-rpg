package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.*;
import javax.swing.*;

/**
 * Represents the window that displays the battle options 
 * and battle info for the player when a battle begins
 *
 * @author Vivek Patel
 * @version CS56-W15 03/08, 1.0
 */

public class BattleDisplay extends JFrame {

	private JButton attack;
	private JButton runAway;
	private JPanel battleInfo;
	private BorderLayout battleLayout; 
	
	/**
 	 * No-arg default constructor for the BattleDisplay class, which
 	 * extends the JFrame class.
 	 */ 

	public BattleDisplay() {
		super("Battle");
		attack = new JButton("Attack");
		runAway = new JButton("Run away");
		battleLayout = new BorderLayout();
		this.setLayout(battleLayout);
	}

}

