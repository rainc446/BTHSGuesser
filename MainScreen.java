import javax.swing.*;
import java.awt.*;


public class MainScreen extends JPanel {


    public MainScreen () {
        super();
        initalize();
    }

    public void initalize () {

        //https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
        //card layout for settings
        this.setSize(1920, 1080);
        this.setLayout(new GridLayout(2, 1, 25, 25)); //sets the gui to a box layout https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
        this.setBackground(Color.blue); //lowercase is mutable, capital final
        add(Box.createVerticalGlue());
//
//        /*
//        * GUI SECTION
//        * First Button is the button to start the game
//        *Second Button opens a setting menu with to change GameSettings variables with a card layout
//        * */
        JButton startButton = new JButton("Start");
        startButton.setSize(100,100);

        JButton settingButton = new JButton("Settings");
        startButton.setSize(100,100);

        this.add(startButton);
        this.add(settingButton);

//        add(Box.createVerticalGlue());


//        https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html
    }

    public boolean getButtonNum () {
        return false;
    }

}
