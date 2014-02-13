/**
 * 
 */
package com.teamshadowstudios.simpleRPG;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**Contains Main() for the full game.
 * @author Alvin Tan
 *
 */
public class SimpleRPG {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create a JFrame with title
		JFrame frame = new JFrame("Simple RPG");

		// Set Size of window
		frame.setSize(800, 600);
		frame.setUndecorated(true);

		// Always do this so that the red X (or red circle) works
		// to close the window.

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// center the window on open
		frame.setLocationRelativeTo(null);

		// Create a JPanel to display the game
		Display disp = new Display();

		// allow it to be focusable so that it can read input
		disp.setFocusable(true);

		// add Everything to the JFrame
		frame.add(disp, BorderLayout.CENTER);

		// Make the window visible
		frame.setVisible(true);
	}

}
