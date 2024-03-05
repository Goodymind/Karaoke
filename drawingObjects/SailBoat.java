/**
    This class implements both the DrawingObject and AnimatedObject interfaces 
    to enable the drawing and animation of a sailboat. By utilizing curves and 
    lines, it creates the boat's base, pole base, pole, sail, and rope.

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
import java.util.ArrayList;

import customData.Vector;

public class SailBoat implements DrawingObject, AnimatedObject {

    private Vector position;
    private float size;
    private float speed;
    private Curves base;
    private Curves poleBase;
    private Curves pole;
    private Curves sail;
    private Line rope;
    private Color color;
    private static final int GUI_WIDTH = 800;

    /**
     * This class represents a sailboat by implementing both the DrawingObject and
     * AnimatedObject interfaces, enabling its rendering and animation.
     * Utilizing curves and lines, it constructs the sailboat's base, pole base,
     * pole, sail, and rope, enhancing the detail.
     * 
     * @param position The position vector representing the initial location of
     *                 the sailboat.
     * @param size     The size of the sailboat, influencing the dimensions of its
     *                 components.
     * @param speed    The speed at which the sailboat moves horizontally across the
     *                 screen.
     * @param color    The color of the sailboat's Pole Base, determining its visual
     *                 appearance.
     */
    public SailBoat(Vector position, float size, float speed, Color color) {
        this.position = position;
        this.size = size;
        this.speed = speed;
        this.color = color;
        base = setupBase();
        poleBase = setupPoleBase();
        pole = setupPole();
        sail = setupSail();
        rope = setupRope();
    }

    /**
     * This method sets up the base of the sailboat, creating a series of points
     * defining its shape and size. It utilizes curves to generate the base
     * structure of the sailboat.
     */
    private Curves setupBase() {
        ArrayList<Vector[]> basePoints = new ArrayList<Vector[]>();
        basePoints.add(new Vector[] { new Vector(0, 0.8) });
        basePoints.add(new Vector[] { new Vector(1, 0.8) });
        basePoints.add(new Vector[] { new Vector(0.95, 1), new Vector(1, 0.8), new Vector(1, 0.9) });
        basePoints.add(new Vector[] { new Vector(0.05, 1) });
        basePoints.add(new Vector[] { new Vector(0, 0.8), new Vector(0, 0.9), new Vector(0, 0.8) });
        for (int i = 0; i < basePoints.size(); i++) {
            var points = basePoints.get(i);
            for (int j = 0; j < points.length; j++) {
                points[j] = points[j].multiply(size);
            }
        }
        return new Curves(basePoints, new Color(139, 69, 19));
    }

    /**
     * Initializes the pole base of the sailboat by defining a sequence of points
     * representing its outline. By utilizing curves, it constructs the pole base
     * with great dimensions and curvature.
     */
    private Curves setupPoleBase() {
        ArrayList<Vector[]> points = new ArrayList<Vector[]>();
        points.add(new Vector[] { new Vector(0.2, 0.8) });
        points.add(new Vector[] { new Vector(0.5, 0.7), new Vector(0.2, 0.8), new Vector(0.4, 0.7) });
        points.add(new Vector[] { new Vector(0.8, 0.8), new Vector(0.6, 0.7), new Vector(0.8, 0.8) });
        for (int i = 0; i < points.size(); i++) {
            var pts = points.get(i);
            for (int j = 0; j < pts.length; j++) {
                pts[j] = pts[j].multiply(size);
            }
        }
        return new Curves(points, color);
    }

    /**
     * Sets up the pole of the sailboat, establishing its shape and size through a
     * set of coordinate points. Utilizing curves, it creates the pole with
     * appropriate dimensions and curvature.
     */
    private Curves setupPole() {
        ArrayList<Vector[]> points = new ArrayList<Vector[]>();
        points.add(new Vector[] { new Vector(0.5, 0.1) });
        points.add(new Vector[] { new Vector(0.5, 0.8) });
        points.add(new Vector[] { new Vector(0.4, 0.2), new Vector(0.5, 0.8), new Vector(0.4, 0.3) });
        points.add(new Vector[] { new Vector(0.5, 0.1), new Vector(0.4, 0.1), new Vector(0.5, 0.1) });
        for (int i = 0; i < points.size(); i++) {
            var pts = points.get(i);
            for (int j = 0; j < pts.length; j++) {
                pts[j] = pts[j].multiply(size);
            }
        }
        return new Curves(points, new Color(160, 82, 45));
    }

    /**
     * Initializes the sail of the sailboat by defining a series of points outlining
     * its shape and dimensions. Using curves, it constructs the sail with accurate
     * proportions and curvature, contributing to the sailboat's realistic
     * representation within the scene.
     */
    private Curves setupSail() {
        ArrayList<Vector[]> points = new ArrayList<Vector[]>();
        points.add(new Vector[] { new Vector(0.5, 0.1) });
        points.add(new Vector[] { new Vector(0.9, 0.7), new Vector(0.5, 0.1), new Vector(0.9, 0.6) });
        points.add(new Vector[] { new Vector(0.5, 0.7), new Vector(0.9, 0.8), new Vector(0.5, 0.7) });
        for (int i = 0; i < points.size(); i++) {
            var pts = points.get(i);
            for (int j = 0; j < pts.length; j++) {
                pts[j] = pts[j].multiply(size);
            }
        }
        return new Curves(points, new Color(255, 218, 185));
    }

    /**
     * Sets up the rope connecting the sail to the sailboat, defining its starting
     * and ending points. Utilizing a line segment, it creates the rope with
     * specified thickness and color, enhancing the visual cohesion of the
     * sailboat's components.
     */
    private Line setupRope() {
        Vector start = new Vector(0.5, 0.1).multiply(size);
        Vector end = new Vector(0, 0.8).multiply(size);
        return new Line(start.getX(), start.getY(), end.getX(), end.getY(), 1, new Color(104, 82, 63));
    }

    /**
     * Draws the sailboat onto the graphics context using the provided 2D graphics
     * object, ensuring accurate positioning and appearance within the scene.
     * It translates the graphics context to the sailboat's position and renders
     * each component, including the base, pole, sail, and rope, with their
     * respective colors and shapes.
     * 
     * @param g2d The 2D graphics object used for rendering the sailboat onto the
     *            graphical scene.
     */
    @Override
    public void draw(Graphics2D g2d) {
        var reset = g2d.getTransform();
        g2d.translate(position.getX(), position.getY());
        g2d.setColor(Color.BLACK);
        base.draw(g2d);
        sail.draw(g2d);
        pole.draw(g2d);
        poleBase.draw(g2d);
        rope.draw(g2d);
        g2d.setTransform(reset);
    }

    /**
     * Updates the position of the sailboat based on the provided vector,
     * facilitating dynamic movement and animation within the graphical environment.
     * This method sets the sailboat's position to the coordinates specified in the
     * vector, allowing seamless integration with other animated objects.
     *
     * @param vector The vector containing the new position coordinates for the
     *               sailboat.
     */
    @Override
    public void setPosition(Vector vector) {
        this.position = vector;
    }

    /**
     * Retrieves the current position of the sailboat as a vector, enabling external
     * components to access and manipulate its location.
     * It returns a vector containing the x and y coordinates of the sailboat's
     * position, providing essential information for interactive scenarios and scene
     * management.
     *
     * @return A vector representing the current position of the sailboat within the
     *         graphical environment.
     */
    @Override
    public Vector getPosition() {
        return position;
    }

    /**
     * Moves the sailboat horizontally based on the elapsed time (delta). If the
     * sailboat
     * reaches the screen boundaries, it changes direction to keep it within bounds.
     * 
     * @param delta Elapsed time since the last animation step.
     */
    @Override
    public void animateStep(float delta) {
        position.add(Vector.RIGHT.multiply(speed * delta));
        if (position.getX() + size > GUI_WIDTH)
            speed = -Math.abs(speed);
        if (position.getX() < 0)
            speed = Math.abs(speed);
    }
}