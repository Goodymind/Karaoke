package scenes;

import java.awt.Color;
import java.util.ArrayList;

import drawingObjects.*;
import customData.Vector;

public class Beach extends SceneCanvas {

    private Polygon sand;
    private RectangleBackground sky;
    private Curves waves;
    private Sun sun;

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

        objects.add(sky);
        objects.add(sand);
        objects.add(sun);
        objects.add(waves);
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

    private RectangleBackground initSky() {
        return new RectangleBackground(0, 0, 800, 600, new Color(255, 201, 34), new Color(228, 52, 20), 400, 240, 0, 0);
    }

    float t = 0;
    int d = 1;

    @Override
    public void animateStep(float delta) {
        sun.animateStep(delta);

        if (t > 2)
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
