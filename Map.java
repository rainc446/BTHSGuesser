import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Map {
    private int floor;
    private JLabel imageOfMap;
    private final int mapHeight = 323;
    private final int mapWidth = 621;
    private JFrame mapFrame;
    private JPanel mapPanel;

    private int xPos;
    private int yPos;

    public Map () {
        mapFrame = new JFrame();
        mapPanel = new JPanel();
        mapFrame.setSize(mapWidth, mapHeight);
        mapPanel.setSize(mapWidth, mapHeight);
        mapPanel.setLayout(null);

        JButton submitButton = new JButton(new CustomActions.SubmitAnswer("Submit"));//
        submitButton.setBounds(mapWidth-50, mapHeight-25, 50, 25);
        JMenu menu = new JMenu();
        //https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseListener.html
        mapPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xPos = mapPanel.getX();
                yPos = mapPanel.getY();

                System.out.println("X-Cord: " + xPos + "Y-Cord: " + yPos);
            }
        }); //https://stackoverflow.com/questions/2668718/java-mouselistener

        try {
            BufferedImage map = ImageIO.read(new File("images/Map.jpg"));
            imageOfMap = new JLabel(new ImageIcon(map));
            imageOfMap.setSize(mapWidth, mapHeight);
            mapPanel.add(imageOfMap);
            imageOfMap.setVisible(true);
        } catch (IOException noFile){ }
    }



    public void changeFloor (int newFloor) {
        floor = newFloor;
    }

    public void playGame (Location place) {

    } //call this

    public int calculateDistance(Location place) {
        return 0;
    }
    public JPanel getMapPanel () {
        return mapPanel;
    }
    public void makeVisible (boolean state) {
        mapFrame.setVisible(state);
        mapPanel.setVisible(state);
    }




}
