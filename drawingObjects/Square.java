package drawingObjects;

import java.awt.*;
import java.awt.geom.*;

import customData.Vector;

public class Square implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color color;
    private double angle;

    public Square(double x, double y, double angle, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.angle = angle;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        Rectangle2D.Double rect = new Rectangle2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.rotate(Math.toRadians(angle), x + size / 2, y + size / 2);
        g2d.fill(rect);

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