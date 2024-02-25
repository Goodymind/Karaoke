public class SceneStarter {
    public static void main(String[] args) {
        SceneFrame sceneFrame = new SceneFrame("Comforting Karaoke", 800, 600);
        sceneFrame.setUpGUI();
        sceneFrame.startAnimation();
    }
}