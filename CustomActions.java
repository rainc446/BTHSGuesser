import javax.swing.*;
import java.awt.event.ActionEvent;



public class CustomActions {
    public static class StartGame extends AbstractAction {
        public StartGame (String text) {
            super(text);
            putValue(Action.SHORT_DESCRIPTION, "Start the game"); //https://stackoverflow.com/questions/64715225/what-does-putvaluemnemonic-key-keyevent-vk-s-do
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Started"); //debug
            if (this.enabled) {
                this.setEnabled(false);
                Main.changeScreen(Main.gameScreen);

                Main.setMap(new Map());
                Main.getMap().makeVisible(true);
                Main.gameScreen.makeVisible(true);
                Main.playGame();
            }
            else {
                this.setEnabled(true);
            }
        }
    }


    public static class SubmitAnswer extends AbstractAction{
        private static int round = 0;
        public SubmitAnswer(String text) {
            super(text);
            putValue(Action.SHORT_DESCRIPTION, "Submit");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            round++;
            System.out.println("Submitted Answer");
            System.out.print("Score" + round + ":");
            System.out.println(Map.calculateScore());
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
