package drawingObjects;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleBackground extends Rectangle {

    protected Color color2;
    protected double endX;
    protected double endY;
    protected double startX;
    protected double startY;

    public RectangleBackground(double x, double y, double width, double height, Color color1, Color color2,
            double startX, double startY, double endX, double endY) {
        super(x, y, width, height, color1);
        this.color2 = color2;
        this.endX = endX;
        this.endY = endY;
        this.startX = startX;
        this.startY = startY;
    }

    @Override
    public void draw(Graphics2D g2d) {
        GradientPaint gradient = new GradientPaint((float) startX, (float) startY, color, (float) endX, (float) endY,
                color2);
        g2d.setPaint(gradient);
        Rectangle2D.Double rect = new Rectangle2D.Double(x, y, width, height);
        g2d.fill(rect);
    }
}
