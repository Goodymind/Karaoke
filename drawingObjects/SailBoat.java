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

    private Line setupRope() {
        Vector start = new Vector(0.5, 0.1).multiply(size);
        Vector end = new Vector(0, 0.8).multiply(size);
        return new Line(start.getX(), start.getY(), end.getX(), end.getY(), 1, new Color(104, 82, 63));
    }

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

    @Override
    public void setPosition(Vector vector) {
        this.position = vector;
    }

    @Override
    public Vector getPosition() {
        return position;
    }

    @Override
    public void animateStep(float delta) {
        position.add(Vector.RIGHT.multiply(speed * delta));
        if (position.getX() + size > GUI_WIDTH)
            speed = -Math.abs(speed);
        if (position.getX() < 0)
            speed = Math.abs(speed);
    }
}
