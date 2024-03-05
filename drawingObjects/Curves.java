/**
	This class can draw various complex shapes using Bézier curves. 
	It takes an array of control points and their corresponding 
	Bézier points to define the shape and color of the curve.
	
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

public class Curves implements DrawingObject {

    private ArrayList<Vector[]> points;
    private Color color;

    /**
     * Accepts an arraylist of arrays of vectors with size 3,
     * with the first array being the starting point,
     * and the subsequent arrays consisting of:
     * the next point,
     * the bezier point of the previous point,
     * the bezier point of the end point
     * 
     * @param points points of path and bezier points.
     * @param color, color of the curved shape.
     */
    public Curves(ArrayList<Vector[]> points, Color color) {
        this.points = points;
        this.color = color;
    }

    /**
     * Draws the path from the points given and fills it with the color.
     * @param g2d the Graphics2D object for drawing.
     */
    @Override
    public void draw(Graphics2D g2d) {
        Path2D.Double p = new Path2D.Double();
        Vector start = points.get(0)[0];
        p.moveTo(start.getX(), start.getY());
        for (int i = 1; i < points.size(); i++) {
            Vector nextpoint = points.get(i)[0];
            if (points.get(i).length == 1) {
                p.lineTo(nextpoint.getX(), nextpoint.getY());
                continue;
            }
            Vector startB = points.get(i)[1];
            Vector endB = points.get(i)[2];
            p.curveTo(startB.getX(), startB.getY(),
                    endB.getX(), endB.getY(),
                    nextpoint.getX(), nextpoint.getY());
        }
        p.closePath();
        g2d.setColor(color);
        g2d.fill(p);
    }

    /**
     * Changes the position of the Curved Shape to the vector by translating all the points
     * towards the vector.
     * @param vector the new position of the Curved shape.
     */
    @Override
    public void setPosition(Vector vector) {
        var start = getPosition();
        if (start == null)
            return;
        var diff = start.subtract(vector);
        for (int i = 0; i < points.size(); i++) {
            var curvePoints = points.get(i);
            for (int j = 0; j < 3; j++) {
                curvePoints[j].add(diff);
            }
        }
    }

    /**
     * Returns the current position (the first path point) of the Curved Shape;
     */
    @Override
    public Vector getPosition() {
        if (points.size() < 1)
            return null;
        return points.get(0)[0];
    }

    /**
     * Sets the color of the Curved shape.
     */
    public void setColor(Color color) {
        this.color = color;
    }
}