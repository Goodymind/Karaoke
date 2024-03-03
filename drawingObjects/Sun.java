package drawingObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import customData.Vector;

public class Sun implements DrawingObject {
    private Vector position;
    private double size;
    private double angle;

    private Circle center;
    private Polygon rings;

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

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        g2d.translate(position.getX(), position.getY());
        g2d.rotate(Math.toRadians(angle), size / 2, size / 2);
        rings.draw(g2d);
        center.draw(g2d);
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
        angle += 10 * delta;
    }

}