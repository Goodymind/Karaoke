package scenes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import drawingObjects.DrawingObject;

public class SceneCanvas extends JComponent {

    private final Dimension size = new Dimension(800, 600);
    private ArrayList<DrawingObject> drawingObjects;
    private GradientPaint gradient;

    public SceneCanvas() {
        setPreferredSize(size);
        drawingObjects = draw();
        gradient = new GradientPaint(400, 240, Color.YELLOW, 400, 0, Color.RED);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, 800, 600);

        for (DrawingObject drawingObject : drawingObjects) {
            drawingObject.draw(g2d);
        }
    }

    /**
     * Override to implement custom shape animations;
     * 
     * @param delta time (in seconds) between last update
     */
    public void animateStep(float delta) {
        for (DrawingObject drawingObject : drawingObjects) {
            drawingObject.animateStep(delta);
        }
    }

    /**
     * Override this and put the drawingObjects to display in the scene
     * This is only called once
     * 
     * @return
     */
    protected ArrayList<DrawingObject> draw() {
        return drawingObjects;
    }
}