package drawingObjects;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import customData.Vector;

public class Rectangle implements DrawingObject {

    protected double x;
    protected double y;
    protected double width;
    protected double height;
    protected Color color;

    public Rectangle(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Rectangle2D.Double rect = new Rectangle2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.fill(rect);
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
