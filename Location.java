import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
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
    private BufferedImage imageOfLocation;
    private String directory;

    public Location (int x, int y, int floor, String imageDirectory, String name) {
        xCord = x;
        yCord = y;
        this.floor = floor;
        roomNum = name;
        directory = imageDirectory;
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

    public String getImageDirectory() {
        return directory;
    }

    public String toString() {
        return ("file path"+ directory+ "\n" +
               "Room Name:"+ roomNum + "\n" +
               "Floor:"+ floor + "\n" +
               "X-Cord:" + xCord +"\n" +
               "Y-Cord:"+ yCord +"\n");
    }
}
