/**
    This class constructs a line defined by two points: the start 
    and end points, as well as parameters for thickness and color. 
    It implements the Drawing Object interface.

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

    /**
     * Constructs a Line object with the specified parameters.
     *
     * @param startx    The x-coordinate of the start point.
     * @param starty    The y-coordinate of the start point.
     * @param endx      The x-coordinate of the end point.
     * @param endy      The y-coordinate of the end point.
     * @param thickness The thickness of the line.
     * @param color     The color of the line.
     */

    public Line(double startx, double starty, double endx, double endy, int thickness, Color color) {
        this.startx = startx;
        this.starty = starty;
        this.endx = endx;
        this.endy = endy;
        this.thickness = thickness;
        this.color = color;
    }

    /**
     * This method draws the line segment using the Graphics2D object.
     * It creates a Line2D.Double object with the specified start and end points,
     * sets the color and stroke thickness, and then draws the line.
     *
     * @param g2d The Graphics2D object used to draw the line.
     */
    @Override
    public void draw(Graphics2D g2d) {
        var reset = g2d.getTransform();
        Line2D.Double l = new Line2D.Double(startx, starty, endx, endy);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.draw(l);
        g2d.setTransform(reset);
    }

    /**
     * This method updates the position of the line by adding the specified vector
     * to the coordinates of both the start and end points.
     *
     * @param vector The vector indicating the translation to be applied to the
     *               line.
     */

    @Override
    public void setPosition(Vector vector) {
        startx += vector.getX();
        starty += vector.getY();
        endx += vector.getX();
        endy += vector.getY();
    }

    /**
     * This method retrieves the position vector of the line, representing the
     * coordinates
     * of its start point.
     *
     * @return The position vector representing the start point of the line.
     */

    @Override
    public Vector getPosition() {
        return new Vector(startx, starty);
    }
}
