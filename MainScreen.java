import javax.swing.*;
import java.awt.*;


public class MainScreen extends JPanel {


    public MainScreen () {
        super();
        initalize();
    }

    public void initalize () {
        this.setLayout(new FlowLayout((FlowLayout.CENTER)));
        this.setBackground(Color.blue); //lowercase is mutable, capital final

        /*
        * GUI SECTION
        * First Button is the button to start the game
        *
        * */
        JButton startButton = new JButton("Start");
        startButton.setSize(100,50); // set size
        startButton.setVerticalTextPosition(AbstractButton.CENTER); //centers text
        //sets button to center horizontally and vertically
        startButton.setVerticalAlignment(Constants.centerY - 120);
        startButton.setHorizontalAlignment(Constants.centerX);


        JButton settingButton = new JButton("Settings");
        startButton.setSize(100,50); // set size
        startButton.setVerticalTextPosition(AbstractButton.CENTER); //centers text
        startButton.setHorizontalAlignment(Constants.centerX);
        startButton.setVerticalAlignment(Constants.centerY);


        this.add(startButton);
        this.add(settingButton);
    }

    public boolean getButtonNum () {
        return false;
    }

}
