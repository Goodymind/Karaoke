package scenes;
import java.awt.Color;
import java.util.ArrayList;

import drawingObjects.Circle;
import drawingObjects.DrawingObject;
import drawingObjects.Line;
import drawingObjects.Square;

public class Test extends SceneCanvas{
    @Override
    protected ArrayList<DrawingObject> draw() {
        ArrayList<DrawingObject> objects = new ArrayList<DrawingObject>();
        objects.add(new Line(10, 10, 300, 100, 5, getBackground()));
        objects.add(new Square(20, 20, 10, 45, Color.RED));
        objects.add(new Square(100, 100, 45, 100, Color.BLUE));
        objects.add(new Circle(75, 75, 50, Color.YELLOW));
        return objects;
    }    
}
