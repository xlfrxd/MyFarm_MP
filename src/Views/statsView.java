package Views;

import javax.swing.*;

public class statsView extends JPanel {
    static JLabel farmerNamePromptLbl;
    JLabel background = new JLabel();


    public statsView(){
        farmerNamePromptLbl = new JLabel("test");
        background.setIcon(new ImageIcon("src/Views/assets/Player Status.png"));
        background.setBounds(0,0, 575, 150);
        this.add(background);
    }

    public void setFarmerNamePromptLbl(String farmerName){
        farmerNamePromptLbl.setText(farmerName);
    }

    public static JLabel getFarmerNamePromptLbl(){
        return farmerNamePromptLbl;
    }
}


