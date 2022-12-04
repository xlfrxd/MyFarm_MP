package Views;

import javax.swing.*;

public class statsView extends JPanel {
    static JLabel farmerNamePromptLbl;

    public statsView(){
        farmerNamePromptLbl = new JLabel("test");
    }

    public void setFarmerNamePromptLbl(String farmerName){
        farmerNamePromptLbl.setText(farmerName);
    }

    public static JLabel getFarmerNamePromptLbl(){
        return farmerNamePromptLbl;
    }
}


