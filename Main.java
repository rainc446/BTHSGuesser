import javax.swing.*;
import java.awt.*;

public class Main {
    //**
    //
    // */

    private static int width = 1200;
    private static int height = 800;

    public static void main(String[] args) {

        /**
         * Main Screen
         *
         * -first part sets up the window frame
         *
         * -JPanel is the display panel of the window
         * */
        JFrame frame = new JFrame();
        frame.setTitle("BTHS Guesser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(width,height); //1920, 1080 is 1080p
        frame.setVisible(true);

        JPanel panelOne = new JPanel();
        panelOne.setLayout(new FlowLayout((FlowLayout.CENTER)))
        panelOne.setBackground(Color.blue); //lowercase is mutable, capital final

    }

//    public ImageIcon getRandomPhoto() {
//        return
//    }
}
