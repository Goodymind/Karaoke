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

    public Polygon(ArrayList<Vector> points, Color color) {
        this.points = points;
        this.color = color;
    }

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

    @Override
    public void setPosition(Vector vector) {
        var difference = Vector.subtract(points.get(0), vector);
        for (int i = 0; i < points.size(); i++) {
            points.get(i).add(difference);
        }
    }

    @Override
    public Vector getPosition() {
        return points.get(0);
    }

}
