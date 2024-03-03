package scenes;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;

import drawingObjects.*;
import rain.Rain;
import customData.Vector;

public class Minecraft extends SceneCanvas {
    private ArrayList<Rain> raindrops;

    @Override
    protected ArrayList<DrawingObject> draw() {
        ArrayList<DrawingObject> objects = new ArrayList<DrawingObject>();
        objects.add(
                new RectangleBackground(0, 0, 800, 600, new Color(255, 218, 185), new Color(135, 206, 235), 800, -500,
                        0, 0));
        objects.add(new Rectangle(0, 500, 800, 173, new Color(97, 74, 42)));
        objects.add(new Sun(new Vector(680, 0), 120, 0));

        // Tree
        objects.addAll(tree(700, new Color(92, 169, 4)));
        objects.addAll(tree(200, new Color(0, 97, 14)));
        objects.addAll(tree(50, new Color(193, 209, 31)));
        raindrops = initRain();

        // Clouds
        objects.add(new Cloud(32, 40, 52, Color.WHITE, 10));
        objects.add(new Cloud(500, 70, 41, Color.WHITE, 5));
        objects.add(new Cloud(132, 100, 80, Color.WHITE, 9));
        objects.add(new Cloud(332, 50, 52, Color.WHITE, 3));
        objects.add(new Cloud(780, 90, 25, Color.WHITE, 15));
        objects.add(new Cloud(600, 30, 60, Color.WHITE, 13));

        // Flower1
        objects.addAll(flower1(700, Color.RED));
        objects.addAll(flower1(150, Color.BLUE));
        objects.addAll(flower1(600, Color.orange));

        // Flower2
        objects.addAll(flower2(400, new Color(65, 78, 31)));
        objects.addAll(flower2(375, new Color(255, 91, 165)));
        objects.addAll(flower2(250, new Color(213, 100, 124)));
        objects.addAll(flower2(50, new Color(65, 78, 31)));

        // Bush
        objects.addAll(bush(475, new Color(66, 117, 17)));
        objects.addAll(bush(30, new Color(150, 187, 92)));
        objects.addAll(bush(190, Color.ORANGE));

        // Grass Patch
        for (int i = 0; i <= 18; i++) {
            objects.addAll(grassPatch(i * 47));
        }

        return objects;
    }

    private ArrayList<DrawingObject> grassPatch(double x) {
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

    private ArrayList<DrawingObject> bush(double x, Color color) {
        ArrayList<DrawingObject> bushObjects = new ArrayList<DrawingObject>();
        bushObjects.add(new Cloud(x, 468, 30, color, 0));
        bushObjects.add(new Rectangle(x, 491, 30, 10, color));
        return bushObjects;
    }

    private ArrayList<DrawingObject> tree(double x, Color color) {
        ArrayList<DrawingObject> treeObjects = new ArrayList<DrawingObject>();
        treeObjects.add(new Rectangle(x - 5, 420.5, 37, 80, new Color(112, 101, 61)));
        treeObjects.add(new Rectangle(x, 435, 5, 38, Color.DARK_GRAY));
        treeObjects.add(new Rectangle(x + 20, 430, 5, 15, Color.DARK_GRAY));
        treeObjects.add(new Rectangle(x + 10, 445, 7, 8, Color.DARK_GRAY));
        treeObjects.add(new Rectangle(x + 20, 460, 5, 20, Color.DARK_GRAY));
        treeObjects.add(new Rectangle(x - 46.5, 385, 118, 38, color));
        treeObjects.add(new Rectangle(x - 10, 348, 47, 38, color));

        return treeObjects;
    }

    private ArrayList<DrawingObject> flower1(double x, Color color) {
        ArrayList<DrawingObject> flowerObjects = new ArrayList<DrawingObject>();
        flowerObjects.add(new Rectangle(x + 3, 472, 6, 30, new Color(48, 105, 75)));
        flowerObjects.add(new Square(x - 10.5, 449, 0, 24, color));
        flowerObjects.add(new Square(x, 449, 0, 24, color));
        flowerObjects.add(new Square(x - 5, 441, 0, 24, color));
        flowerObjects.add(new Circle(x + 2, 457, 8, Color.BLACK));

        return flowerObjects;
    }

    private ArrayList<DrawingObject> flower2(double x, Color color) {
        ArrayList<DrawingObject> flowerObjects = new ArrayList<DrawingObject>();
        flowerObjects.add(new Rectangle(x, 478, 5, 24, new Color(48, 105, 75)));
        flowerObjects.add(new Rectangle(x, 481, 11, 11, new Color(48, 105, 75)));
        flowerObjects.add(new Rectangle(x, 484, 15, 5, new Color(48, 105, 75)));

        flowerObjects.add(new Rectangle(x - 5.5, 462, 16, 11, color));
        flowerObjects.add(new Square(x - 1.5, 470, 0, 8, color));
        flowerObjects.add(new Square(x - 5.5, 456, 0, 6, color));
        flowerObjects.add(new Square(x + 4.5, 456, 0, 6, color));

        return flowerObjects;
    }

    private ArrayList<Rain> initRain() {
        ArrayList<Rain> raindrops = new ArrayList<>();
        for (int i = 0; i < 100; i++) { // Adjust number of raindrops as needed
            double x = Math.random() * 800; // Random x-coordinate
            double y = 0; // Random y-coordinate
            double velocity = Math.random() + 0.5; // Random velocity
            raindrops.add(new Rain(x, y, velocity));
        }
        return raindrops;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Rain raindrop : raindrops) {
            raindrop.makeItRain(g); // Call makeItRain with Graphics object
        }
    }
}
