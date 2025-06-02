import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Map {
    private int floor;
    private ImageIcon imageOfMap;
    private final int mapHeight = 323;
    private final int mapWidth = 621;
    private JFrame mapFrame;
    private JPanel mapPanel;

    private int xPos;
    private int yPos;

    public Map () {
        mapFrame = new JFrame();
        mapPanel = new JPanel();
        mapPanel.setSize(mapWidth, mapHeight);

        JButton submitButton = new JButton(new CustomActions.SubmitAnswer("Submit"));//
        submitButton.setBounds(mapWidth, mapHeight, 50, 25);
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
    }



    public void changeFloor (int newFloor) {
        floor = newFloor;
    }

    public void playGame (Location place) {

    } //call this

    public int calculateDistance(Location place) {

    }
    public JPanel getMapPanel () {
        return mapPanel;
    }




}
