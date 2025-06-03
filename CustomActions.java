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

                Map map = new Map();
                map.makeVisible(true);
            }
            else {
                this.setEnabled(true);
            }
        }

    }

    public static class SettingsAction extends AbstractAction {
        public SettingsAction(String text) {
            super(text);
            putValue(Action.SHORT_DESCRIPTION, "Open settings");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Settings opened"); //debug
            if (this.enabled) {
                this.setEnabled(false);
            }
            else {
                this.setEnabled(true);
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
            Map.calculateDistance(Main.getLocation());
        }

    }

//    public static class MousePress extends AbastractAction {
}
