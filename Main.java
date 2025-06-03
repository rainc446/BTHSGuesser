import javax.swing.*;
import java.util.Timer;

public class Main{
    public static JFrame mainFrame;
    public static JPanel currentPanel;
    public static final MainScreen mainScreen = new MainScreen();
    public static final SettingsScreen settingsScreen = new SettingsScreen();
    public static final GameScreen gameScreen = new GameScreen();
    public static int numOfRounds = 3;
    public static double timeLimit = 15.0;

    public static void main(String[] args) {

        /**
         * Main Screen
         *
         * -first part sets up the window frame
         *
         * -JPanel is the display panel of the window
         * */
        mainFrame = new JFrame();
        mainFrame.setTitle("BTHS Guessr");
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setSize(Constants.width, Constants.height); //1920, 1080 is 1080p

        currentPanel = mainScreen;

        mainFrame.add(currentPanel);
        mainFrame.setVisible(true);
    }

    public static void changeScreen(JPanel panel) {
        mainFrame.setVisible(false);
        mainFrame.removeAll();
        currentPanel = panel;
        mainFrame.add(panel);
        mainFrame.setVisible(true);
    }

    public static void playGame () {
        int rounds = 0;
        Clock timer = Clock.systemDefaultZone();
        while (rounds < numOfRounds) {
            if (timer >= timeLimit) { //https://stackoverflow.com/questions/4044726/how-to-set-a-timer-in-java

            }
        }
    }

    public static Location getLocation () {

    }

}
