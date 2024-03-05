/**
    This class implements the DrawingObject interface to create a
    rectangle. Utilizing its constructor allows the creation of
    customizable rectangles.

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

import java.awt.*;
import java.awt.geom.Rectangle2D;

import customData.Vector;

public class Rectangle implements DrawingObject {

    protected double x;
    protected double y;
    protected double width;
    protected double height;
    protected Color color;

    /**
     * Constructs a Rectangle object with the specified position, dimensions, and
     * color.
     *
     * @param x      the x-coordinate of the top-left corner of the rectangle
     * @param y      the y-coordinate of the top-left corner of the rectangle
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     * @param color  the color of the rectangle
     */

    public Rectangle(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Draws a rectangle with the specified position, dimensions, and color.
     * 
     * @param g2d The graphics 2D used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        Rectangle2D.Double rect = new Rectangle2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.fill(rect);
    }

    /**
     * Sets the position of the rectangle to the specified vector.
     * 
     * @param vector The vector representing the new position of the rectangle.
     */
    @Override
    public void setPosition(Vector vector) {
        x = vector.getX();
        y = vector.getY();
    }

    /**
     * Retrieves the current position of the rectangle.
     * 
     * @return The vector representing the current position of the rectangle.
     */
    @Override
    public Vector getPosition() {
        return new Vector(x, y);
    }
}
