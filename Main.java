import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Main{
    public static JFrame mainFrame;
    public static JPanel currentPanel;
    public static final MainScreen mainScreen = new MainScreen();
    public static final GameScreen gameScreen = new GameScreen();
    public static int numOfRounds = 3;
    public static double timeLimit = 15.0;
    private static boolean finishedSettings = false;
    private static int totalNumberOfRooms = 5;
    private static Location currentLocation;
    private static Map map;

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

    public static void changeScreen(JPanel panel) {
        mainFrame.setVisible(false);
        mainFrame.removeAll();
        currentPanel = panel;
        mainFrame.add(panel);
        mainFrame.setVisible(true);
    }

//    public static void playGame () {
//        int rounds = 0;
//        ArrayList<Location> locations = new ArrayList<Location>();
//        try (Scanner getLocationData = new Scanner(new File("images/locations/roomInfo"))) {
//            while (getLocationData.hasNextLine()) {
//                for (int i = 0; i < 5; i ++) {
//                    //skips to the first line with location
//                    getLocationData.nextLine();
//                }
//
//                for (int i = 0; i < totalNumberOfRooms; i ++) { //creates the rooms
//                    String directory = getLocationData.nextLine();
//                    String name = getLocationData.nextLine();
//                    int floor = getLocationData.nextInt();
//                    int x = Integer.parseInt(getLocationData.nextLine());
//                    int y = Integer.parseInt(getLocationData.nextLine());
//                    locations.add(new Location(x,y,floor,directory,name));
//                    getLocationData.nextLine();
//                }
//            }
//        } catch (FileNotFoundException roomDataNotFound) {}
//
//        //https://stackoverflow.com/questions/4044726/how-to-set-a-timer-in-java
//        while (rounds < numOfRounds) {
//            currentLocation = locations.get(rounds);
//            gameScreen.newRound(currentLocation);
//            rounds++;
//        }
//    }
public static void playGame() {
    int rounds = 0;
    ArrayList<Location> locations = new ArrayList<Location>();

    try (Scanner getLocationData = new Scanner(new File("images/locations/roomInfo"))) {
        // Skip the header lines (5 lines)
        for (int i = 0; i < 5; i++) {
            if (getLocationData.hasNextLine()) {
                getLocationData.nextLine();
            }
        }

        // Read each room's data
        while (getLocationData.hasNextLine()) {
            String directory = getLocationData.nextLine().trim();

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

            // Skip empty lines between entries
            while (getLocationData.hasNextLine() && getLocationData.nextLine().trim().isEmpty()) {
                // Just consuming empty lines
            }
            if (getLocationData.hasNextLine()) {
                // Move back to the last read line
                getLocationData.reset();
            }
        }
    } catch (FileNotFoundException roomDataNotFound) {
        System.err.println("Error: Could not find room data file");
        roomDataNotFound.printStackTrace();
        return;
    }

    if (locations.isEmpty()) {
        System.err.println("Error: No locations loaded");
        return;
    }

    // Rest of your game loop
    while (rounds < numOfRounds && rounds < locations.size()) {
        currentLocation = locations.get(rounds);
        gameScreen.newRound(currentLocation);
        rounds++;
    }
}

    public static Location getCurrentLocation () {
        return currentLocation;
    }
    public static Map getMap() {
        return map;
    }
    public static void setMap(Map newMap) {
        map = newMap;
    }
}
