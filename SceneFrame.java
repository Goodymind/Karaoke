import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class SceneFrame {
    private String title;
    private JFrame frame;
    private int width;
    private int height;
    private SceneCanvas sceneCanvas;
    private JButton playMusicButton;
    private Clip clip;

    public SceneFrame(int width, int height, String title) {
        this.width = width;
        this.height = height;
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
            JOptionPane.showMessageDialog(frame, "Error playing audio!");
        } finally {
            // Close the clip and audio stream to release resources
            if (clip != null) {
                clip.close();
            }
        }
    }

}
