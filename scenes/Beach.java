/**
    The Beach class renders a graphical scene by incorporating elements such 
    as sand, sky, waves, sun, clouds, and sailboats. It uses various drawing 
    objects like polygons, rectangles, curves, and clouds to present a calm 
    beach environment with animation.
    
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

import drawingObjects.*;
import customData.Vector;

public class Beach extends SceneCanvas {

    private Polygon sand;
    private Rectangle sky;
    private Curves waves;
    private Sun sun;
    private Cloud cloud;
    private Cloud cloud2;
    private Cloud cloud3;
    private Cloud cloud4;
    private SailBoat boat;
    private SailBoat boat2;
    private SailBoat boat3;

    // wave crashing animation points, Right to Left;
    private ArrayList<Vector[]> animatedPoints;
    private ArrayList<Vector> targetPoints;

    /**
     * Initializes the drawing objects for the beach scene (sand, sky, waves, sun,
     * clouds, and sailboats). It returns a list of drawing objects representing the
     * beach scene.
     * 
     * @return The list of drawing objects representing the beach scene.
     */
    @Override
    protected ArrayList<DrawingObject> draw() {
        ArrayList<DrawingObject> objects = new ArrayList<DrawingObject>();
        sand = initSand();
        sky = initSky();
        waves = initWaves();
        sun = new Sun(new Vector(325, 235), 150, 0);
        cloud = new Cloud(30, 30, 70, new Color(244, 194, 194), 10);
        cloud2 = new Cloud(130, 30, 60, new Color(223, 160, 160), 10);
        cloud3 = new Cloud(600, 20, 85, new Color(255, 188, 217), 15);
        cloud4 = new Cloud(400, 40, 50, new Color(255, 228, 225), 5);
        boat = new SailBoat(new Vector(200, 275), 30, 5, Color.pink);
        boat2 = new SailBoat(new Vector(700, 267), 40, 10, Color.LIGHT_GRAY);
        boat3 = new SailBoat(new Vector(0, 215), 90, 11, new Color(72, 0, 72));
        objects.add(sky);
        objects.add(sand);
        objects.add(sun);
        objects.add(cloud);
        objects.add(cloud2);
        objects.add(cloud3);
        objects.add(cloud4);
        objects.add(waves);
        objects.add(boat);
        objects.add(boat2);
        objects.add(boat3);
        return objects;
    }

    /**
     * Initializes the sand polygon representing the sand and returns it.
     * 
     * @return The sand polygon object.
     */
    private Polygon initSand() {
        var points = new ArrayList<Vector>();
        points.add(new Vector(0, 300));
        points.add(new Vector(800, 300));
        points.add(new Vector(800, 600));
        points.add(new Vector(0, 600));
        return new Polygon(points, new Color(249, 220, 182));
    }

    /**
     * Initializes the waves curves for the beach scene and returns them.
     * 
     * @return The waves object.
     */
    private Curves initWaves() {
        var points = new ArrayList<Vector[]>();
        animatedPoints = new ArrayList<Vector[]>();
        targetPoints = new ArrayList<Vector>();

        points.add(new Vector[] { new Vector(0, 300) }); // 0
        points.add(new Vector[] { new Vector(800, 300) }); // 1
        points.add(new Vector[] { new Vector(882, 454) }); // 2
        points.add(new Vector[] { new Vector(730, 500), new Vector(880, 450), new Vector(790, 500) }); // 3
        points.add(new Vector[] { new Vector(600, 410), new Vector(670, 500), new Vector(650, 410) }); // 4
        points.add(new Vector[] { new Vector(435, 500), new Vector(550, 410), new Vector(500, 500) }); // 5
        points.add(new Vector[] { new Vector(260, 410), new Vector(365, 500), new Vector(350, 410) }); // 6
        points.add(new Vector[] { new Vector(83, 500), new Vector(175, 410), new Vector(150, 500) }); // 7
        points.add(new Vector[] { new Vector(-60, 410), new Vector(26, 500), new Vector(-60, 410) }); // 8

        animatedPoints.add(points.get(2));
        targetPoints.add(new Vector(882, 500));
        animatedPoints.add(points.get(3));
        targetPoints.add(new Vector(730, 410));
        animatedPoints.add(points.get(4));
        targetPoints.add(new Vector(600, 500));
        animatedPoints.add(points.get(5));
        targetPoints.add(new Vector(435, 410));
        animatedPoints.add(points.get(6));
        targetPoints.add(new Vector(260, 500));
        animatedPoints.add(points.get(7));
        targetPoints.add(new Vector(83, 410));
        animatedPoints.add(points.get(8));
        targetPoints.add(new Vector(-60, 500));

        return new Curves(points, new Color(95, 72, 255));
    }

    /**
     * Initializes the sky rectangle(Background) representing the sky of the beach
     * scene and
     * returns it.
     * 
     * @return The sky rectangle object(RectangleBackground object).
     */
    private Rectangle initSky() {
        return new RectangleBackground(0, 0, 800, 600, new Color(245, 129, 0), new Color(39, 0, 108), 0, 300, 0, 0);
    }

    float t = 0;
    int d = 1;

    /**
     * Manages the animation of the beach scene, adjusting elements like the
     * position of the sun, movement of clouds, and waves' motion,
     * based on the elapsed time since the last frame.
     * 
     * @param delta The time elapsed since the last animation frame, influencing the
     *              animation speed and progression.
     */
    @Override
    public void animateStep(float delta) {
        sun.animateStep(delta);
        cloud.animateStep(delta);
        cloud2.animateStep(delta);
        cloud3.animateStep(delta);
        cloud4.animateStep(delta);
        boat.animateStep(delta);
        boat2.animateStep(delta);
        boat3.animateStep(delta);

        if (t > 3)
            d = -1;
        if (t < 0)
            d = 1;
        delta *= d;
        for (int i = 0; i < animatedPoints.size(); i++) {
            Vector[] animatedPoint = animatedPoints.get(i);
            Vector pathpoint = animatedPoint[0];
            pathpoint = Vector.lerp(pathpoint, targetPoints.get(i), delta);
            animatedPoint[0] = pathpoint;
            for (int j = 1; j < animatedPoint.length; j++) {
                Vector target = new Vector(animatedPoint[j].getX(), targetPoints.get(i).getY());
                animatedPoint[j] = Vector.lerp(animatedPoint[j], target, delta);
            }
        }
        t += delta;
    }
}