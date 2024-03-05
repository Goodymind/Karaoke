/**
    This class represents a square shape and provides methods for drawing it. 
    It was created to enhance optimization and improve the clarity of visual elements.

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
import java.awt.geom.*;

import customData.Vector;

public class Square implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color color;

    /**
     * Constructor methodl; Initializes a square shape with the coordinate of the
     * origin(starting point), size, and color.
     * 
     * @param x     The x-coordinate.
     * @param y     The y-coordinate.
     * @param size  The size of the square.
     * @param color The color of the square.
     */
    public Square(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    /**
     * Renders the square shape using the provided 2D graphics object, ensuring
     * proper positioning and appearance.
     * 
     * @param g2d The 2D graphics object used for rendering.
     */
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        Rectangle2D.Double rect = new Rectangle2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.fill(rect);

        g2d.setTransform(reset);
    }

    /**
     * Updates the position of the square shape based on the provided vector,
     * enabling animation and positioning within the graphical scene.
     * 
     * @param vector The vector containing the new position coordinates.
     */
    @Override
    public void setPosition(Vector vector) {
        x = vector.getX();
        y = vector.getY();
    }

    /**
     * Retrieves the current position of the square shape as a vector, allowing
     * external components to access and manipulate its location.
     * 
     * @return The vector representing the current position of the square.
     */
    @Override
    public Vector getPosition() {
        return new Vector(x, y);
    }

}