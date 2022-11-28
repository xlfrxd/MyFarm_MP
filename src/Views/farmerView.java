package Views;

import javax.swing.*;

public class farmerView {
    private static JLabel farmerNameLbl;
    private static JLabel farmerObjCoinLbl;
    private static JLabel farmerExpLbl;

    public farmerView(){
        farmerNameLbl = new JLabel();
        farmerObjCoinLbl = new JLabel();
        farmerExpLbl = new JLabel();

    }


    public void setFarmerExp(double farmerExp){
        farmerExpLbl.setText(String.valueOf(farmerExp));
    }
    public void setFarmerObjCoinLbl(int farmerBalance){
        farmerObjCoinLbl.setText(String.valueOf(farmerBalance));
    }

    public void setFarmerNameLbl(String farmerName){
        farmerNameLbl.setText(farmerName);
    }

    public static JLabel getFarmerExpLbl(){
        return farmerExpLbl;
    }
    public static JLabel getFarmerObjCoinLbl(){
        return farmerObjCoinLbl;
    }

    public static JLabel getFarmerNameLbl(){
        return farmerNameLbl;
    }
}


