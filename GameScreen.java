import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameScreen extends JPanel {
    private Location currentLocation;

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
//        this.add();

        Map buildingMap = new Map();

//        while (roundsPlayed < GameSettings.)

    }



}
