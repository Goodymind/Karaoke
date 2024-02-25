import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;

public class SceneFrame {
    private String title;
    private JFrame frame;
    private int width;
    private int height;
    private SceneCanvas sceneCanvas;
    private JButton playMusicButton;
    private Clip clip;
    private SceneCanvas current_scene;
    private Timer timer;
    private long previousTime;

    public SceneFrame(String title) {
        this.title = title;
        playMusicButton = new JButton("Play [Insert Song Name]");
        sceneCanvas = new SceneCanvas();
    }

    public void setUpGUI() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(playMusicButton);
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(sceneCanvas, BorderLayout.CENTER);

        playMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                playAudio("C:\\Users\\biaso\\Documents\\GitHub\\Karaoke\\Creep-Radiohead-Acoustic-karaoke.mp3");
            }
        });

        sceneCanvas.setPreferredSize(new Dimension(800, 600));

        frame.pack();
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
     * Calls the animateStep of the current canvas scene (will be the one that is
     * currently in display)
     * repaint tells the computer to call paintComponent again
     * 
     * @param delta time between last call in seconds
     */
    public void animateStep(float delta) {
        current_scene.animateStep(delta);
        current_scene.repaint();
    }
}
