import java.awt.*;
import customData.*;

public interface DrawingObject {
    void draw(Graphics2D g2d);
    void setPosition(Vector vector);
    Vector getPosition();
}
