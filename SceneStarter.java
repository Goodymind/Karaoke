/**
	The SceneStarter class starts the Karaoke App. 
    It also starts the setup of GUI and starts the Animation loop.
	
	@author Alinus C. Abuke (230073), Neil Aldous Biason (xxxxxx)
	@version 02 September 2023
	
	I have not discussed the Java language code in my program 
	with anyone other than my instructor or the teaching assistants 
	assigned to this course.

	I have not used Java language code obtained from another student, 
	or any other unauthorized source, either modified or unmodified.

	If any Java language code or documentation used in my program 
	was obtained from another source, such as a textbook or website, 
	that has been clearly noted with a proper citation in the comments 
	of my program.
**/
public class SceneStarter {
    /**
     * The Main class, starts the Karaoke app
     * @param args arguments of the app at runtime. It does not use any arguments.
     */
    public static void main(String[] args) {
        SceneFrame sceneFrame = new SceneFrame("Comforting Karaoke");
        sceneFrame.setUpGUI();
        sceneFrame.startAnimation();
    }
}