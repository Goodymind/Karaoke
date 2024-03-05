/**
    This class is responsible for the graphical display of the lyrics
    on to the GUI. This class handles loading lyrics from text files, 
    starting and stopping song playback, and updating the displayed lyrics 
    as the song plays.

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

package lyrics;

import java.awt.Font;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JLabel;

public class LyricDisplay {

    private static class LyricLine {

        private float time;
        private String lyrics;

        public LyricLine(float time, String lyrics) {
            this.time = time;
            this.lyrics = lyrics;
        }

        public float getTime() {
            return time;
        }

        public String getLine() {
            return lyrics;
        }
    }

    public static final Map<String, String> paths = new HashMap<String, String>();
    public static final Map<String, ArrayList<LyricLine>> lyrics = new HashMap<String, ArrayList<LyricLine>>();

    public static JLabel label;
    private static float totalTime;
    private static boolean songStarted = false;
    private static int currentLine;
    private static String currentSong;

    public static void load() {
        label.setFont(new Font("Monospaced", Font.ITALIC, 20));
        label.setText("Select a Song");

        paths.put("Creep", "lyrics\\creep.radiohead.txt");
        paths.put("My Love Mine All Mine", "lyrics\\mylovemineallmine.mitski.txt");
        paths.put("Close To You", "lyrics\\closetoyou.carpenters.txt");

        for (String title : paths.keySet()) {
            String path = paths.get(title);
            try {
                File file = new File(path);
                Scanner reader = new Scanner(file);
                lyrics.put(title, new ArrayList<LyricLine>());
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    var data = line.split(":");
                    lyrics.get(title).add(new LyricLine(Float.parseFloat(data[0]), data[1]));
                }
                reader.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public static void start(String title) {
        songStarted = true;
        totalTime = 0;
        currentLine = -1;
        label.setFont(new Font("MS Sans Serif", Font.BOLD, 35));
        label.setText(title);
        currentSong = title;
    }

    public static void stop() {
        if (songStarted) {
            label.setFont(new Font("Monospaced", Font.ITALIC, 20));
            label.setText("Select a Song");
            songStarted = false;
            currentSong = "";
        }
    }

    public static void step(float delta) {
        if (!songStarted)
            return;
        if (currentLine + 1 >= lyrics.get(currentSong).size()) {
            stop();
            return;
        }
        float nextTime = lyrics.get(currentSong).get(currentLine + 1).getTime();
        if (totalTime > nextTime) {
            label.setFont(new Font("MS Sans Serif", Font.PLAIN, 48));
            currentLine++;
            label.setText(lyrics.get(currentSong).get(currentLine).getLine());
        }
        totalTime += delta;
    }

}
