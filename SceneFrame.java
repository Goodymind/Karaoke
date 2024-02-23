import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.Timer;

import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class SceneFrame extends JFrame {
    private String title;
    private int width;
    private int height;
    private JButton playMusicButton;
    private Clip clip;
    private SceneCanvas current_scene;
    private Timer timer;
    private long previousTime;

    public SceneFrame(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        playMusicButton = new JButton("Play [Insert Song Name]");
        current_scene = new SceneCanvas();
        setUpGUI();
    }

    public void setUpGUI() {
        setTitle(title);
        setSize(width, height);
        current_scene = new SceneCanvas();
        add(current_scene);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(playMusicButton);
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(current_scene, BorderLayout.CENTER);

        playMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                playAudio("C:\\Users\\biaso\\Documents\\GitHub\\Karaoke\\Creep-Radiohead-Acoustic-karaoke.mp3");
            }
        });

        current_scene.setPreferredSize(new Dimension(800, 600));

        pack();
        setVisible(true);
    }

    private void playAudio(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // Open a clip
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Start playing the clip
            clip.start();

            // Wait for the clip to finish playing
            clip.drain();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            // Handle exceptions
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error playing audio!");
        } finally {
            // Close the clip and audio stream to release resources
            if (clip != null) {
                clip.close();
            }
        }
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
