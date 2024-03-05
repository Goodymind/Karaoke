/**
	The "Circle" class in the "drawingObjects" package implements the 
	"DrawingObject" interface to represent a circle. It has methods 
	for drawing the circle, setting its position, and retrieving its position.
	
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
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import customData.Vector;

public class Circle implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color color;

    public Circle(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        Ellipse2D.Double e = new Ellipse2D.Double(0, 0, size, size);
        g2d.translate(x, y);
        g2d.setColor(color);
        g2d.fill(e);
        g2d.setTransform(reset);
    }

    @Override
    public void setPosition(Vector vector) {
        x = vector.getX();
        y = vector.getY();
    }

    @Override
    public Vector getPosition() {
        return new Vector(x, y);
    }
}