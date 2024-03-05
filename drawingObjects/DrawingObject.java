/**
	This is an interface that defines the methods(abstract) for objects 
    used in creating shapes and graphics. Showing that each object has 
    the ability(method) to be drawn, and their position to be manipulated.
	
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
import customData.*;

public interface DrawingObject {
    void draw(Graphics2D g2d);

    void setPosition(Vector vector);

    Vector getPosition();

    /**
     * this is called in order to advance the animation by one
     * 
     * @param delta time (in seconds) between the previous call and the current call
     *              of animateStep
     */
    // void animateStep(float delta);
}
