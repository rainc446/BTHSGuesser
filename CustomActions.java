import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class CustomActions {
    public static class StartGame extends AbstractAction {
        public StartGame (String text) {
            super(text);
            putValue(Action.SHORT_DESCRIPTION, "Start the game"); //https://stackoverflow.com/questions/64715225/what-does-putvaluemnemonic-key-keyevent-vk-s-do
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Started");
            if (this.enabled) {
                this.setEnabled(true);

                Main.setMap();
                Main.getMap().makeVisible(true);
                Main.setupLocations();
                Main.setGameScreen();

                if (Main.locations.size() > 0) {
                    Location randomLocation = GameScreen.randomLocation();
                    Main.gameScreen.newRound(randomLocation);
                    Main.mainFrame.dispose();
                }
            } else {
                this.setEnabled(false);
            }
            Map.changeFloor(0);
        }
    }


    public static class SubmitAnswer extends AbstractAction{
        //https://stackoverflow.com/questions/12396066/how-to-get-location-of-a-mouse-click-relative-to-a-swing-window, David Kroukamp
        public SubmitAnswer(String text) {
            super(text);
            putValue(Action.SHORT_DESCRIPTION, "Submit");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Submitted Answer");
            int score;
            if (Main.firstRound) {
                score = Map.calculateScore();
                Main.scores.add(score);
                System.out.print("Score " + Main.getRounds() + ":");
                System.out.println(score);
                Main.updateRounds();
                Main.firstRound = false;
                System.out.println(Main.getCurrentLocation());

                Main.gameScreen.newRound(GameScreen.randomLocation());
                score = Map.calculateScore();
                Main.scores.add(score);

            }
            else if (Main.getRounds() < GameSettings.getRounds()) {
                System.out.print("Score " + Main.getRounds() + ":");
                Main.gameScreen.newRound(GameScreen.randomLocation());
                Main.updateRounds();
                score = Map.calculateScore();
                Main.scores.add(score);
                System.out.println(Map.calculateScore());
                System.out.println(Main.getCurrentLocation()); //prints location info
            }
            else {
                score = Map.calculateScore();
                System.out.println(Map.calculateScore());
                Main.scores.add(score);
                int sum = 0;
                for (int i = 0; i < GameSettings.getRounds(); i++) {
                    sum += Main.scores.get(i);
                }
                System.out.print("Your average score was: ");
                System.out.println(sum / GameSettings.getRounds());
                this.setEnabled(false);
                //closes map and gameScreen
                Main.gameScreen.getGameFrame().dispose();
                Main.getMap().getMapFrame().dispose();
            }


        }
    }

    public static class IncreaseFloor extends AbstractAction {
        public IncreaseFloor (String text) {
            super(text);
            putValue(Action.SHORT_DESCRIPTION, "Up");
        }
        @Override
        public void actionPerformed (ActionEvent e) {
            if (Map.getFloor() < 8) {
                Map.changeFloor(1);
                this.setEnabled(true);
            }
            else{
                this.setEnabled(false);
            }


        }
    }

    public static class DecreaseFloor extends AbstractAction {
        public DecreaseFloor (String text) {
            super(text);
            putValue(Action.SHORT_DESCRIPTION, "Down");
        }
        @Override
        public void actionPerformed (ActionEvent e) {
            if (Map.getFloor() > 1) {
                Map.changeFloor(-1);
                this.setEnabled(true);
            }
            else{
                this.setEnabled(false);
            }
        }
    }
}
