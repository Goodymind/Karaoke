import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import customData.*;

public abstract class SceneCanvas extends JComponent {

    private final Vector size = new Vector(800, 600);
    private ArrayList<DrawingObject> drawingObjects;


    public SceneCanvas() {
        setPreferredSize(size.toDimension());
        drawingObjects = draw();
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        for (DrawingObject drawingObject : drawingObjects) {
            drawingObject.draw(g2d);
        }
    }

    protected ArrayList<DrawingObject> draw() {
        return null;
    }

    protected void animateStep(float delta) {
        for (DrawingObject dObject : drawingObjects) {
            dObject.animateStep(delta);
        }
    }
}
