package lyrics;

import java.awt.Font;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JLabel;

public class LyricDisplay {
    public static final Map<String, String> paths = new HashMap<String, String>();
    public static final ArrayList<Integer> times = new ArrayList<Integer>();
    public static final ArrayList<String> lines = new ArrayList<String>();

    public static JLabel label;
    private static float totalTime;
    private static boolean songStarted = false;
    private static int currentLine;

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
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    var data = line.split(":");
                    times.add(Integer.parseInt(data[0]));
                    lines.add(data[1]);
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
        label.setFont(new Font("Monospaced", Font.BOLD, 35));
        label.setText(title);
    }

    public static void stop() {
        if (songStarted) {
            label.setFont(new Font("Monospaced", Font.ITALIC, 20));
            label.setText("Select a Song");
            songStarted = false;
        }
    }

    public static void step(float delta) {
        if (!songStarted)
            return;
        int nextTime = times.get(currentLine + 1);
        if (totalTime > nextTime) {
            label.setFont(new Font("Monospaced", Font.BOLD, 48));
            currentLine++;
            label.setText(lines.get(currentLine));
        }
        totalTime += delta;
    }

}
