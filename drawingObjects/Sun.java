/**
    This class implements both the DrawingObject and AnimatedObject 
    interfaces to enable the drawing and animation of the Sun. By 
    utilizing an ArrayList of Vectors (a custom data type), the Sun 
    becomes more detailed, as its rays are outlined using the Vectors.

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

public class Sun implements DrawingObject, AnimatedObject {
    private Vector position;
    private double size;
    private double angle;

    private Circle center;
    private Polygon rings;

    /**
     * Constructor for creating a Sun object with specified parameters.
     * This method allows for customization and uniqueness among instances of the
     * object.
     * 
     * @param position The position vector of the Sun.
     * @param size     The size of the Sun.
     * @param angle    The angle of rotation of the Sun.
     */
    public Sun(Vector position, double size, double angle) {
        this.position = position;
        this.size = size;
        this.angle = angle;

        center = new Circle(size * 0.2, size * 0.2, size * 0.6, new Color(250, 255, 97));

        ArrayList<Vector> ringPoints = new ArrayList<Vector>();
        ringPoints.add(new Vector(0.5, 0));
        ringPoints.add(new Vector(0.6, 0.1));
        ringPoints.add(new Vector(0.7, 0.1));
        ringPoints.add(new Vector(0.7, 0.2));
        ringPoints.add(new Vector(0.8, 0.2));
        ringPoints.add(new Vector(0.8, 0.3));
        ringPoints.add(new Vector(0.9, 0.3));
        ringPoints.add(new Vector(0.9, 0.4));
        ringPoints.add(new Vector(1, 0.5));
        ringPoints.add(new Vector(0.9, 0.6));
        ringPoints.add(new Vector(0.9, 0.7));
        ringPoints.add(new Vector(0.8, 0.7));
        ringPoints.add(new Vector(0.8, 0.8));
        ringPoints.add(new Vector(0.7, 0.8));
        ringPoints.add(new Vector(0.7, 0.9));
        ringPoints.add(new Vector(0.6, 0.9));
        ringPoints.add(new Vector(0.5, 1));
        ringPoints.add(new Vector(0.4, 0.9));
        ringPoints.add(new Vector(0.3, 0.9));
        ringPoints.add(new Vector(0.3, 0.8));
        ringPoints.add(new Vector(0.2, 0.8));
        ringPoints.add(new Vector(0.2, 0.7));
        ringPoints.add(new Vector(0.1, 0.7));
        ringPoints.add(new Vector(0.1, 0.6));
        ringPoints.add(new Vector(0, 0.5));
        ringPoints.add(new Vector(0.1, 0.4));
        ringPoints.add(new Vector(0.1, 0.3));
        ringPoints.add(new Vector(0.2, 0.3));
        ringPoints.add(new Vector(0.2, 0.2));
        ringPoints.add(new Vector(0.3, 0.2));
        ringPoints.add(new Vector(0.3, 0.1));
        ringPoints.add(new Vector(0.4, 0.1));

        for (int i = 0; i < ringPoints.size(); i++) {
            ringPoints.set(i, ringPoints.get(i).multiply(size));
        }
        rings = new Polygon(ringPoints, new Color(255, 188, 60));

    }

    /**
     * This method draws the Sun object using the graphics2D.
     * This method translates and rotates the Sun based on the angle,
     * then draws the rings and center of the Sun. It finally resets
     * the transform to its original state.
     * 
     * @param g2d graphics2D.
     */
    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        g2d.translate(position.getX(), position.getY());
        g2d.rotate(Math.toRadians(angle), size / 2, size / 2);
        rings.draw(g2d);
        center.draw(g2d);
        g2d.setTransform(reset);
    }

    /**
     * A setter method; sets the position of the Sun. This method
     * updates the position of the Sun to the specified vector.
     * 
     * @param vector The position vector to set new position.
     */
    @Override
    public void setPosition(Vector vector) {
        position = vector;
    }

    /**
     * A getter method; Gets the position of the Sun. This method
     * retrieves the current position vector of the Sun.
     * 
     * @return The position vector of the Sun (coordinates).
     */
    @Override
    public Vector getPosition() {
        return position;
    }

    /**
     * Animates the Sun by updating its angle based on the delta time.
     * This method incrementally updates the angle of rotation of the
     * Sun to create an animation effect, where the Sun appears
     * to be rotating.
     * 
     * @param delta The time(in seconds) difference between animation steps.
     */
    @Override
    public void animateStep(float delta) {
        angle += 10 * delta;
    }
}