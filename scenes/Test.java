package scenes;

import java.awt.Color;
import java.util.ArrayList;

import drawingObjects.*;

public class Test extends SceneCanvas {
    @Override
    protected ArrayList<DrawingObject> draw() {
        ArrayList<DrawingObject> objects = new ArrayList<DrawingObject>();
        objects.add(new Rectangle(0, 500, 800, 173, new Color(97, 74, 42)));

        // Grass Patch
        objects.add(new Rectangle(105, 500, 8, 30, new Color(150, 187, 92)));
        objects.add(new Rectangle(98, 500, 7, 25, new Color(150, 187, 92)));
        objects.add(new Rectangle(83, 500, 16, 16, new Color(150, 187, 92)));
        objects.add(new Rectangle(75, 500, 9, 11, new Color(150, 187, 92)));
        objects.add(new Rectangle(68, 500, 8, 23, new Color(150, 187, 92)));
        objects.add(new Rectangle(61, 500, 8, 15, new Color(150, 187, 92)));
        objects.add(new Rectangle(57, 500, 6, 27, new Color(150, 187, 92)));

        // Flower(yung red)
        objects.add(new Rectangle(83, 472, 6, 30, new Color(150, 187, 92)));
        objects.add(new Square(70, 449, 0, 24, new Color(148, 5, 5)));
        objects.add(new Square(80, 449, 0, 24, new Color(148, 5, 5)));
        objects.add(new Square(75, 441, 0, 24, new Color(148, 5, 5)));
        objects.add(new Square(82, 457, 0, 8, Color.BLACK));

        // Tree
        objects.add(new Rectangle(145, 420.5, 37, 80, new Color(112, 101, 61)));
        objects.add(new Rectangle(150, 435, 5, 38, Color.DARK_GRAY));
        objects.add(new Rectangle(170, 430, 5, 15, Color.DARK_GRAY));
        objects.add(new Rectangle(160, 445, 7, 8, Color.DARK_GRAY));
        objects.add(new Rectangle(170, 460, 5, 20, Color.DARK_GRAY));
        objects.add(new Rectangle(104.5, 385, 118, 38, new Color(66, 117, 17)));
        objects.add(new Rectangle(140, 348, 47, 38, new Color(66, 117, 17)));

        // Bush

        objects.add(new Rectangle(210, 461, 80, 40, new Color(66, 117, 17)));
        objects.add(new Rectangle(232.5, 429, 35, 34, new Color(66, 117, 17)));
        return objects;
    }
}
