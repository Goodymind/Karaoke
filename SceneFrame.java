import javax.swing.*;

import audios.KaraokeAudio;
import rain.Render;
import scenes.*;

import java.awt.*;
import java.awt.event.*;

public class SceneFrame {
    private int width;
    private int height;
    private String title;
    private JFrame frame;
    private JButton song_one;
    private JButton song_two;
    private JButton song_three;
    private JButton stopButton;
    private SceneCanvas current_scene;
    private Timer timer;
    private long previousTime;

    public SceneFrame(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        current_scene = new Minecraft();
    }

    public void setUpGUI() {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);

        song_one = new JButton("Play Creep(Acoustic) - Radiohead");
        song_two = new JButton("Play My Love Mine All Mine - Mitski");
        song_three = new JButton("Play Close To You(Acoustic) - The Carpenters");
        stopButton = new JButton("Stop Music");

        Render r = new Render();
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(current_scene, BorderLayout.CENTER);
        setUpKaraokeControls(contentPane);
        frame.setVisible(true);
        frame.pack();
        frame.setLocation(0, 0);
        frame.setResizable(false);
    }

    private void setUpKaraokeControls(Container contentPane) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(song_one);
        buttonPanel.add(song_two);
        buttonPanel.add(song_three);

        JPanel stopPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        stopPanel.add(stopButton);

        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(stopPanel, BorderLayout.SOUTH);

        ActionListener karaokeButtonControlListeners = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == song_one) {
                    KaraokeAudio.stopAudio();
                    KaraokeAudio.startAudio("Creep");

                }
                if (ae.getSource() == song_two) {
                    KaraokeAudio.stopAudio();
                    KaraokeAudio.startAudio("My Love Mine All Mine");
                }
                if (ae.getSource() == song_three) {
                    KaraokeAudio.stopAudio();
                    KaraokeAudio.startAudio("Close To You");
                }
                if (ae.getSource() == stopButton) {
                    KaraokeAudio.stopAudio();
                }
            }
        };
        song_one.addActionListener(karaokeButtonControlListeners);
        song_two.addActionListener(karaokeButtonControlListeners);
        song_three.addActionListener(karaokeButtonControlListeners);
        stopButton.addActionListener(karaokeButtonControlListeners);
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
        previousTime = System.nanoTime();
    }

    /**
     * Calls the animateStep of the current canvas scene (will be the one that is
     * currently in display) repaint tells the computer to call paintComponent again
     * 
     * @param delta time between last call in seconds
     */
    public void animateStep(float delta) {
        // Implement animation logic
        current_scene.animateStep(delta);
        current_scene.repaint();
    }
}