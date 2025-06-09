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
    private String directory;

    public Location (int x, int y, int floor, String imageDirectory, String name) {
        xCord = x;
        yCord = y;
        this.floor = floor;
        roomNum = name;
        directory = imageDirectory;
        try {
            ImageIcon imageOfLocation = new ImageIcon(ImageIO.read(new File(imageDirectory)));
            photo = new JLabel(imageOfLocation);
            photo.setBounds(0,0,1920,1080);
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
        return roomNum;
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
    public String toString() {
        return ("file path"+ directory+ "\n" +
               "Room Name:"+ roomNum + "\n" +
               "Floor:"+ floor + "\n" +
               "X-Cord:" + xCord +"\n" +
               "Y-Cord:"+ yCord +"\n");
    }
}
