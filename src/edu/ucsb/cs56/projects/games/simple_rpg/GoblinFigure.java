package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.geom.*;
import java.awt.*;

/**
 *
 * Creates the graphical figure that represents the Goblin object
 *
 * @author Nick Perry
 * @version CS56-F16 11/9, 1.0
 *
 */

public class GoblinFigure implements Shape {

    private GeneralPath gp;
    public Goblin gob;

    // No-arg constructor
    public GoblinFigure() {
	gp = new GeneralPath();
	gob = new Goblin();
    }

    public GoblinFigure(Goblin gob) {
	gp = new GeneralPath();
	this.gob = gob;
	Ellipse2D.Double head = new Ellipse2D.Double(gob.getX() - 5,
						     gob.getY(),
						     10,
						     10);
	Line2D.Double body = new Line2D.Double(gob.getX(),
					       gob.getY() + 10,
					       gob.getX(),
					       gob.getY() + 25);
	Line2D.Double leftLeg = new Line2D.Double(gob.getX(),
						  gob.getY() + 25,
						  gob.getX() - 5,
						  gob.getY() + 30);
	Line2D.Double rightLeg = new Line2D.Double(gob.getX(),
						   gob.getY() + 25,
						   gob.getX() + 5,
						   gob.getY() + 30);
	Line2D.Double leftArm = new Line2D.Double(gob.getX(),
						  gob.getY() + 15,
						  gob.getX() - 5,
						  gob.getY() + 20);
	Line2D.Double rightArm = new Line2D.Double(gob.getX(),
						   gob.getY() + 15,
						   gob.getX() + 5,
						   gob.getY() + 20);
	gp.append(head, false);
	gp.append(body, false);
	gp.append(leftLeg, false);
	gp.append(rightLeg, false);
	gp.append(leftArm, false);
	gp.append(rightArm, false);

    }

    // Methods implemented below were copied from the
    // MainCharacterFigure class, they are identical.
    // | | | | | | | | | | | | | | | | | | | | | | |
    // V V V V V V V V V V V V V V V V V V V V V V V

    public boolean contains(double x, double y) {
	if (x >= (gob.getX() - 5) && x <= (gob.getX() + 5) && y >= gob.getY() && y <= (gob.getY() + 30)) {
	    return true;
	}
	return false;
    }


    public boolean contains(double x, double y, double w, double h) {
	if (x >= (gob.getX() - 5) && (x + w) <= (gob.getX() +5) && y >= (gob.getY() - 5) && (y + h) <= (gob.getY() + 5)) {
	    return true;
	}
	return false;
    }

    public boolean contains(Point2D p) {
	if (p.getX() >= (gob.getX() - 5) && p.getX() <= (gob.getX() + 5) && p.getY() >= (gob.getY() - 5) && p.getY() <= (gob.getY() + 5)) {
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
