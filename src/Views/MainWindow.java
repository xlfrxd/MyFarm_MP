package Views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MainWindow {
    JFrame mainFrame;

    public MainWindow(){
        this.mainFrame = new JFrame("My Simple GUI");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new GridBagLayout());
        this.mainFrame.setSize(1000, 800);
        this.mainFrame.setResizable(false);
        this.mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen
        this.mainFrame.setBackground(Color.red);


        GridBagConstraints gbc = new GridBagConstraints();

        JPanel space = new JPanel();
        space.setBackground(Color.black);
        JPanel space2 = new JPanel();
        space2.setBackground(Color.red);
        JPanel space3 = new JPanel();
        space3.setBackground(Color.green);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.mainFrame.add(space2,gbc); // RED

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.mainFrame.add(new JLabel("FarmerName"),gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.mainFrame.add(space,gbc); // BLACK

        gbc.gridwidth=0;


        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.mainFrame.add(space3,gbc); // GREEN

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth=2;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        GamePanel gp = new GamePanel();
        this.mainFrame.add(gp,gbc);





        //this.mainFrame.add(gp, gbc);




    }

    public void setWindowVisible(boolean bool){
        this.mainFrame.setVisible(bool);
    }

    public void initializeGreetingElements(){
        this.mainFrame.add(farmerView.getFarmerNameLbl());


    }

}
