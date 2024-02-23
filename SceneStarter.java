import java.awt.*;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SceneStarter {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        SceneFrame sf = new SceneFrame(800, 600, "Aesthetic Karaoke");
        sf.setUpGUI();
    }
}