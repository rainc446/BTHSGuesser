import javax.swing.*;
import java.awt.*;

public class Main {
    //**
    //
    // */


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
        frame.setSize(Constants.width, Constants.height); //1920, 1080 is 1080p


        MainScreen mainScreen = new MainScreen();
        frame.add(mainScreen);
//        frame.pack();

        frame.setVisible(true);

    }

//    public ImageIcon getRandomPhoto() {
//        return
//    }
}
