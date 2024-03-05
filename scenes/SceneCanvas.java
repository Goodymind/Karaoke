/**
    This class serves as a framework for creating the scenes. 
    It uses the functionality of the JComponent class to aid 
    in rendering the drawing objects on to the GUI.

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

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import drawingObjects.AnimatedObject;
import drawingObjects.DrawingObject;

public class SceneCanvas extends JComponent {

    private final Dimension size = new Dimension(800, 600);
    private ArrayList<DrawingObject> drawingObjects;

    public SceneCanvas() {
        setPreferredSize(size);
        drawingObjects = draw();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

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
            if (drawingObject instanceof AnimatedObject animatedObject) {
                animatedObject.animateStep(delta);
            }
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