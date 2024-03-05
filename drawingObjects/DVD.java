/**
	This class represents a dynamic object that visually resembles a DVD 
	bouncing around the screen. Also implements a MouseListener to provide
	interactivity.
	
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
import java.util.ArrayList;

import customData.Vector;

public class DVD implements DrawingObject, AnimatedObject {

    private static final int GUI_WIDTH = 800;
    private static final int GUI_HEIGHT = 600;
    private Vector position;
    private Vector velocity;
    private float size;
    private Color color;
    Curves dvd;

    public DVD(Vector position, float size, Color color) {
        this.position = position;
        this.size = size;
        this.color = color;
        dvd = initDVD();
        velocity = Vector.RIGHT.multiply(40);
    }

    private Curves initDVD() {
        ArrayList<Vector[]> points = new ArrayList<Vector[]>();
        points.add(new Vector[] { new Vector(0.1, 0.26) });
        points.add(new Vector[] { new Vector(0.46, 0.26) });
        points.add(new Vector[] { new Vector(0.5, 0.42) });
        points.add(new Vector[] { new Vector(0.63, 0.26) });
        points.add(new Vector[] { new Vector(0.88, 0.26) });
        points.add(new Vector[] { new Vector(0.99, 0.37), new Vector(0.88, 0.26), new Vector(0.99, 0.3) });
        points.add(new Vector[] { new Vector(0.83, 0.51), new Vector(0.99, 0.44), new Vector(0.86, 0.51) });
        points.add(new Vector[] { new Vector(0.64, 0.51) });
        points.add(new Vector[] { new Vector(0.68, 0.34) });
        points.add(new Vector[] { new Vector(0.77, 0.34) });
        points.add(new Vector[] { new Vector(0.75, 0.45) });
        points.add(new Vector[] { new Vector(0.81, 0.45) });
        points.add(new Vector[] { new Vector(0.81, 0.45) });
        points.add(new Vector[] { new Vector(0.89, 0.37), new Vector(0.81, 0.45), new Vector(0.89, 0.44) });
        points.add(new Vector[] { new Vector(0.83, 0.32), new Vector(0.89, 0.33), new Vector(0.83, 0.32) });
        points.add(new Vector[] { new Vector(0.69, 0.32) });
        points.add(new Vector[] { new Vector(0.47, 0.56) });
        points.add(new Vector[] { new Vector(0.37, 0.30), new Vector(0.47, 0.56), new Vector(0.38, 0.3) });
        points.add(new Vector[] { new Vector(0.39, 0.40), new Vector(0.37, 0.30), new Vector(0.39, 0.35) });
        points.add(new Vector[] { new Vector(0.20, 0.51), new Vector(0.39, 0.40), new Vector(0.31, 0.51) });
        points.add(new Vector[] { new Vector(0.20, 0.51), new Vector(0.39, 0.40), new Vector(0.31, 0.51) });
        points.add(new Vector[] { new Vector(0.04, 0.51) });
        points.add(new Vector[] { new Vector(0.08, 0.34) });
        points.add(new Vector[] { new Vector(0.17, 0.34) });
        points.add(new Vector[] { new Vector(0.15, 0.45) });
        points.add(new Vector[] { new Vector(0.21, 0.45) });
        points.add(new Vector[] { new Vector(0.29, 0.38), new Vector(0.21, 0.45), new Vector(0.29, 0.42) });
        points.add(new Vector[] { new Vector(0.23, 0.32), new Vector(0.29, 0.34), new Vector(0.25, 0.32) });
        points.add(new Vector[] { new Vector(0.08, 0.32) });

        for (int i = 0; i < points.size(); i++) {
            var pts = points.get(i);
            for (int j = 0; j < pts.length; j++) {
                pts[j] = pts[j].multiply(size);
            }
        }

        return new Curves(points, color);

    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        g2d.translate(position.getX(), position.getY());
        g2d.setColor(color);
        dvd.draw(g2d);
        g2d.setTransform(reset);
    }

    @Override
    public void setPosition(Vector vector) {
        position = vector;
    }

    @Override
    public Vector getPosition() {
        return position;
    }

    @Override
    public void animateStep(float delta) {
        position.add(velocity.multiply(delta));
        if (position.getX() < 0)
            velocity.setX(Math.abs(velocity.getX()));
        if (position.getX() + size > GUI_WIDTH)
            velocity.setX(-Math.abs(velocity.getX()));
        if (position.getY() < -50)
            velocity.setY(Math.abs(velocity.getY()));
        if (position.getY() + size * .5 > GUI_HEIGHT)
            velocity.setY(-Math.abs(velocity.getY()));
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public void setColor(Color color) {
        this.color = color;
        dvd.setColor(color);
    }
}
