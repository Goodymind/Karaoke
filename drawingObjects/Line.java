package drawingObjects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import customData.Vector;

public class Line implements DrawingObject {

    private double startx;
    private double starty;
    private double endx;
    private double endy;
    private int thickness;
    private Color color;

    public Line(double startx, double starty, double endx, double endy, int thickness, Color color) {
        this.startx = startx;
        this.starty = starty;
        this.endx = endx;
        this.endy = endy;
        this.thickness = thickness;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        var reset = g2d.getTransform();
        Line2D.Double l = new Line2D.Double(startx, starty, endx, endy);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.draw(l);
        g2d.setTransform(reset);
    }

    @Override
    public void setPosition(Vector vector) {
        startx += vector.getX();
        starty += vector.getY();
        endx += vector.getX();
        endy += vector.getY();
    }

    @Override
    public Vector getPosition() {
        return new Vector(startx, starty);
    }
}
