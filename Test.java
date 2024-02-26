import java.awt.Color;
import java.util.ArrayList;

public class Test extends SceneCanvas{
    protected ArrayList<DrawingObject> draw() {
        ArrayList<DrawingObject> objects = new ArrayList<DrawingObject>();
        objects.add(new Square(20, 20, 10, 45, Color.RED));
        objects.add(new Square(100, 100, 45, 100, Color.BLUE));
        objects.add(new Circle(75, 75, 50, Color.YELLOW));
        return objects;
    }    
}
