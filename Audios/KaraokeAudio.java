package audios;

import java.io.File;
import java.util.*;
import javax.sound.sampled.*;

public class KaraokeAudio {
    private static Map<String, String> songs = new HashMap<String, String>();
    private static Map<String, Clip> clips = new HashMap<String, Clip>();
    private static Clip current_clip;
    private static boolean audioStopped = true;

    // static version of constructor
    public static void load() {
        songs.put("Creep", "audios\\Creep.wav");
        songs.put("My Love Mine All Mine", "audios\\Mitski - My Love Mine All Mine (Karaoke Version).wav");
        songs.put("Close To You", "audios\\CloseToYou.wav");
        songs.put("If I Am With You", "audios\\IfIAmWithYou.wav");
        for (String title : songs.keySet()) {
            loadSong(title);
        }
    }

    private static void loadSong(String title) {
        String filePath = songs.get(title);
        Clip clip = null;
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clips.put(title, clip);
    }

    public static void startAudio(String title) {
        if (!audioStopped)
            return;
        audioStopped = false;
        current_clip = clips.get(title);
        current_clip.setFramePosition(0);
        current_clip.start();
    }

    public static void stopAudio() {
        if (audioStopped)
            return;
        audioStopped = true;
        if (current_clip != null) {
            if (current_clip.isRunning())
                current_clip.stop();
            current_clip = null;
        }
    }
}
