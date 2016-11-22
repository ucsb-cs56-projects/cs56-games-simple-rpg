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
        frame.setSize(910, 850);
        //frame.setUndecorated(true);

        // Always do this so that the red X (or red circle) works
        // to close the window.

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center the window on open
        frame.setLocationRelativeTo(null);

        // Create a JPanel to display the game
	// note that the Display must be declared final so that its variables can be used in the shop
        final Display disp = new Display();
	JButton shop = new JButton("Go to shop");
	shop.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    ShopDisplay shopWindow = new ShopDisplay(disp.gm.mc);
			shopWindow.setVisible(true);
		}
	});
	JButton inv = new JButton("Set Weapon");
	inv.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    InventoryDisplay invWindow = new InventoryDisplay(disp.gm.mc);
		        invWindow.setVisible(true);
		}
	});
        // allow it to be focusable so that it can read input
        disp.setFocusable(true);

        // add Everything to the JFrame
        frame.add(disp, BorderLayout.CENTER);
	frame.add(shop, BorderLayout.EAST);
	frame.add(inv, BorderLayout.SOUTH);

        // Make the window visible
        frame.setVisible(true);
    }

}
