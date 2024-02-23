import java.awt.*;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SceneStarter {
    public static void main(String[] args) {
        var frame = new SceneFrame("test");
        frame.setUpGUI();
        frame.startAnimation();
    }
}