/**
    This class constructs a line segment defined by two points: 
    the start and end points, as well as parameters for thickness 
    and color. It implements the Drawing Object interface.

    @author Alinus Abuke (230073)	
    @author Neil Aldous Biason (230940)
    @version 06 March 2024

    We have not discussed the Java language code in our program 
    with anyone other than our instructor or the teaching assistants 
    assigned to this course.

    We have not used Java language code obtained from another student, 
    or any other unauthorized source, either modified or unmodified.

    If any Java language code or documentation used in our program 
    was obtained from another source, such as a textbook or website, 
    that has been clearly noted with a proper citation in the comments 
    of our program.
**/

package drawingObjects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import customData.Vector;

public class Line implements DrawingObject {

    private double startx;
    private double starty;
    private double endx;
    private double endy;
    private int thickness;
    private Color color;

    public Line(double startx, double starty, double endx, double endy, int thickness, Color color) {
        this.startx = startx;
        this.starty = starty;
        this.endx = endx;
        this.endy = endy;
        this.thickness = thickness;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        var reset = g2d.getTransform();
        Line2D.Double l = new Line2D.Double(startx, starty, endx, endy);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.draw(l);
        g2d.setTransform(reset);
    }

    @Override
    public void setPosition(Vector vector) {
        startx += vector.getX();
        starty += vector.getY();
        endx += vector.getX();
        endy += vector.getY();
    }

    @Override
    public Vector getPosition() {
        return new Vector(startx, starty);
    }
}
