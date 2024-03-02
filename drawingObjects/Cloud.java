package drawingObjects;

import java.awt.*;
import java.awt.geom.*;

import customData.Vector;

public class Cloud implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color color;

    public Cloud(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
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
        // none
    }
}
