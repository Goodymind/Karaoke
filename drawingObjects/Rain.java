/**
    This class is responsible for creating the rain effect 
    in the Minecraft Scenery. Upon instantiation, it initializes 
    a "raindrop" with properties including position and velocity, 
    and has a method, "makeItRain," to render raindrops falling downwards.

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

package drawingObjects;

import java.awt.*;
import java.util.Random;

public class Rain {

    private double x;
    private double y;
    private double velocity;
    Random rd;

    /**
     * Constructs a Rain object with the specified initial position and velocity.
     *
     * @param x        the x-coordinate of the raindrop's initial position
     * @param y        the y-coordinate of the raindrop's initial position
     * @param velocity the velocity at which the raindrop falls
     */
    public Rain(double x, double y, double velocity) {
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        rd = new Random();
    }

    /**
     * Renders the raindrop falling downwards on the screen.
     *
     * @param g the Graphics object to draw the raindrop
     */
    public void makeItRain(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        g2d.setColor(Color.BLUE);
        g2d.fillRect((int) x, (int) y, 2, 5);

        y += velocity;

        if (y > 497) {
            x = rd.nextInt(800);
            y = -5;
            velocity = rd.nextDouble() + 0.5;
        }
    }
}