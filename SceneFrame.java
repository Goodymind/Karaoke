import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SceneFrame {
    private String title;
    private JFrame frame;
    private SceneCanvas current_scene;
    private Timer timer;
    private long previousTime;

    public SceneFrame(String title) {
        this.title = title;
    }

    public void setUpGUI() {
        frame = new JFrame(title);
        current_scene = new Test();
        frame.add(current_scene);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void startAnimation() {
        ActionListener timerListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                long currentTime = System.nanoTime();
                animateStep((currentTime - previousTime) / 1_000_000_000f);
                previousTime = currentTime;
            }
        };
        timer = new Timer(0, timerListener);
        timer.setRepeats(true);
        timer.start();
        previousTime = System.currentTimeMillis();
    }

    /**
     * Calls the animateStep of the current canvas scene (will be the one that is currently in display)
     * repaint tells the computer to call paintComponent again
     * @param delta time between last call in seconds
     */
    public void animateStep(float delta) {
        current_scene.animateStep(delta);
        current_scene.repaint();
    }
}
