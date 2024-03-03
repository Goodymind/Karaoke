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
    private SailBoat boat;
    private SailBoat boat2;
    private SailBoat boat3;

    // wave crashing animation points, Right to Left;
    private ArrayList<Vector[]> animatedPoints;
    private ArrayList<Vector> targetPoints;

    @Override
    protected ArrayList<DrawingObject> draw() {
        ArrayList<DrawingObject> objects = new ArrayList<DrawingObject>();
        sand = initSand();
        sky = initSky();
        waves = initWaves();
        sun = new Sun(new Vector(350, 240), 100, 0);
        cloud = new Cloud(30, 30, 70, new Color(157, 157, 157, 250), 3);
        cloud2 = new Cloud(130, 30, 60, new Color(157, 157, 157, 250), 2);
        cloud3 = new Cloud(600, 20, 90, new Color(157, 157, 157, 250), 1);
        boat = new SailBoat(new Vector(200, 275), 30, 3);
        boat2 = new SailBoat(new Vector(700, 267), 40, 1);
        boat3 = new SailBoat(new Vector(-20, 215), 100, 10);
        objects.add(sky);
        objects.add(sand);
        objects.add(sun);
        objects.add(cloud);
        objects.add(cloud2);
        objects.add(cloud3);
        objects.add(waves);
        objects.add(boat);
        objects.add(boat2);
        objects.add(boat3);
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

    private Rectangle initSky() {
        return new RectangleBackground(0, 0, 800, 600, new Color(245, 129, 0), new Color(39, 0, 108), 0, 300, 0, 0);
    }

    float t = 0;
    int d = 1;    
    @Override
    public void animateStep(float delta) {
        sun.animateStep(delta);
        cloud.animateStep(delta);
        cloud2.animateStep(delta);
        cloud3.animateStep(delta);
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