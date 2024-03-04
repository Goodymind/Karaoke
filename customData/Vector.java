package customData;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Point2D;

public class Vector {

    public static final Vector LEFT = new Vector(-1, 0);
    public static final Vector RIGHT = new Vector(1, 0);
    public static final Vector UP = new Vector(0, -1);
    public static final Vector DOWN = new Vector(0, 1);

    double x;
    double y;

    public Vector() {
        x = y = 0;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double[] get() {
        return new double[] { x, y };
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void set() {
        x = y = 0;
    }

    public void set(double n) {
        x = y = n;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector add(Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
        return this;
    }

    public static Vector add(Vector a, Vector b) {
        return new Vector(a.getX() + b.getX(), a.getY() + b.getY());
    }

    public Vector subtract(Vector vector) {
        this.x += -vector.x;
        this.y += -vector.y;
        return this;
    }

    public static Vector subtract(Vector a, Vector b) {
        return new Vector(a.getX() - b.getX(), a.getY() - b.getY());
    }

    public Vector multiply(double n) {
        return new Vector(this.x * n, this.y * n);
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", x, y);
    }

    public Dimension toDimension() {
        return new Dimension((int) x, (int) y);
    }

    public static Dimension toDimension(Vector vector) {
        return new Dimension((int) vector.x, (int) vector.y);
    }

    public Point2D.Double toPoint2D() {
        return new Point2D.Double(x, y);
    }
    public static Vector lerp(Vector a, Vector b, float i) {
        return Vector.add(a, Vector.subtract(b, a).multiply(i));
    }
    public static Vector pointToVector(Point pt) {
        return new Vector(pt.getX(), pt.getY());
    }
}
