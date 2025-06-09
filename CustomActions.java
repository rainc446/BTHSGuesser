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

                int locationsSize = Main.locations.size();
                if (locationsSize > 0) {
                    int randomIndex = (int) (Math.random() * locationsSize);
                    Location randomLocation = Main.locations.remove(randomIndex);
                    Main.updateCurrentLocation(randomLocation);
                    Main.gameScreen.newRound(randomLocation);
                    JPanel firstPanel = Main.gameScreen.getPanel();
                    Main.changeScreen(firstPanel);
                    Main.gameScreen.getPanel().setVisible(true);
                    Main.gameScreen.makeVisible(true);
                }
            } else {
                this.setEnabled(false);
            }
        }
    }


    public static class SubmitAnswer extends AbstractAction{
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
                System.out.print("Score" + Main.getRounds() + ":");
                System.out.println(score);
                Main.updateRounds();
                Main.firstRound = false;
                System.out.println(Main.getCurrentLocation());
            }
            else if (Main.newRound()) {
                System.out.print("Score" + Main.getRounds() + ":");
                score = Map.calculateScore();
                System.out.println(Map.calculateScore());
                Main.updateRounds();
                System.out.println(Main.getCurrentLocation());
            }
            else {
                this.setEnabled(false);
                int sum = 0;
                for (int i = 0; i < GameSettings.getRounds(); i++) {
                    sum += Main.scores.get(i);
                }
                System.out.print("Your average score was: ");
                System.out.println(sum / GameSettings.getRounds());
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

//    public static class MousePress extends AbastractAction {
}
