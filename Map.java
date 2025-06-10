import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Map {
    private static int floor = 1;
    private JLabel imageOfMap;
    private final int mapHeight = 323;
    private final int mapWidth = 621;
    private JFrame mapFrame;
    private JPanel mapPanel;
    private JLabel floorText;

    private static int xPos;
    private static int yPos;

    public Map () {
        mapFrame = new JFrame();
        mapPanel = new JPanel();
        mapFrame.setSize(640, 360);
        mapPanel.setSize(mapWidth, mapHeight);
        mapPanel.setLayout(null);
        mapFrame.setResizable(false);

        mapFrame.add(mapPanel);
        JButton submitButton = new JButton(new CustomActions.SubmitAnswer("Submit"));
        submitButton.setBounds(mapWidth-200, mapHeight-30, 60, 25);
        submitButton.setFont(new Font("Arial", Font.PLAIN, 8));
        submitButton.setForeground(Color.BLUE);
        mapPanel.add(submitButton);
        submitButton.setVisible(true);


        JButton upFloor = new JButton(new CustomActions.IncreaseFloor("Up"));
        upFloor.setBounds(mapWidth-120, mapHeight-30, 60, 25);
        upFloor.setFont(new Font("Arial", Font.PLAIN, 8));
        upFloor.setForeground(Color.BLUE);
        mapPanel.add(upFloor);
        upFloor.setVisible(true);

        JButton downFloor = new JButton(new CustomActions.DecreaseFloor("Down"));
        downFloor.setBounds(mapWidth-60, mapHeight-30, 60, 25);
        downFloor.setFont(new Font("Arial", Font.PLAIN, 8));
        downFloor.setForeground(Color.BLUE);
        mapPanel.add(downFloor);
        downFloor.setVisible(true);

        //https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseListener.html
        //https://stackoverflow.com/questions/2668718/java-mouselistener
        mapPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xPos = e.getX();
                yPos = e.getY();

                System.out.println("X-Cord: " + xPos + " Y-Cord: " + yPos);
            }
        });

        try { //displays the map
            BufferedImage map = ImageIO.read(new File("images/Map.jpg"));
            imageOfMap = new JLabel(new ImageIcon(map));
            imageOfMap.setBounds(0,0,mapWidth,mapHeight);
            imageOfMap.setVisible(true);
            mapPanel.add(imageOfMap);
        } catch (IOException noFile){ }

    }

    public static void changeFloor (int newFloor) {
        floor += newFloor;
        if (floor < 1) {
            floor = 0;
        }
        else if (floor > 8) {
            floor = 8;
        }
        System.out.println("Current Floor: " + floor);
    }

    public static int calculateDistance(Location place) {

        // c = sqrt of (x2-x1)^2 + (y2-y1)^2 , take the line between the two points
        int x1 = place.getXPos();
        int y1 = place.getYPos();
        int x2 = xPos;
        int y2 = yPos;
        double xDif = Math.pow((x2 - x1),2);
        double yDif = Math.pow((y2 - y1),2);
        return (int)  Math.sqrt(xDif + yDif);
    }
    public void makeVisible (boolean state) {
        mapFrame.setVisible(state);
        mapPanel.setVisible(state);
    }

    public static int calculateScore () {
        int score;
        int distance = calculateDistance(Main.getCurrentLocation());
        int correctFloor = Main.getCurrentLocation().getFloor();
        score = 2500 - ((Math.abs(floor-correctFloor) * 100) + distance); //maximum score of 2500, each floor incorrect is -100
        return score;
    }

    public static int getFloor() {
        return floor;
    }

    public JFrame getMapFrame() {
        return mapFrame;
    }
}
