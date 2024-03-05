/**
    This class represents and renders polygons. 
    It allows the creation of custom polygons through
    a series of points.

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

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;

import customData.Vector;

public class Polygon implements DrawingObject {

    private ArrayList<Vector> points;
    private Color color;

    /**
     * Constructs a Polygon object with the specified list of points and color.
     *
     * @param points the list of points defining the polygon
     * @param color  the color of the polygon
     */
    public Polygon(ArrayList<Vector> points, Color color) {
        this.points = points;
        this.color = color;
    }

    /**
     * Renders the polygon on the screen using the provided Graphics2D object.
     *
     * @param g2d the Graphics2D object to draw the polygon
     */
    @Override
    public void draw(Graphics2D g2d) {
        var p = new Path2D.Double();
        if (points.size() <= 1)
            return;
        Vector start = points.get(0);
        p.moveTo(start.getX(), start.getY());
        for (int i = 1; i < points.size(); i++) {
            Vector point = points.get(i);
            p.lineTo(point.getX(), point.getY());
        }
        p.closePath();
        g2d.setColor(color);
        g2d.fill(p);
    }

    /**
     * This method updates the position of the polygon to the specified vector. It
     * calculates the difference between the current position of the first point of
     * the polygon and the new position vector. Afterward, it adjusts all points of
     * the polygon by adding this difference, effectively relocating the entire
     * polygon.
     *
     * @param vector The vector indicating the new position of the polygon.
     */

    @Override
    public void setPosition(Vector vector) {
        var difference = Vector.subtract(points.get(0), vector);
        for (int i = 0; i < points.size(); i++) {
            points.get(i).add(difference);
        }
    }

    /**
     * This method retrieves the position vector of the polygon, which corresponds
     * to the position of its first point.
     *
     * @return The position vector representing the position of the polygon.
     */
    @Override
    public Vector getPosition() {
        return points.get(0);
    }
}
