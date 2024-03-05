package scenes;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import customData.Vector;
import drawingObjects.Cloud;
import drawingObjects.DVD;
import drawingObjects.DrawingObject;
import drawingObjects.Rectangle;

public class DVDScreen extends SceneCanvas {

    private DVD dvd;
    private Rectangle bg;
    private Random rng;

    @Override
    protected ArrayList<DrawingObject> draw() {
        rng = new Random();
        dvd = new DVD(new Vector(0, 0), 200f, Color.RED);
        // bg = new RectangleBackground(0, 0, 800, 600, Color.BLACK, new Color(140, 190,
        // 214), 400, 1500, 400,-300);
        bg = new Rectangle(0, 0, 800, 600, new Color(10, 10, 10));
        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var mousePos = Vector.pointToVector(e.getPoint());
                Vector newVelocity = Vector.subtract(dvd.getPosition(), mousePos);
                dvd.setVelocity(newVelocity);
                dvd.setColor(new Color(rng.nextInt(0, 255), rng.nextInt(0, 255), rng.nextInt(0, 255)));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        };
        addMouseListener(listener);
        ArrayList<DrawingObject> obj = new ArrayList<DrawingObject>();
        obj.add(bg);
        obj.add(dvd);

        /*
         * for (int i = 0; i < 20; i++) {
         * obj.add(new Cloud(i * 100, 15, Math.random() * 10 + 30,
         * new Color(rng.nextInt(0, 255), rng.nextInt(0, 255), rng.nextInt(0, 255)),
         * Math.random() * 20 + 5));
         * }
         */
        return obj;
    }

}
