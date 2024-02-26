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

    @Override
    public void animateStep(float delta) {
        //none
    }
}