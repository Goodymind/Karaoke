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
    

    @Override
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPosition'");
    }
    
}
