package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.geom.*;
import java.awt.*;

/**
 * Creates the stick figure on the display that represents the MainCharacter object
 * used for the game
 *
 * @author Vivek Patel
 * @version CS56-W15 03/07, 1.0
 */

public class MainCharacterFigure implements Shape {

	private GeneralPath gp;
	public MainCharacter mc;
	
	/**
 	 * No-arg constructor for the MainCharacterFigure shape.
  	 */ 	 
	public MainCharacterFigure() {
		gp = new GeneralPath();
		mc = new MainCharacter();
	}
	
	/**
 	 * @param mc - the main character of the game
 	 * Creates a MainCharacterFigure shape
 	 */
	public MainCharacterFigure(MainCharacter mc) {
		gp = new GeneralPath();
		this.mc = mc;
		Ellipse2D.Double head = new Ellipse2D.Double(mc.getX() - 5, mc.getY(), 10, 10);
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
		if (x >= (mc.getX() - 5) && x <= (mc.getX() + 5) && y >= mc.getY() && y <= (mc.getY() + 30)) {
			return true;
		}
		return false;
	}
	
	
	public boolean contains(double x, double y, double w, double h) {
		if (x >= (mc.getX() - 5) && (x + w) <= (mc.getX() +5) && y >= (mc.getY() - 5) && (y + h) <= (mc.getY() + 5)) {
			return true;
		}
		return false;
	}
	
	public boolean contains(Point2D p) {
		if (p.getX() >= (mc.getX() - 5) && p.getX() <= (mc.getX() + 5) && p.getY() >= (mc.getY() - 5) && p.getY() <= (mc.getY() + 5)) {
			return true;
		}
		return false;
	}
	
	public boolean contains(Rectangle2D r) {
		return gp.contains(r);
	}
	
	public Rectangle getBounds() { 
		return gp.getBounds(); 
	}
    
    public Rectangle2D getBounds2D() { 
		return gp.getBounds2D(); 
	}

	
    public PathIterator getPathIterator(AffineTransform at) { 
		return gp.getPathIterator(at); 
	}
    

    public PathIterator getPathIterator(AffineTransform at, double flatness) { 
		return gp.getPathIterator(at, flatness); 
	}

	
    public boolean intersects(double x, double y, double w, double h) { 
		return gp.intersects(x, y, w, h);
	}


    public boolean intersects(Rectangle2D r) { 
		return gp.intersects(r); 
	}
    
    
}
