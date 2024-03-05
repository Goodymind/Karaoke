/**
    The KaraokeAudio class is responsibe for the audio output within the 
    karaoke system. Its primary function are the processing and playback 
    of .wav audio files, offering a set of methods for loading, starting, 
    and stopping the audio.
 
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

package audios;

import java.io.File;
import java.util.*;
import javax.sound.sampled.*;

public class KaraokeAudio {
    private static Map<String, String> songs = new HashMap<String, String>();
    private static Map<String, Clip> clips = new HashMap<String, Clip>();
    private static Clip currentClip;
    private static boolean audioStopped = true;

    /**
     * Initializes the loading of the song.
     */
    public static void load() {
        songs.put("Creep", "audios\\Creep.wav");
        songs.put("My Love Mine All Mine", "audios\\Mitski - My Love Mine All Mine (Karaoke Version).wav");
        songs.put("Close To You", "audios\\CloseToYou.wav");
        songs.put("If I Am With You", "audios\\IfIAmWithYou.wav");
        for (String title : songs.keySet()) {
            loadSong(title);
        }
    }

    /**
     * Loads the specific song and stores its playback clip for future use.
     * @title the title of the song.
     */
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

    /**
     * Starts the playback of the song, if it is not stopped, continue.
     * @param title title of the song to play.
     */
    public static void startAudio(String title) {
        if (!audioStopped)
            return;
        audioStopped = false;
        currentClip = clips.get(title);
        currentClip.setFramePosition(0);
        currentClip.start();
    }

    /**
     * Stops the current song from playing.
     */
    public static void stopAudio() {
        if (audioStopped)
            return;
        audioStopped = true;
        if (currentClip != null) {
            if (currentClip.isRunning())
                currentClip.stop();
            currentClip = null;
        }
    }
}