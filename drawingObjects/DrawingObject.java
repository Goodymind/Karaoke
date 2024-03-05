package drawingObjects;
import java.awt.*;
import customData.*;

public interface DrawingObject {
    void draw(Graphics2D g2d);
    void setPosition(Vector vector);
    Vector getPosition();

    /**
     * this is called in order to advance the animation by one
     * @param delta time (in seconds) between the previous call and the current call of animateStep
     */
    //void animateStep(float delta);
}
