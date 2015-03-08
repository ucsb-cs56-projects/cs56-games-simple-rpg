/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.BorderLayout;

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
        // allow it to be focusable so that it can read input
        disp.setFocusable(true);

        // add Everything to the JFrame
        frame.add(disp, BorderLayout.CENTER);
	frame.add(shop, BorderLayout.EAST);

        // Make the window visible
        frame.setVisible(true);
    }

}
