import javax.swing.*;
import java.awt.*;


public class MainScreen extends JPanel {


    public MainScreen () {
        super();
        initalize();
    }

    public void initalize () {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //sets the gui to a box layout https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
        this.setBackground(Color.blue); //lowercase is mutable, capital final
        add(Box.createVerticalGlue());

        /*
        * GUI SECTION
        * First Button is the button to start the game
        *
        * */
        JButton startButton = new JButton("Start");
        startButton.setSize(200,200); // set size
        startButton.setVerticalTextPosition(AbstractButton.CENTER); //centers text
        //sets button to center horizontally and vertically
        //startButton.setAlignmentY(Component.CENTER_ALIGNMENT);
//        startButton.setMaximumSize(new Dimension(100,50));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton settingButton = new JButton("Settings");
        settingButton.setSize(200,200); // set size
        //settingButton.setVerticalTextPosition(AbstractButton.CENTER); //centers text
        //settingButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        settingButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(startButton);
        this.add(settingButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(Box.createVerticalGlue());

    }

    public boolean getButtonNum () {
        return false;
    }

}
