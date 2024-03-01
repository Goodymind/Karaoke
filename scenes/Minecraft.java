package scenes;

import java.awt.Color;
import java.util.ArrayList;

import drawingObjects.*;
import customData.Vector;

public class Minecraft extends SceneCanvas {

    @Override
    protected ArrayList<DrawingObject> draw() {
        ArrayList<DrawingObject> objects = new ArrayList<DrawingObject>();
        Sun sun = new Sun(new Vector(620, 20), 120, 0);

        objects.add(new Rectangle(0, 0, 8000, 600, Color.CYAN));
        objects.add(new Rectangle(-800, 500, 2400, 173, new Color(97, 74, 42)));
        objects.add(sun);

        // Grass Patch
        for (int i = 0; i <= 18; i++) {
            objects.addAll(grassPatch(i * 47));
        }

        // Flower(yung red)
        objects.add(new Rectangle(83, 472, 6, 30, new Color(150, 187, 92)));
        objects.add(new Square(70, 449, 0, 24, new Color(148, 5, 5)));
        objects.add(new Square(80, 449, 0, 24, new Color(148, 5, 5)));
        objects.add(new Square(75, 441, 0, 24, new Color(148, 5, 5)));
        objects.add(new Circle(82, 457, 8, Color.BLACK));

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

    private ArrayList<DrawingObject> grassPatch(int x) {
        ArrayList<DrawingObject> grassObjects = new ArrayList<DrawingObject>();

        grassObjects.add(new Rectangle(x + 47, 500, 8, 30, new Color(150, 187, 92)));
        grassObjects.add(new Rectangle(x + 41, 500, 7, 25, new Color(150, 187, 92)));
        grassObjects.add(new Rectangle(x + 26, 500, 16, 16, new Color(150, 187, 92)));
        grassObjects.add(new Rectangle(x + 18, 500, 9, 11, new Color(150, 187, 92)));
        grassObjects.add(new Rectangle(x + 11, 500, 8, 23, new Color(150, 187, 92)));
        grassObjects.add(new Rectangle(x + 4, 500, 8, 15, new Color(150, 187, 92)));
        grassObjects.add(new Rectangle(x, 500, 6, 27, new Color(150, 187, 92)));
        return grassObjects;
    }

}
