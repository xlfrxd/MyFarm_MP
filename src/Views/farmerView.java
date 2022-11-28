package Views;

import javax.swing.*;

public class farmerView {
    static JLabel farmerNamePromptLbl;

    public farmerView(){
        farmerNamePromptLbl = new JLabel("test");
    }

    public void setFarmerNamePromptLbl(String farmerName){
        farmerNamePromptLbl.setText(farmerName);
    }

    public static JLabel getFarmerNamePromptLbl(){
        return farmerNamePromptLbl;
    }
}


