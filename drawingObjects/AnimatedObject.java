/**
    This interface is designed for objects with animation, providing 
    its own interface for the sake of organization and eliminating the 
    need for an unimplemented function in objects without intended animation.

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

public interface AnimatedObject {
    /**
     * Where changes in mutation happen over time
     * @param delta time between last invoke.
     */
    void animateStep(float delta);
}
