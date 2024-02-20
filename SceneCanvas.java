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

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        // TODO
    }
}
