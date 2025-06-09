import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameScreen extends JPanel {
    private Location currentLocation;
    private BufferedImage picOfLocation;

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
        this.removeAll();
        this.setLayout(null);
        this.setSize(1920,1080);
        this.setVisible(false);
        currentLocation = newLocation;
        JLabel image;
        try {
            picOfLocation = ImageIO.read(new File(currentLocation.getImageDirectory()));
            image = new JLabel(new ImageIcon(picOfLocation));
            image.setBounds(0,0,1920,1080);
            this.add(image);
            image.setVisible(true);

        } catch (IOException noLocationImage) {}
        Main.changeScreen(this); //the new panel gets attached to the main frame
        this.revalidate();
        this.repaint(); // force redraw https://stackoverflow.com/questions/4392722/how-to-repaint-a-jpanel-after-have-drawn-on-it
    }
    public JPanel getPanel () {
        return this;
    }

    public void makeVisible(boolean state) {
        this.setVisible(state);
    }
}
