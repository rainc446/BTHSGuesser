import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main{
    public static JFrame frame;
    public static JPanel currentPanel;
    public static final MainScreen mainScreen = new MainScreen();
    public static final SettingsScreen settingsScreen = new SettingsScreen();
    public static final GameScreen gameScreen = new GameScreen();
    public static void main(String[] args) {

        /**
         * Main Screen
         *
         * -first part sets up the window frame
         *
         * -JPanel is the display panel of the window
         * */
        frame = new JFrame();
        frame.setTitle("BTHS Guessr");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(Constants.width, Constants.height); //1920, 1080 is 1080p

        currentPanel = mainScreen;

        frame.add(currentPanel);
        frame.setVisible(true);

    }
    public static void changeScreen(JPanel panel) {
        frame.remove(currentPanel);
        currentPanel = panel;
        frame.add(panel);
    }

}
