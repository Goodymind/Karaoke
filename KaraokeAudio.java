import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class KaraokeAudio {
    private static Map<String, String> songs = new HashMap<String, String>();
    private static Clip clip;
    
    //static version of constructor
    static {
        songs.put("Creep","Audios\\Creep.wav");
        songs.put("Para Sa Akin", "Audios\\ParaSaAkin.wav");
        songs.put("Love", "Audios\\Love.wav");
    }
    

    public static void startAudio(String title) {
        String filePath = songs.get(title);
        try {
            File audioFile = new File(filePath);
            if (audioFile.exists()) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                System.out.println(audioStream);
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
    public static void stopAudio() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
