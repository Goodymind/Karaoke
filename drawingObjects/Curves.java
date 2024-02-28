package drawingObjects;

import java.awt.Graphics2D;
import java.util.ArrayList;
import customData.Vector;

public class Curves implements DrawingObject {

    private ArrayList<Vector[]> points;

    /**
     * Accepts an arraylist of arrays of vectors with size 3,
     * with the first array being the starting point,
     * and the subsequent arrays consisting of:
     *  the next point,
     *  the bezier point of the previous point,
     *  the bezier poitn of the end point
     * @param points
     */
    public Curves(ArrayList<Vector[]> points) {
        this.points = points;
    }

    @Override
    public void draw(Graphics2D g2d) {
        // TODO use path2D to generate a curved shape
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

    @Override
    public void animateStep(float delta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'animateStep'");
    }
    
}
