import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class SceneFrame {
    private String title;
    private JFrame frame;

    public SceneFrame(String title) {
        this.title = title;
    }

    public void setUpGUI() {
        frame = new JFrame(title);
        frame.add(new Test());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
