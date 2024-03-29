/**
    This class utilizes ArrayLists to display the shapes for the scenery. 
    Inspired by Minecraft, it employs composite shapes and features 
    the Rain effect.

    @author Alinus Abuke (230073)	
    @author Neil Aldous Biason (230940)
    @version 06 March 2024

    We have not discussed the Java language code in our program 
    with anyone other than our instructor or the teaching assistants 
    assigned to this course.

    We have not used Java language code obtained from another student, 
    or any other unauthorized source, either modified or unmodified.

    If any Java language code or documentation used in our program 
    was obtained from another source, such as a textbook or website, 
    that has been clearly noted with a proper citation in the comments 
    of our program.
**/

package scenes;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;

import drawingObjects.*;
import customData.Vector;

public class Minecraft extends SceneCanvas {
    private ArrayList<Rain> raindrops;

    /**
     * Initializes the drawing objects and creates the scene for the Minecraft
     * environment(Nature Scenery). This method creates various drawing objects such
     * as background, sun, clouds, trees, flowers, bushes, and grass patches to
     * construct the Minecraft scene.
     * 
     * @return The list of drawing objects.
     */

    @Override
    protected ArrayList<DrawingObject> draw() {
        ArrayList<DrawingObject> objects = new ArrayList<DrawingObject>();
        raindrops = initRain();
        objects.add(new RectangleBackground(0, 0, 800, 600, new Color(255, 218, 185), new Color(135, 206, 235), 750,
                -500, 0, 0));
        objects.add(new Rectangle(0, 501, 800, 173, new Color(97, 74, 42)));
        objects.add(new Sun(new Vector(680, 0), 120, 0));

        // Tree
        objects.addAll(tree(700, new Color(92, 169, 4)));
        objects.addAll(tree(200, new Color(0, 97, 14)));
        objects.addAll(tree(50, new Color(193, 209, 31)));

        // Clouds
        objects.add(new Cloud(32, 20, 52, Color.WHITE, 10));
        objects.add(new Cloud(190, 70, 41, new Color(255, 253, 208), 12));
        objects.add(new Cloud(750, 90, 80, Color.lightGray, 9));
        objects.add(new Cloud(332, 50, 52, new Color(93, 173, 222), 9));
        objects.add(new Cloud(500, 90, 25, new Color(255, 219, 88), 15));
        objects.add(new Cloud(600, 30, 60, new Color(128, 144, 160), 13));
        objects.add(new Cloud(300, 100, 60, new Color(255, 218, 185), 8));
        objects.add(new Cloud(700, 20, 60, new Color(251, 206, 177), 15));

        // Flower1
        objects.addAll(flower1(700, Color.RED));
        objects.addAll(flower1(150, Color.BLUE));
        objects.addAll(flower1(600, Color.orange));

        // Flower2
        objects.addAll(flower2(400, new Color(148, 0, 211)));
        objects.addAll(flower2(375, new Color(0, 191, 255)));
        objects.addAll(flower2(250, new Color(220, 20, 60)));
        objects.addAll(flower2(780, new Color(65, 78, 31)));

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

    /**
     * Draws the grass patch. This method generates and returns a list of drawing
     * objects representing a grass patch at the specified x-coordinate.
     * 
     * @return The list of drawing objects representing a grass, when combined, is
     *         the grass patch.
     * @param x The x-coordinate of the grass patch.
     */
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

    /**
     * Draws the bush. This method creates and returns a list of drawing objects
     * representing a bush with the specified color at the given x-coordinate.
     * 
     * @return The list of drawing objects representing each part of the bush.
     * @param x     The x-coordinate of the bush.
     * @param color The color of the bush.
     */

    private ArrayList<DrawingObject> bush(double x, Color color) {
        ArrayList<DrawingObject> bushObjects = new ArrayList<DrawingObject>();
        bushObjects.add(new Cloud(x, 468, 30, color, 0));
        bushObjects.add(new Rectangle(x, 491, 30, 10, color));
        return bushObjects;
    }

    /**
     * Draws a tree. This method creates and returns a list of drawing objects
     * representing a tree with the specified color at the given x-coordinate.
     * 
     * @return The list of drawing objects representing each part of the tree.
     * @param x     The x-coordinate of the tree.
     * @param color The color of the tree.
     */
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

    /**
     * Draws the first variation of a flower. This method creates and returns a list
     * of drawing objects representing a flower with the specified color at the
     * given x-coordinate.
     * 
     * @return The list of drawing objects representing each part of the flower1.
     * @param x     The x-coordinate of the flower1.
     * @param color The color of the flower1.
     */
    private ArrayList<DrawingObject> flower1(double x, Color color) {
        ArrayList<DrawingObject> flowerObjects = new ArrayList<DrawingObject>();
        flowerObjects.add(new Rectangle(x + 3, 472, 6, 30, new Color(48, 105, 75)));
        flowerObjects.add(new Square(x - 10.5, 449, 24, color));
        flowerObjects.add(new Square(x, 449, 24, color));
        flowerObjects.add(new Square(x - 5, 441, 24, color));
        flowerObjects.add(new Circle(x + 2, 457, 8, Color.BLACK));

        return flowerObjects;
    }

    /**
     * Draws the second variation of a flower. This method creates and returns a
     * list of drawing objects representing a flower with the specified color at the
     * given x-coordinate.
     * 
     * @return The list of drawing objects representing each part of the flower2.
     * @param x     The x-coordinate of the flower2.
     * @param color The color of the flower2.
     */
    private ArrayList<DrawingObject> flower2(double x, Color color) {
        ArrayList<DrawingObject> flowerObjects = new ArrayList<DrawingObject>();
        flowerObjects.add(new Rectangle(x, 478, 5, 24, new Color(48, 105, 75)));
        flowerObjects.add(new Rectangle(x, 481, 11, 11, new Color(48, 105, 75)));
        flowerObjects.add(new Rectangle(x, 484, 15, 5, new Color(48, 105, 75)));

        flowerObjects.add(new Rectangle(x - 5.5, 462, 16, 11, color));
        flowerObjects.add(new Square(x - 1.5, 470, 8, color));
        flowerObjects.add(new Square(x - 5.5, 456, 6, color));
        flowerObjects.add(new Square(x + 4.5, 456, 6, color));

        return flowerObjects;
    }

    /**
     * Initializes the raindrop n number of times (where n = (i < n in the for
     * loop)) to show a Rain effect.
     * 
     * @return The list of raindrops
     */
    private ArrayList<Rain> initRain() {
        ArrayList<Rain> raindrops = new ArrayList<>();
        for (int i = 0; i < 69; i++) {
            double x = Math.random() * 800;
            double y = 0;
            double velocity = Math.random() + 60;
            raindrops.add(new Rain(x, y, velocity));
        }
        return raindrops;
    }

    /**
     * Paints the raindrops on the scene canvas. This method paints the raindrops on
     * the scene canvas using the provided graphics.
     * 
     * @param g graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Rain raindrop : raindrops) {
            raindrop.makeItRain(g);
        }
    }
}