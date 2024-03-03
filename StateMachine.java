import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import scenes.SceneCanvas;

public class StateMachine extends JLayeredPane {
    private final float sceneDuration = 10;

    private SceneCanvas currentScene;
    private ArrayList<SceneCanvas> scenes;
    private int currentSceneIndex;

    private float currentTime;
    private JPanel textPanel;
    public static JLabel label;

    public StateMachine(ArrayList<SceneCanvas> scenes) {
        this.scenes = scenes;
        currentSceneIndex = 0;
        currentScene = scenes.get(currentSceneIndex);

        label = new JLabel("");
        label.setFont(new Font("Sans Serif", Font.BOLD, 28));
        label.setForeground(Color.WHITE);

        textPanel = new JPanel();
        textPanel.setBackground(new Color(255, 255, 255, 0));
        textPanel.setBounds(0, 400, 800, 200);
        textPanel.add(label);
        setLayer(textPanel, 1);
        
        setPreferredSize(currentScene.getPreferredSize());
        currentScene.setSize(getPreferredSize());
        
        add(textPanel);
        add(currentScene, 0);
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
        currentScene.setSize(getPreferredSize());
        add(currentScene, JLayeredPane.DEFAULT_LAYER);
        revalidate();
    }

    public void setText(String text) {
        label.setText(text);
    }
}
