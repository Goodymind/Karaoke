package scenes;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import customData.Vector;
import drawingObjects.DVD;
import drawingObjects.DrawingObject;

public class DVDScreen extends SceneCanvas {

    public DVDScreen() {
        super();
        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var mousePos = Vector.pointToVector(e.getPoint());
                System.out.println(mousePos);
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
    }

    @Override
    protected ArrayList<DrawingObject> draw() {
        ArrayList<DrawingObject> obj = new ArrayList<DrawingObject>();
        obj.add(new DVD(new Vector(100, 100), 200f, Color.RED));
        return obj;
    }

}
