package drawingObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import customData.Vector;

public class Curves implements DrawingObject {

    private ArrayList<Vector[]> points;
    private Color color;

    /**
     * Accepts an arraylist of arrays of vectors with size 3,
     * with the first array being the starting point,
     * and the subsequent arrays consisting of:
     *  the next point,
     *  the bezier point of the previous point,
     *  the bezier point of the end point
     * @param points
     */
    public Curves(ArrayList<Vector[]> points, Color color) {
        this.points = points;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Path2D.Double p = new Path2D.Double();
        Vector start = points.get(0)[0];
        p.moveTo(start.getX(), start.getY());
        for (int i = 1; i < points.size(); i++) {
            Vector nextpoint = points.get(i)[0];
            if (points.get(i).length == 1) {
                p.lineTo(nextpoint.getX(), nextpoint.getY());
                continue;
            }
            Vector startB = points.get(i)[1];
            Vector endB = points.get(i)[2];
            p.curveTo(startB.getX(), startB.getY(),
                    endB.getX(), endB.getY(),
                    nextpoint.getX(), nextpoint.getY());
        }
        p.closePath();
        g2d.setColor(color);
        g2d.fill(p);
    }

    @Override
    public void setPosition(Vector vector) {
        var start = getPosition();
        if (start == null)
            return;
        var diff = start.subtract(vector);
        for (int i = 0; i < points.size(); i++) {
            var curvePoints = points.get(i);
            for (int j = 0; j < 3; j++) {
                curvePoints[j].add(diff);
            }
        }
    }

    @Override
    public Vector getPosition() {
        if (points.size() < 1)
            return null;
        return points.get(0)[0];
    }

    @Override
    public void animateStep(float delta) {
        // TODO Auto-generated method stub
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
