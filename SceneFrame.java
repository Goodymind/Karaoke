import javax.swing.*;

public class SceneFrame {
    private String title;
    private JFrame frame;
    private int width;
    private int height;

    public SceneFrame(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void setUpGUI() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
