package drawingObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;

import customData.Vector;
public class Polygon implements DrawingObject{

    private ArrayList<Vector> points;
    private Color color;

    public Polygon(ArrayList<Vector> points, Color color) {
        this.points = points;
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        var p = new Path2D.Double();
        if (points.size() <= 1) return;
        Vector start = points.get(0);
        p.moveTo(start.getX(), start.getY());
        for (int i = 1; i < points.size(); i++) {
            Vector point = points.get(i);
            p.lineTo(point.getX(), point.getY());
        }
        p.closePath();
        g2d.setColor(color);
        g2d.fill(p);
    }

    @Override
    public void setPosition(Vector vector) {
        for (int i = 0; i < points.size(); i++) {
            Vector translated = points.get(i).add(vector);
            points.set(i, translated);
        }
    }

    @Override
    public Vector getPosition() {
        return points.get(0);
    }

    @Override
    public void animateStep(float delta) {
        // NONE
    }
    
}
