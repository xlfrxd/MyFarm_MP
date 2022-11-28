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







    }

    public void setWindowVisible(boolean bool){
        this.mainFrame.setVisible(bool);
    }

    public void initializeGreetingElements(){
        JPanel space = new JPanel();
        space.setBackground(Color.black);
        JPanel space2 = new JPanel();
        space2.setBackground(Color.red);
        JPanel space3 = new JPanel();
        space3.setBackground(Color.green);



        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);
        this.mainFrame.add(space,gbc); // TOP BORDER

        gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(5,5,5,5);
        this.mainFrame.add(space2,gbc); // LEFT BORDER

        gbc = new GridBagConstraints();

        gbc.gridx = 1;
        //gbc.gridy = 1;
        gbc.gridwidth=2;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);
        GamePanel gp = new GamePanel();
        this.mainFrame.add(gp,gbc); // MAIN GAME PANEL

        gbc = new GridBagConstraints();

        space3.setSize(300,0);

        gbc.gridx = 3;
        //gbc.gridy = 1;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(5,5,5,5);
        this.mainFrame.add(space3,gbc); // RIGHT BORDER

        gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(5,5,5,5);
        this.mainFrame.add(farmerView.getFarmerNameLbl(),gbc);

        gbc = new GridBagConstraints();

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.insets = new Insets(5,5,5,5);
        this.mainFrame.add(new JLabel("SeedStore"),gbc);

        this.mainFrame.pack();



    }

}
