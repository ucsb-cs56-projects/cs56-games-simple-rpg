package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.*;

/**
 * @author Vivek Patel
 * @version CS56-W15 03/07, 1.0
 */

public class MainCharacterFigure implements Shape {

	private GeneralPath gp;
	
	/**
 	 * No-arg constructor for the MainCharacterFigure shape.
  	 */ 	 
	public MainCharacterFigure() {
		//STUB -- not going to be used.
	}
	
	/**
 	 * @param mc - the main character of the game
 	 * Creates a MainCharacterFigure shape
 	 */
	public MainCharacterFigure(MainCharacter mc) {
		Ellipse2D head = new Ellipse2D(mc.getX() - 5, mc.getY(), 10, 10);
		Line2D.Double body = new Line2D.Double(mc.getX(), mc.getY() + 10, mc.getX(), mc.getY() + 25);
		Line2D.Double leftLeg = new Line2D.Double(mc.getX(), mc.getY() + 25, mc.getX() - 5, mc.getY() + 30);
		Line2D.Double rightLeg = new Line2D.Double(mc.getX(), mc.getY() + 25, mc.getX() + 5, mc.getY() + 30);
		Line2D.Double leftArm = new Line2D.Double(mc.getX(), mc.getY() + 15, mc.getX() - 5, mc.getY() + 20);
		Line2D.Double rightArm = new Line2D.Double(mc.getX(), mc.getY() + 15, mc.getX() + 5, mc.getY() + 20);
		gp.append(head, false);
		gp.append(body, false);
		gp.append(leftLeg, false);
		gp.append(rightLeg, false);
		gp.append(leftArm, false);
		gp.append(rightArm, false);  
	}

	public boolean contains(double x, double y) {

	}
}
