package Views;

import javax.swing.*;

public class farmerView {
    private static JLabel farmerNameLbl;
    private static JLabel farmerObjCoinLbl;

    public farmerView(){
        farmerNameLbl = new JLabel();
        farmerObjCoinLbl = new JLabel();


    }

    public void setFarmerObjCoinLbl(int farmerBalance){
        farmerObjCoinLbl.setText(String.valueOf(farmerBalance));
    }

    public static JLabel getFarmerObjCoinLbl(){
        return farmerObjCoinLbl;
    }

    public void setFarmerNameLbl(String farmerName){
        farmerNameLbl.setText(farmerName);
    }

    public static JLabel getFarmerNameLbl(){
        return farmerNameLbl;
    }
}


