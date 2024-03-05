
/**
	The SceneFrame class contains the window frame.
    It is the root of the animation loop and the root of button inputs.

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

import javax.swing.*;

import audios.KaraokeAudio;
import lyrics.LyricDisplay;
import scenes.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SceneFrame {
    private String title;
    private JFrame frame;
    private JButton songOne;
    private JButton songTwo;
    private JButton songThree;
    private JButton stopButton;
    private StateMachine sceneSwitcher;
    private Timer timer;
    private long previousTime;

    /**
     * Constructor of the SceneFrame class.
     * 
     * @param title title of the frame.
     */
    public SceneFrame(String title) {
        this.title = title;
    }

    /*
     * setUpGUI setups the GUI components and layout of the frame.
     * Also initializes the background scenes of the karaoke.
     */
    public void setUpGUI() {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        songOne = new JButton("Play Creep(Acoustic) - Radiohead");
        songTwo = new JButton("Play My Love Mine All Mine - Mitski");
        songThree = new JButton("Play Close To You(Acoustic) - Carpenters");
        stopButton = new JButton("Stop Music");

        ArrayList<SceneCanvas> scenes = new ArrayList<SceneCanvas>();
        scenes.add(new DVDScreen());
        scenes.add(new Minecraft());
        scenes.add(new Beach());
        sceneSwitcher = new StateMachine(scenes);

        LyricDisplay.label = StateMachine.label;

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(sceneSwitcher, BorderLayout.CENTER);
        setUpKaraokeControls(contentPane);
        KaraokeAudio.startAudio("If I Am With You");

        frame.setVisible(true);
        frame.pack();
        frame.setLocation(0, 0);
        frame.setResizable(false);
    }

    /*
     * Invoked in setUPGUI, setups the Karaoke system GUI components
     * and Action Listeners.
     * Invokes the loading of the Audio, and the Lyrics.
     */
    private void setUpKaraokeControls(Container contentPane) {
        KaraokeAudio.load();
        LyricDisplay.load();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(songOne);
        buttonPanel.add(songTwo);
        buttonPanel.add(songThree);

        JPanel stopPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        stopPanel.add(stopButton);

        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(stopPanel, BorderLayout.SOUTH);

        ActionListener karaokeButtonControlListeners = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                KaraokeAudio.stopAudio();
                LyricDisplay.stop();
                if (ae.getSource() == songOne) {
                    KaraokeAudio.startAudio("Creep");
                    LyricDisplay.start("Creep");
                }
                if (ae.getSource() == songTwo) {
                    KaraokeAudio.startAudio("My Love Mine All Mine");
                    LyricDisplay.start("My Love Mine All Mine");
                }
                if (ae.getSource() == songThree) {
                    KaraokeAudio.startAudio("Close To You");
                    LyricDisplay.start("Close To You");
                }
            }
        };
        songOne.addActionListener(karaokeButtonControlListeners);
        songTwo.addActionListener(karaokeButtonControlListeners);
        songThree.addActionListener(karaokeButtonControlListeners);
        stopButton.addActionListener(karaokeButtonControlListeners);
    }

    /**
     * Called to start the Animation Loop
     * Uses Timers with a delay of 1ms (100 graphics updates/repaints per second)
     * or 100 frames per second
     */
    public void startAnimation() {
        ActionListener timerListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                long currentTime = System.nanoTime();
                float delta = (currentTime - previousTime) / 1_000_000_000f;
                animateStep(delta);
                LyricDisplay.step(delta);
                previousTime = currentTime;
            }
        };
        timer = new Timer(1, timerListener);
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
        sceneSwitcher.animateStep(delta);
        sceneSwitcher.repaint();
    }
}