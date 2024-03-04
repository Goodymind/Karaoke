package scenes;

import java.awt.Color;
import java.util.ArrayList;
import customData.Vector;
import drawingObjects.DVD;
import drawingObjects.DrawingObject;

public class DVDScreen extends SceneCanvas {
    @Override
    protected ArrayList<DrawingObject> draw() {
        ArrayList<DrawingObject> obj = new ArrayList<DrawingObject>();
        obj.add(new DVD(new Vector(100, 100), 200f, Color.RED));        
        return obj;
    }
}
