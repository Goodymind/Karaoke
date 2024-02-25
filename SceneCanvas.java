import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import customData.*;

public class SceneCanvas extends JComponent {

    private final Dimension size = new Dimension(800, 600);
    private ArrayList<DrawingObject> drawingObjects;

    public SceneCanvas() {
        setPreferredSize(size);
        drawingObjects = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call superclass method first
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        for (DrawingObject drawingObject : drawingObjects) {
            drawingObject.draw(g2d);
        }
    }

    protected void animateStep(float delta) {
    }

    protected ArrayList<DrawingObject> draw() {
        return drawingObjects;
    }
}