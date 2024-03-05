
/**
	The StateMachine class provides the Lyrics Overlay and the switching
    of Karaoke Backgrounds(Sceneries). It uses a Finite State Machine system 
    to work.

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

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import scenes.SceneCanvas;

public class StateMachine extends JLayeredPane {
    private final float sceneDuration = 20;

    private SceneCanvas currentScene;
    private ArrayList<SceneCanvas> scenes;
    private int currentSceneIndex;

    private float currentTime;
    private JPanel textPanel;
    public static JLabel label;

    /**
     * The Constructor;
     * This method initializes the StateMachine with the provided
     * scenes, sets the current scene to the first scene in the list
     * (order of scenes is based on which is added first),
     * creates a text panel for displaying lyrics overlay, and adds
     * the current scene and text panel.
     * 
     * @param scenes The list of SceneCanvas objects, these are the scenes to be
     *               shown in intervals.
     */
    public StateMachine(ArrayList<SceneCanvas> scenes) {
        this.scenes = scenes;
        currentSceneIndex = 0;
        currentScene = scenes.get(currentSceneIndex);

        label = new JLabel("");
        label.setForeground(Color.WHITE);

        textPanel = new JPanel();
        textPanel.setBackground(new Color(255, 255, 255, 0));
        textPanel.setBounds(0, 150, 800, 200);
        textPanel.add(label);
        setLayer(textPanel, 1);

        setPreferredSize(currentScene.getPreferredSize());
        currentScene.setSize(getPreferredSize());

        add(textPanel);
        add(currentScene, 0);
    }

    /**
     * Animates the StateMachine by updating the current scene and handling
     * scene transitions based on elapsed time.
     * This method updates the current time and checks if it exceeds the
     * duration of the current scene. If so, it switches to the next scene.
     * It also calls the animateStep method of the current scene to animate it.
     * 
     * @param delta The time difference between animation steps.
     */
    public void animateStep(float delta) {
        currentTime += delta;
        if (currentTime > sceneDuration) {
            currentTime -= sceneDuration;
            switchScene();
        }
        currentScene.animateStep(delta);
    }

    /**
     * Switches to the next scene in the list of scenes.
     * This method removes the current scene, gets the next scene,
     * adjusts its size, adds it, and updates the pane.
     */
    private void switchScene() {
        remove(currentScene);
        currentSceneIndex++;
        if (currentSceneIndex >= scenes.size()) {
            currentSceneIndex = 0;
        }
        currentScene = scenes.get(currentSceneIndex);
        currentScene.setSize(getPreferredSize());
        add(currentScene, JLayeredPane.DEFAULT_LAYER);
        revalidate();
    }

    /**
     * Sets the line of the lyrics to be displayed
     * This method sets the text of the label used for displaying lyrics overlay.
     * 
     * @param text A line of the lyrics to be displayed.
     */

    public void setText(String text) {
        label.setText(text);
    }
}
