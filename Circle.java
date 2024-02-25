import java.awt.Color;
import java.awt.Graphics2D;
import customData.Vector;

public class Circle implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color color;

    @Override
    public Circle(double x, double y, double size, double size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void draw(Graphics2D g2d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    @Override
    public void setPosition(Vector vector) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPosition'");
    }

    @Override
    public Vector getPosition() {
        return new Vector(x, y);
    }

    @Override
    public void animateStep(float delta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'animateStep'");
    }

}