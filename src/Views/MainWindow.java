package Views;

import java.awt.*;
import javax.swing.*;

public class MainWindow {
    JFrame mainFrame;

    public MainWindow(){
        this.mainFrame = new JFrame("My Farmer Game");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout());
        this.mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen

        GamePanel gamePanel = new GamePanel();
        this.mainFrame.add(gamePanel);
        this.mainFrame.pack();

        this.mainFrame.setResizable(false);
        this.mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen

    }

    public void setWindowVisible(boolean bool){
        this.mainFrame.setVisible(bool);
    }

    public void initializeGreetingElements(){
        this.mainFrame.add(farmerView.getFarmerNamePromptLbl());
    }


}
