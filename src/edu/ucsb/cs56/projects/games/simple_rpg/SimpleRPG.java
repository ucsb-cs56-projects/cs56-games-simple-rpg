/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

/**
 * Contains Main() for the full game.
 *
 * @author Alvin Tan
 */
public class SimpleRPG {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // create a JFrame with title
        JFrame frame = new JFrame("Simple RPG");

        // Set Size of window
        frame.setSize(920, 800);
        //frame.setUndecorated(true);

        // Always do this so that the red X (or red circle) works
        // to close the window.

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center the window on open
        frame.setLocationRelativeTo(null);

        // Create a JPanel to display the game
        Display disp = new Display();
	JButton shop = new JButton("Go to shop");
	shop.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Shop weaponShop = new Shop();
			String [] weaponNames = new String[5];
			weaponNames[0] = "Fists";
			for (int i = 1; i < weaponShop.inventory.size() + 1; i++) {
				Weapon temp = weaponShop.inventory.get(i);
				weaponNames[i] = temp.getWeaponName();
			}
			JFrame frame = new JFrame("Shop");
			frame.setSize(400, 200);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JComboBox weaponSelect = new JComboBox(weaponNames);
			JButton buy = new JButton("Buy");
			frame.add(weaponSelect, BorderLayout.CENTER);
			frame.add(buy, BorderLayout.CENTER);
			frame.setVisible(true);
		}
	});
        // allow it to be focusable so that it can read input
        disp.setFocusable(true);

        // add Everything to the JFrame
        frame.add(disp, BorderLayout.CENTER);
	frame.add(shop, BorderLayout.EAST);

        // Make the window visible
        frame.setVisible(true);
    }

}
