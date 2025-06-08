import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Location {
    //**
    // Room Info
    // */

    private String roomNum;
    private final int floor;
    private final int xCord;
    private final int yCord;
    private JLabel photo;
    private JPanel locationPanel;
    private final String name;

    private static int numOfRooms;


    public Location (int x, int y, int floor, String imageDirectory, String name) {
        xCord = x;
        yCord = y;
        this.floor = floor;
        this.name = name;
        try {
            ImageIcon imageOfLocation = new ImageIcon(ImageIO.read(new File(imageDirectory)));
            photo = new JLabel(imageOfLocation);
        } catch (IOException noLocationImage) {}
    }

    public int getXPos () {
        return xCord;
    }

    public int getYPos () {
        return yCord;
    }

    public int getFloor () {
        return floor;
    }

    public String getName () {
        return name;
    }

    public JLabel getPhoto() {
        return photo;
    }

    public JPanel getLocationPanel () {
        //creates the JPanel to
        locationPanel = new JPanel();
        locationPanel.setLayout(null);
        locationPanel.setBounds(0,0,1920,1080);
        locationPanel.add(photo);
        photo.setVisible(true);
        return locationPanel;
    }
}
