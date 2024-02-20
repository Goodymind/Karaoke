import java.awt.Color;
import java.awt.Graphics2D;

import customData.Vector;

public class Line implements DrawingObject {

    private double startx;
    private double starty;
    private double endx;
    private double endy;
    private double thickness;
    private Color[] colors;

    public Line(double startx, double starty, double endx, double endy, double thickness, Color[] colors) {
        this.startx = startx;
        this.starty = starty;
        this.endx = endx;
        this.endy = endy;
        this.thickness = thickness;
        this.colors = colors;
    }

    @Override
    public void draw(Graphics2D g2d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    @Override
    public void setPosition(Vector vector) {
        this.startx = vector.getX();
        this.starty = vector.getY();
        throw new UnsupportedOperationException("Unimplemented method 'setPosition'");
    }

    @Override
    public Vector getPosition() {
        return new Vector(startx, starty);
    }

}
