import java.util.ArrayList;

import javax.swing.JPanel;

import scenes.SceneCanvas;

public class StateMachine extends JPanel {
    private final float sceneDuration = 20;

    private SceneCanvas currentScene;
    private ArrayList<SceneCanvas> scenes;
    private int currentSceneIndex;

    private float currentTime;

    public StateMachine(ArrayList<SceneCanvas> scenes) {
        this.scenes = scenes;
        currentSceneIndex = 0;
        currentScene = scenes.get(currentSceneIndex);
        add(currentScene);
    }

    public void animateStep(float d) {
        currentTime += d;
        if (currentTime > sceneDuration) {
            currentTime -= sceneDuration;
            switchScene();
        }
        currentScene.animateStep(d);
    }

    private void switchScene() {
        remove(currentScene);
        currentSceneIndex++;
        if (currentSceneIndex >= scenes.size()) {
            currentSceneIndex = 0;
        }
        currentScene = scenes.get(currentSceneIndex);
        add(currentScene);
        revalidate();
    }
}
