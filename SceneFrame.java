import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;

public class SceneFrame {
    private String title;
    private JFrame frame;
    private int width;
    private int height;
    private JButton playMusicButton;
    private JButton playOtherSongButton1;
    private JButton playOtherSongButton2;
    private JButton stopButton;
    private SceneCanvas current_scene;
    private Timer timer;
    private long previousTime;
    private Clip clip;

    public SceneFrame(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        playMusicButton = new JButton("Play Creep(Acoustic) - Radiohead");
        playOtherSongButton1 = new JButton("Play Para Sa Akin - Jason Dhakal");
        playOtherSongButton2 = new JButton("Play Love - Keyshia Cole");
        stopButton = new JButton("Stop Music");
        current_scene = new SceneCanvas();
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
        buttonPanel.add(playOtherSongButton1);
        buttonPanel.add(playOtherSongButton2);
        buttonPanel.add(stopButton);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        contentPane.add(current_scene, BorderLayout.CENTER);

        playMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String filePath = "C:\\Users\\biaso\\Documents\\GitHub\\Karaoke\\Audios\\Creep.wav";
                playAudio(filePath);
            }
        });

        playOtherSongButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String filePath = "Audios/ParaSaAkin.wav";
                playAudio(filePath);
            }
        });

        playOtherSongButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String filePath = "C:\\Users\\biaso\\Documents\\GitHub\\Karaoke\\Audios\\Love.wav";
                playAudio(filePath);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                stopAudio();
            }
        });

        frame.setVisible(true);
        frame.pack();
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
     * currently in display) repaint tells the computer to call paintComponent again
     * 
     * @param delta time between last call in seconds
     */
    public void animateStep(float delta) {
        // Implement animation logic
        current_scene.animateStep(delta);
        current_scene.repaint();
    }

    public void playAudio(String filePath) {
        try {
            File audioFile = new File(filePath);
            if (audioFile.exists()) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } else {
                System.out.println("File not found: " + filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopAudio() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}