/**
 *
 */
package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

import java.util.Timer;

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
	// note that the Display must be declared final so that its variables can be used in the shop
        final Display disp = new Display();
	JButton shop = new JButton("Go to shop");
        shop.setFocusable(false);
	shop.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    ShopDisplay shopWindow = new ShopDisplay(disp.gm.mc);
			shopWindow.setVisible(true);
		}
	});
        // allow it to be focusable so that it can read input
        disp.setFocusable(true);

        // add Everything to the JFrame
        frame.add(disp, BorderLayout.CENTER);
	frame.add(shop, BorderLayout.EAST);

        // game loop/timer; this is main game logic loop
        final java.util.Timer timer = new java.util.Timer();
        final boolean isRunning = true;
        final int fps = 30; // tfw the human eye can only see 24 fps

        class LoopDisplay extends java.util.TimerTask {
            public void run() {
                disp.repaint(); // all of the game logic is handled right here
                
                if (!isRunning)
                    timer.cancel();
            }
        }

        timer.schedule(new LoopDisplay(), 0, 1000/fps);


        // Make the window visible
        frame.setVisible(true);
    }

}
