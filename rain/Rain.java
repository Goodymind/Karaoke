package rain;

import java.awt.*;
import java.util.Random;

public class Rain {

    private double x;
    private double y;
    private double velocity;
    Random rd;

    public Rain(double x, double y, double velocity) {
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        rd = new Random();
    }

    public void makeItRain(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(119, 136, 153));
        g2d.fillRect((int) x, (int) y, 2, 5);

        y += velocity;

        if (y > 605) {
            x = rd.nextInt(800);
            y = 0;
            velocity = rd.nextDouble() + 0.5;
        }
    }
}
