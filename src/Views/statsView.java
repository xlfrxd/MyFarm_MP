package Views;

import javax.swing.*;
import java.awt.*;

public class statsView extends JPanel {
    static JLabel farmerNamePromptLbl;

    public JLabel balance = new JLabel("Bal:");
    public JLabel experience = new JLabel("Exp:");
    JLabel background = new JLabel();


    public statsView(){
        farmerNamePromptLbl = new JLabel("test");
        background.setIcon(new ImageIcon("src/Views/assets/Player Status.png"));
        background.setBounds(0,0, 575, 150);

        balance.setForeground(Color.BLACK);
        balance.setBounds(120,50,500,30);
        balance.setFont(new Font("Arial", Font.PLAIN,15));


        experience.setForeground(Color.BLACK);
        experience.setBounds(120,80,500,30);
        experience.setFont(new Font("Arial", Font.PLAIN,15));



        this.add(balance);
        this.add(experience);
        this.add(background);
    }

    public void setFarmerNamePromptLbl(String farmerName){
        farmerNamePromptLbl.setText(farmerName);
    }

    public static JLabel getFarmerNamePromptLbl(){
        return farmerNamePromptLbl;
    }
}


