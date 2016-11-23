package edu.ucsb.cs56.projects.games.simple_rpg;

import java.awt.geom.*;
import java.awt.*;

/**
 *
 * Creates the graphical figure that represents the Trader object
 *
 * @author Nick Perry
 * @version CS56-F16 11/9, 1.0
 *
 */

public class TraderFigure implements Shape {

    private GeneralPath gp;
    public Trader trdr;

    // No-arg constructor
    public TraderFigure() {
	gp = new GeneralPath();
	trdr = new Trader(2);
    }

    public TraderFigure(Trader trdr) {
	gp = new GeneralPath();
	this.trdr = trdr;
	Ellipse2D.Double head = new Ellipse2D.Double(trdr.getX() - 5,
						     trdr.getY(),
						     10,
						     10);
	Line2D.Double body = new Line2D.Double(trdr.getX(),
					       trdr.getY() + 10,
					       trdr.getX(),
					       trdr.getY() + 25);
	Line2D.Double leftLeg = new Line2D.Double(trdr.getX(),
						  trdr.getY() + 25,
						  trdr.getX() - 5,
						  trdr.getY() + 30);
	Line2D.Double rightLeg = new Line2D.Double(trdr.getX(),
						   trdr.getY() + 25,
						   trdr.getX() + 5,
						   trdr.getY() + 30);
	Line2D.Double leftArm = new Line2D.Double(trdr.getX(),
						  trdr.getY() + 15,
						  trdr.getX() - 5,
						  trdr.getY() + 20);
	Line2D.Double rightArm = new Line2D.Double(trdr.getX(),
						   trdr.getY() + 15,
						   trdr.getX() + 5,
						   trdr.getY() + 20);
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
	if (x >= (trdr.getX() - 5) && x <= (trdr.getX() + 5) && y >= trdr.getY() && y <= (trdr.getY() + 30)) {
	    return true;
	}
	return false;
    }


    public boolean contains(double x, double y, double w, double h) {
	if (x >= (trdr.getX() - 5) && (x + w) <= (trdr.getX() +5) && y >= (trdr.getY() - 5) && (y + h) <= (trdr.getY() + 5)) {
	    return true;
	}
	return false;
    }

    public boolean contains(Point2D p) {
	if (p.getX() >= (trdr.getX() - 5) && p.getX() <= (trdr.getX() + 5) && p.getY() >= (trdr.getY() - 5) && p.getY() <= (trdr.getY() + 5)) {
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
