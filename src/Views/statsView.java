package Views;

import javax.swing.*;
import java.awt.*;

public class statsView extends JPanel {
    static JLabel farmerNamePromptLbl;
    public JLabel farmerType = new JLabel("Farmer");
    public JLabel balance = new JLabel("Balance:");
    public JLabel experience = new JLabel("Experience:");

    public JLabel level = new JLabel("Level: 0");
    public JLabel planted = new JLabel("Planted: ");
    public JLabel harvested= new JLabel("Harvested: ");
    JLabel background = new JLabel();


    public statsView(){
        background.setIcon(new ImageIcon("src/Views/assets/Player Status.png"));
        background.setBounds(0,0, 575, 150);

        balance.setForeground(Color.WHITE);
        balance.setBounds(105,55,200,30);
        balance.setFont(new Font("Helvetica", Font.BOLD,15));


        experience.setForeground(Color.WHITE);
        experience.setBounds(105,90,300,30);
        experience.setFont(new Font("Helvetica", Font.BOLD,15));

        level.setForeground(Color.WHITE);
        level.setBounds(255,55,300,30);
        level.setFont(new Font("Helvetica", Font.BOLD,15));

        planted.setForeground(Color.WHITE);
        planted.setBounds(360,55,300,30);
        planted.setFont(new Font("Helvetica", Font.BOLD,15));

        harvested.setForeground(Color.WHITE);
        harvested.setBounds(365,85,300,30);
        harvested.setFont(new Font("Helvetica", Font.BOLD,15));

        farmerType.setForeground(Color.WHITE);
        farmerType.setBounds(80,10,300,30);
        farmerType.setFont(new Font("Helvetica", Font.BOLD,15));

        this.add(balance);
        this.add(experience);
        this.add(level);
        this.add(planted);
        this.add(farmerType);
        this.add(harvested);
        this.add(background);
    }

    public void setFarmerNamePromptLbl(String farmerName){
        farmerNamePromptLbl.setText(farmerName);
    }

    public static JLabel getFarmerNamePromptLbl(){
        return farmerNamePromptLbl;
    }
}


