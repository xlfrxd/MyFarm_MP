package Views;

import java.awt.*;
import javax.swing.*;

public class MainWindow {
    JFrame mainFrame;

    public MainWindow(){
        this.mainFrame = new JFrame("My Farmer Game");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< Updated upstream
        this.mainFrame.setLayout(new FlowLayout());
        this.mainFrame.setSize(1000, 600);
        this.mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen
=======
        //this.mainFrame.setLayout(new GridBagLayout());
        this.mainFrame.setSize(1000, 800);
        this.mainFrame.setResizable(false);
        this.mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen
        this.mainFrame.setBackground(Color.black);






>>>>>>> Stashed changes

    }

    public void setWindowVisible(boolean bool){
        this.mainFrame.setVisible(bool);
    }

    public void initializeGreetingElements(){
        this.mainFrame.add(farmerView.getFarmerNamePromptLbl());
    }

}
