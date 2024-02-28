package scenes;

import java.awt.Color;
import java.util.ArrayList;
import drawingObjects.DrawingObject;
import drawingObjects.Polygon;
import customData.Vector;

public class Beach extends SceneCanvas {
    
    private Polygon sand;

    @Override
    protected ArrayList<DrawingObject> draw() {
        ArrayList<DrawingObject> objects = new ArrayList<DrawingObject>();
        sand = initSand();
        objects.add(sand);
        return objects;
    }

    private Polygon initSand() {
        var points = new ArrayList<Vector>();
        points.add(new Vector(0, 300));
        points.add(new Vector(800, 300));
        points.add(new Vector(800, 600));
        points.add(new Vector(0, 600));
        return new Polygon(points, new Color(249, 220, 182));
    }
}
