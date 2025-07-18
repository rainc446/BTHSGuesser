import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class MainScreen extends JPanel {
    private BufferedImage pic;
    private final JButton startButton = new JButton(new CustomActions.StartGame("Start"));

    public MainScreen () {
        super();
        initalize();
    }

    public void initalize () {
        this.setSize(1920, 1080);
        this.setLayout(null);
        this.setBackground(Color.GREEN); //lowercase is mutable, capital final



        JLabel title = new JLabel(); //top title text
        title.setBounds(Constants.centerX-150, Constants.centerY - 250,400,100);
        title.setText("BTHSGuessr!");
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 50)); //https://www.delftstack.com/howto/java/setfont-java/
        title.setForeground(Color.BLUE);
        this.add(title);

        //puts logo on screen
        try {
            pic = ImageIO.read(new File("images/logo.png"));
            JLabel logo = new JLabel(new ImageIcon(pic)); //https://stackhowto.com/how-to-add-an-image-to-a-jpanel-in-java-swing/
            logo.setBounds(0, 10,200,200);
            logo.setVisible(true);
            this.add(logo);

        } catch (IOException noFile) {
        }
           //https://www.baeldung.com/java-images https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel

//        /*
//        * GUI SECTION
//        * First Button is the button to start the game
//        * */

        startButton.setBounds(Constants.centerX - 75, Constants.centerY - 100,150,50);
        startButton.setHorizontalTextPosition(SwingConstants.CENTER);

        this.add(startButton);
    }

    public JButton getStartButton () {
        return startButton;
    }

}
