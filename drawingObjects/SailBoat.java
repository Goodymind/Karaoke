package drawingObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import customData.Vector;

public class SailBoat implements DrawingObject{

    private Vector position;
    private float size;
    private float speed;
    private Curves base;
    private Curves poleBase;
    private Curves pole;
    private Curves sail;
    private Line rope;

    public SailBoat(Vector position, float size, float speed) {
        this.position = position;
        this.size = size;
        this.speed = speed;
        base = setupBase(); 
        poleBase = setupPoleBase();   
        pole = setupPole();
        sail = setupSail();
        rope = setupRope();
    }

    private Curves setupBase() {
        ArrayList<Vector[]> basePoints = new ArrayList<Vector[]>();
        basePoints.add(new Vector[] {new Vector(0, 0.8)});
        basePoints.add(new Vector[] {new Vector(1, 0.8)});
        basePoints.add(new Vector[] {new Vector(0.95, 1), new Vector(1, 0.8), new Vector(1, 0.9)});
        basePoints.add(new Vector[] {new Vector(0.05, 1)});
        basePoints.add(new Vector[] {new Vector(0, 0.8), new Vector(0, 0.9), new Vector(0, 0.8)});
        for (int i = 0; i < basePoints.size(); i++) {
            var points = basePoints.get(i);
            for (int j = 0; j < points.length; j++) {
                points[j] = points[j].multiply(size);
            }
        }
        return new Curves(basePoints, new Color(40, 84, 8));
    }

    private Curves setupPoleBase() {
        ArrayList<Vector[]> points = new ArrayList<Vector[]>();
        points.add(new Vector[] {new Vector(0.2, 0.8)});
        points.add(new Vector[] {new Vector(0.5, 0.7), new Vector(0.2, 0.8), new Vector(0.4, 0.7)});
        points.add(new Vector[] {new Vector(0.8, 0.8), new Vector(0.6, 0.7), new Vector(0.8, 0.8)});
        for (int i = 0; i < points.size(); i++) {
            var pts = points.get(i);
            for (int j = 0; j < pts.length; j++) {
                pts[j] = pts[j].multiply(size);
            }
        }
        return new Curves(points, new Color(7, 185, 0));
    }

    private Curves setupPole() {
        ArrayList<Vector[]> points = new ArrayList<Vector[]>();
        points.add(new Vector[] {new Vector(0.5, 0.1)});
        points.add(new Vector[] {new Vector(0.5, 0.8)});
        points.add(new Vector[] {new Vector(0.4, 0.2), new Vector(0.5, 0.8), new Vector(0.4, 0.3)});
        points.add(new Vector[] {new Vector(0.5, 0.1), new Vector(0.4, 0.1), new Vector(0.5, 0.1)});
        for (int i = 0; i < points.size(); i++) {
            var pts = points.get(i);
            for (int j = 0; j < pts.length; j++) {
                pts[j] = pts[j].multiply(size);
            }
        }
        return new Curves(points, new Color(82, 46, 0));
    }
    
    private Curves setupSail() {
        ArrayList<Vector[]> points = new ArrayList<Vector[]>();
        points.add(new Vector[] {new Vector(0.5, 0.1)});
        points.add(new Vector[] {new Vector(0.9, 0.7), new Vector(0.5, 0.1), new Vector(0.9, 0.6)});
        points.add(new Vector[] {new Vector(0.5, 0.7), new Vector(0.9, 0.8), new Vector(0.5, 0.7)});
        for (int i = 0; i < points.size(); i++) {
            var pts = points.get(i);
            for (int j = 0; j < pts.length; j++) {
                pts[j] = pts[j].multiply(size);
            }
        }
        return new Curves(points, new Color(255, 227, 218));
    }

    private Line setupRope() {
        Vector start = new Vector(0.5, 0.1).multiply(size);
        Vector end = new Vector(0, 0.8).multiply(size);
        return new Line(start.getX(), start.getY(), end.getX(), end.getY(), 1, Color.BLACK);
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
    }
}
