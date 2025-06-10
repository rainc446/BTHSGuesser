import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameScreen {
    private Location currentLocation;
    private BufferedImage picOfLocation;
    private JFrame gameFrame;
    private JPanel gamePanel;
    private JLabel image;

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
        gameFrame = new JFrame();
        gamePanel = new JPanel();
        gameFrame.setSize(1920,1080);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setTitle("Locations");
        gameFrame.add(gamePanel);
    }

    public void newRound (Location newLocation) {
//        gameFrame.dispose();
//        initalize();
        gameFrame.remove(gamePanel);
        gamePanel = new JPanel();
        gamePanel.setSize(1920, 1080);
        gamePanel.setLayout(null);
        currentLocation = newLocation;
        try {
            picOfLocation = ImageIO.read(new File(currentLocation.getImageDirectory()));
            image = new JLabel(new ImageIcon(picOfLocation));
            image.setBounds(0,0,1920,1080);
            gamePanel.add(image);
            image.setVisible(true);

        }             catch (IOException e) {
            e.printStackTrace();
            JLabel errorLabel = new JLabel("Failed to load image");
            gamePanel.add(errorLabel, BorderLayout.CENTER);
        }
        gameFrame.add(gamePanel);
        gamePanel.setVisible(true);
        gamePanel.revalidate();
        gamePanel.repaint(); // force redraw https://stackoverflow.com/questions/4392722/how-to-repaint-a-jpanel-after-have-drawn-on-it
    }
    public JPanel getPanel () {
        return gamePanel;
    }
    public JFrame getGameFrame () {
        return gameFrame;
    }
    public static Location randomLocation () {
        int randomIndex = (int) (Math.random() * Main.locations.size());
        Location randomLocation = Main.locations.remove(randomIndex);
        Main.updateCurrentLocation(randomLocation);
        return randomLocation;
    }
}
