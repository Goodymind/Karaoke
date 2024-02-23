import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import customData.*;

public class SceneCanvas extends JComponent {

    private final Vector size = new Vector(800, 600);
    private ArrayList<DrawingObject> drawingObjects;

    public SceneCanvas() {
        setPreferredSize(size.toDimension());
        drawingObjects = new ArrayList<DrawingObject>();
    }

    // must have at least one (1) loop that iterates through this ArrayList to
    // repeatedly execute instructions affecting the shapes.
    // For example, youcan have a for loop inside the paintComponent method that
    // calls your custom draw method on all of the shapes
    // in the list.

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
    }
}
