import javax.swing.ImageIcon;

public class Location {
    //**
    // Room Info
    // */

    private String roomNum;
    private int floor;
    private int xCord;
    private int yCord;
    private ImageIcon photo;

    private static int numOfRooms;


    public Location (int x, int y, int floor, ImageIcon image) {
        photo = image;
        this.floor = floor;
        xCord = x;
        yCord = y;
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

    public ImageIcon getPhoto() {
        return photo;
    }

}
