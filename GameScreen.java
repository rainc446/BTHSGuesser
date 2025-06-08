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
    }

    public void newRound (Location newLocation) {
        if (currentLocation != null) {
            currentLocation.getLocationPanel().setVisible(false);
        }
        currentLocation = newLocation;
        this.removeAll();
        gamePanel = currentLocation.getLocationPanel();
        this.add(gamePanel);
        currentLocation.getLocationPanel().setVisible(true);
    }
    public JPanel getPanel () {
        return gamePanel;
    }
    public void makeVisible(boolean state) {
        this.setVisible(state);
    }
}
