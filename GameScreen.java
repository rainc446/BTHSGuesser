import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameScreen extends JPanel {
    private Location currentLocation;
    private JPanel gamePanel;

    //**
    // Will just be a picture of the location have the map display in a different screen
    //
    // */

    //https://stackoverflow.com/questions/8333802/displaying-an-image-in-java-swing
    public GameScreen () {
        super();
        initalize();
    }

    public void initalize() {
        this.setSize(1920, 1080);
        this.setLayout(null);
        this.setBackground(Color.blue);
    }

    public void newRound (Location newLocation) {
        if (currentLocation != null) {
            currentLocation.getLocationPanel().setVisible(false);
        }
        currentLocation = newLocation;
        gamePanel = currentLocation.getLocationPanel();
        Main.mainFrame.add(gamePanel); //the new panel gets attached to the main frame
        currentLocation.getLocationPanel().setVisible(true);
        this.repaint();     // force redraw https://stackoverflow.com/questions/4392722/how-to-repaint-a-jpanel-after-have-drawn-on-it
    }
    public JPanel getPanel () {
        return gamePanel;
    }

    public void changePanel () {

    }
    public void makeVisible(boolean state) {
        this.setVisible(state);
    }
}
