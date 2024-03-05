/**
    This class is a subclass of the Rectangle class and employs gradient 
    functionality. Primarily employed for scenery backgrounds, it includes 
    parameters for the start and endpoint of the gradients, providing enhanced 
    control and flexibility over the gradient's appearance.

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

public class RectangleBackground extends Rectangle {

    protected Color color2;
    protected double endX;
    protected double endY;
    protected double startX;
    protected double startY;

    /**
     * Draws a rectangle with a gradient background using the specified start and
     * end points for the gradient. This subclass of Rectangle provides enhanced
     * control over the appearance of gradient backgrounds, suitable for scenery
     * backgrounds.
     * 
     * @param x      The x-coordinate of the top-left corner of the rectangle.
     * @param y      The y-coordinate of the top-left corner of the rectangle.
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     * @param color1 The starting color of the gradient.
     * @param color2 The ending color of the gradient.
     * @param startX The x-coordinate of the start point of the gradient.
     * @param startY The y-coordinate of the start point of the gradient.
     * @param endX   The x-coordinate of the end point of the gradient.
     * @param endY   The y-coordinate of the end point of the gradient.
     */
    public RectangleBackground(double x, double y, double width, double height, Color color1, Color color2,
            double startX, double startY, double endX, double endY) {
        super(x, y, width, height, color1);
        this.color2 = color2;
        this.endX = endX;
        this.endY = endY;
        this.startX = startX;
        this.startY = startY;
    }

    /**
     * Draws a rectangle with a gradient background using the specified start and
     * end points for the gradient. The gradient colors are determined by 'color'
     * and 'color2'.
     * 
     * @param g2d The graphics2D used for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        GradientPaint gradient = new GradientPaint((float) startX, (float) startY, color, (float) endX, (float) endY,
                color2);
        g2d.setPaint(gradient);
        Rectangle2D.Double rect = new Rectangle2D.Double(x, y, width, height);
        g2d.fill(rect);
    }
}