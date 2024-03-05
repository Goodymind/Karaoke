/**
    Uses the DVD DrawingObject to implement a DVD Object bouncing around, 
    It incorporates MouseListener for interactivity to change the DVD's 
    velocity and color randomly upon a click of a mouse.
    
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import customData.Vector;
import drawingObjects.DVD;
import drawingObjects.DrawingObject;
import drawingObjects.Rectangle;

public class DVDScreen extends SceneCanvas {

    private DVD dvd;
    private Rectangle bg;
    private Random rng;

    /**
     * Initializes the drawing objects and sets up the DVD bouncing effect with
     * interactivity. This method initializes the DVD object, background rectangle,
     * and sets up a MouseListener for interactivity.
     * 
     * @return The list of drawing objects representing the scene.
     */
    @Override
    protected ArrayList<DrawingObject> draw() {
        rng = new Random();
        dvd = new DVD(new Vector(0, 0), 200f, Color.RED);
        bg = new Rectangle(0, 0, 800, 600, new Color(10, 10, 10));
        MouseListener listener = new MouseListener() {

            /**
             * Handles the mouse click event to change DVD velocity and color. This method
             * retrieves the mouse position, calculates a new velocity for the DVD, and sets
             * the DVD's velocity and color randomly based on the mouse click event.
             * 
             * @param e The MouseEvent object containing information about the mouse click.
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                var mousePos = Vector.pointToVector(e.getPoint());
                Vector newVelocity = Vector.subtract(dvd.getPosition(), mousePos);
                dvd.setVelocity(newVelocity);
                dvd.setColor(new Color(rng.nextInt(0, 255), rng.nextInt(0, 255), rng.nextInt(0, 255)));
            }

            /**
             * The other methods included in the implemented interface handles the mouse
             * events other than click. This method is left empty as it is not used for this
             * implementation.
             * 
             * @param e The MouseEvent object containing information about the mouse event.
             */

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
        return obj;
    }
}