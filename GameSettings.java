import java.util.Scanner;


public class GameSettings {
    private static int numRounds;
    private static double timeLimitPerRound;

    public static boolean changeSettings (String difficulty) {
        if (difficulty.equals("Easy")) {
            numRounds = 3;
            timeLimitPerRound = 30;
            return true;
        }
        else if (difficulty.equals("Medium")) {
            numRounds = 5;
            timeLimitPerRound = 20;
            return true;
        }
        else if (difficulty.equals("Hard")) {
            numRounds = 7;
            timeLimitPerRound = 15;
            return true;
        }
        return false;
    }
    public static int getRounds () {
        return numRounds;
    }


}
