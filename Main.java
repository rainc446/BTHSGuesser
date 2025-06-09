import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Main{
    public static JFrame mainFrame;
    public static JPanel currentPanel;
    public static final MainScreen mainScreen = new MainScreen();
    public static GameScreen gameScreen;
    public static int numOfRounds;
    private static int rounds = 1;
    public static double timeLimit = 15.0;
    private static boolean finishedSettings = false;
    private static int totalNumberOfRooms = 1;
    private static Location currentLocation;
    private static Map map;
    public static ArrayList<Location> locations = new ArrayList<Location>();
    public static boolean firstRound = true;
    public static ArrayList<Integer> scores = new ArrayList<Integer>();
    private static int randomIndex = 0;

    public static void main(String[] args) {
        while (!finishedSettings) {
            Scanner selectDifficulty = new Scanner(System.in);
            System.out.println("Select a difficulty: Easy, Medium, Hard");

            finishedSettings = GameSettings.changeSettings(selectDifficulty.nextLine());
            if (!finishedSettings) {
                System.out.println("Try Again!");
            }
        }

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

    public static void setupLocations () {
        try (Scanner getLocationData = new Scanner(new File("images/locations/roomInfo"))) {
            // Skip 5 lines
            for (int i = 0; i < 6; i++) {
                if (getLocationData.hasNextLine()) {
                    getLocationData.nextLine();
                }
            }
            while (getLocationData.hasNextLine() && locations.size() < Constants.numOfLocations) {
                String directory = getLocationData.nextLine().trim();
                //https://www.w3schools.com/java/java_user_input.asp
                //Deepseek.ai bug fix for scanner issues
                // Skip empty lines between entries
                while (directory.isEmpty() && getLocationData.hasNextLine()) {
                    directory = getLocationData.nextLine().trim();
                }

                if (!getLocationData.hasNextLine()) break;
                String name = getLocationData.nextLine().trim();

                if (!getLocationData.hasNextInt()) break;
                int floor = getLocationData.nextInt();

                if (!getLocationData.hasNextInt()) break;
                int x = getLocationData.nextInt();

                if (!getLocationData.hasNextInt()) break;
                int y = getLocationData.nextInt();

                // Consume the remaining newline
                if (getLocationData.hasNextLine()) {
                    getLocationData.nextLine();
                }

                locations.add(new Location(x, y, floor, directory, name));

            }
        } catch (FileNotFoundException roomDataNotFound) {
            System.err.println("Could not find room data file");
            roomDataNotFound.printStackTrace();
        }
    //https://stackoverflow.com/questions/4044726/how-to-set-a-timer-in-java
    }

    public static boolean newRound () {
        if (rounds <= GameSettings.getRounds()) {
            gameScreen.newRound(GameScreen.randomLocation());
            return true;
        }
        return false;
    }
    public static Map getMap() {
        return map;
    }
    public static void setMap() {
        map = new Map();
    }
    public static int getRounds () {
        return rounds;
    }
    public static void updateRounds () {
        rounds++;
    }

    public static void setGameScreen () {
        gameScreen = new GameScreen();
    }


    public static void updateCurrentLocation (Location currentLocation) {
        Main.currentLocation = currentLocation;
    }
    public static Location getCurrentLocation () {
        return currentLocation;
    }
}
