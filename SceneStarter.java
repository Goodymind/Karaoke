/**
 * The SceneStarter class starts the Karaoke App.
 * It also starts the setup of GUI and starts the Animation loop.
 * 
 * @author Alinus Abuke (230073)
 * @author Neil Aldous Biason (230940)
 * @version 06 March 2024
 * 
 *          We have not discussed the Java language code in our program
 *          with anyone other than our instructor or the teaching assistants
 *          assigned to this course.
 * 
 *          We have not used Java language code obtained from another student,
 *          or any other unauthorized source, either modified or unmodified.
 * 
 *          If any Java language code or documentation used in our program
 *          was obtained from another source, such as a textbook or website,
 *          that has been clearly noted with a proper citation in the comments
 *          of our program.
 **/

public class SceneStarter {
	/**
	 * The Main class, starts the Karaoke app
	 * 
	 * @param args arguments of the app at runtime. It does not use any arguments.
	 */
	public static void main(String[] args) {
		SceneFrame sceneFrame = new SceneFrame("Midterm Project - Abuke - Biason");
		sceneFrame.setUpGUI();
		sceneFrame.startAnimation();
	}
}