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

    @Override
    protected ArrayList<DrawingObject> draw() {
        rng = new Random();
        dvd = new DVD(new Vector(0, 0), 200f, Color.RED);
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
        return obj;
    }
}