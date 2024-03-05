/**
	The "Cloud" class in the "drawingObjects" package represents a cloud 
	object, a composite shape. It utilizes Java AWT and a custom Vector 
	class to attain smooth animation.	
	
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

public class Cloud implements DrawingObject, AnimatedObject {

    private double x;
    private double y;
    private double size;
    private Color color;
    private double speed;
    private static final int GUI_WIDTH = 800;

    public Cloud(double x, double y, double size, Color color, double speed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.speed = speed;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Rectangle2D.Double body = new Rectangle2D.Double(x, y, size, size);
        Ellipse2D.Double c2 = new Ellipse2D.Double(x - size * .5, y, size * 1.1, size * 1.1);
        Ellipse2D.Double c3 = new Ellipse2D.Double(x + size * .5, y, size * 1.1, size * 1.1);
        Ellipse2D.Double c4 = new Ellipse2D.Double(x, y, size * 1.1, size * 1.1);
        Ellipse2D.Double c5 = new Ellipse2D.Double(x + size * .5, y - size / 4, size * .9, size * .9);
        Ellipse2D.Double c6 = new Ellipse2D.Double(x - size * .1, y - size / 4, size * .9, size * .8);

        g2d.setColor(color);
        g2d.fill(body);
        g2d.fill(c2);
        g2d.fill(c3);
        g2d.fill(c4);
        g2d.fill(c5);
        g2d.fill(c6);
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

    @Override
    public void animateStep(float delta) {
        x += speed * delta;

        if (x - size * .5 >= GUI_WIDTH) {
            x = -(size * 1.70);
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setX(double newX) {
        x = newX;
    }
}
