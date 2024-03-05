/**
    The Vector class provides a way to simplify the management of coordinates, 
    inspired by the Godot Game Engine's Vector system, aiming to replicate its 
    usability. Java's Vector class implements a growing array of objects, while 
    instances of this Vector class holding an abscissa and ordinate, and providing 
    a list of features to simplify common operations on vectors.

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

package customData;

import java.awt.Dimension;
import java.awt.Point;

public final class Vector {

    public static final Vector LEFT = new Vector(-1, 0);
    public static final Vector RIGHT = new Vector(1, 0);
    public static final Vector UP = new Vector(0, -1);
    public static final Vector DOWN = new Vector(0, 1);

    double x;
    double y;

    /**
     * Constructs a Vector with values set to ZERO.
     */
    public Vector() {
        x = y = 0;
    }

    /**
     * Constructs a Vector with set values.
     * 
     * @param x x-coordinate of the Vector.
     * @param y y-coordinate of the Vector.
     */
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of the Vector.
     * 
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the Vector.
     * 
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the x-coordinate of the Vector to the value.
     * 
     * @param x the new x-coordinate of the Vector.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of the Vector to the value.
     * 
     * @param y the new y-coordinate of the Vector.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Adds a Vector to the current vector. MUTATES THE CURRENT VECTOR!
     * 
     * @param vector the vector to be added to the current vector.
     */
    public Vector add(Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
        return this;
    }

    /**
     * Member method that adds two vectors together and returns their sum.
     * 
     * @param a the first vector.
     * @param b the second vector.
     * @return the sum of the two vectors.
     */
    public static Vector add(Vector a, Vector b) {
        return new Vector(a.getX() + b.getX(), a.getY() + b.getY());
    }

    /**
     * Subtracts a vector from the current vector. MUTATES THE CURRENT VECTOR!
     * 
     * @param vector the amount vector to be subtracted
     * @return the now subtracted vector.
     */
    public Vector subtract(Vector vector) {
        this.x += -vector.x;
        this.y += -vector.y;
        return this;
    }

    /**
     * Vector Member method that subtracts a vector from another: a - b
     * 
     * @param a minuend.
     * @param b subtrahend.
     * @return difference
     */
    public static Vector subtract(Vector a, Vector b) {
        return new Vector(a.getX() - b.getX(), a.getY() - b.getY());
    }

    /**
     * Multiplies the vector by a number n
     * 
     * @param n the number to multiply the vector by.
     * @return a new Vector.
     */
    public Vector multiply(double n) {
        return new Vector(this.x * n, this.y * n);
    }

    /**
     * Class Member method that casts the Vector into a Dimension type
     * 
     * @param vector Vector to cast into Dimension type
     * @return dimension object from vector.
     */
    public static Dimension toDimension(Vector vector) {
        return new Dimension((int) vector.x, (int) vector.y);
    }

    /**
     * Applies Linear Interpolation between two vectors.
     * 
     * @param a start vector
     * @param b end vector
     * @param i the percentage of the location of the point when a = 0% and b =
     *          100%;
     */
    public static Vector lerp(Vector a, Vector b, float i) {
        return Vector.add(a, Vector.subtract(b, a).multiply(i));
    }

    /**
     * Converts a Point object into a Vector object;
     * 
     * @param pt the point object
     * @return the new vector.
     */
    public static Vector pointToVector(Point pt) {
        return new Vector(pt.getX(), pt.getY());
    }

}
