package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Farmer {
    // Superclass
    private String farmerName;
    private double farmerObjectCoin;
    private double farmerExp;
    private int farmerLevel;

    public FarmerType getFarmerType() {
        return farmerType;
    }

    public void setFarmerType(FarmerType farmerType) {
        this.farmerType = farmerType;
    }

    private FarmerType farmerType;
    private List<Tool> farmerTools;
    private Registration registration;

    private List<FarmerType> farmerTypes;

    public Farmer(String farmerName){
        this.farmerName = farmerName;
        this.farmerExp = 0;
        this.farmerLevel = 0;
        this.farmerObjectCoin = 100;

        setFarmerTools(new ArrayList<Tool>(Arrays.asList(
                new Tool("Plow", 0, 0.5),
                new Tool("Watering Can", 0, 0.5),
                new Tool("Fertilizer", 10, 4),
                new Tool("Pickaxe", 50,15),
                new Tool("Shovel",7,2)
        )));

        setFarmerTypes(new ArrayList<FarmerType>(Arrays.asList(
                new FarmerType("Farmer",0,0,0,0,0,0),
                new FarmerType("Registered Farmer",5,1,1,0,0,200),
                new FarmerType("Distinguished Farmer", 10,2,2,1,0,300),
                new FarmerType("Legendary Farmer",15,4,3,2,1,400)
        )));

        setFarmerType(this.getFarmerTypes().get(0)); // Sets farmerType to unregistered by default
    }

    public List<FarmerType> getFarmerTypes() {
        return farmerTypes;
    }

    public void setFarmerTypes(List<FarmerType> farmerTypes) {
        this.farmerTypes = farmerTypes;
    }

    public List<Tool> getFarmerTools() {
        return farmerTools;
    }

    public void setFarmerTools(List<Tool> farmerTools) {
        this.farmerTools = farmerTools;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public double getFarmerObjectCoin() {
        return farmerObjectCoin;
    }

    public void setFarmerObjectCoin(double farmerObjectCoin) {
        this.farmerObjectCoin = farmerObjectCoin;
    }

    public double getFarmerExp() {
        return farmerExp;
    }

    public void setFarmerExp(double farmerExp) {
        this.farmerExp = farmerExp;
    }

    public int getFarmerLevel() {
        return farmerLevel;
    }

    public void setFarmerLevel(int farmerLevel) { this.farmerLevel = farmerLevel;}

    public Models.Registration getRegistration() {
        return registration;
    }


    public void updateLevel(int exp){
        /** This function updates the farmer's level based on its experience
         * @param exp               Famer's current exp count
         * @param level	            Models.Farmer's current level
         */

        if(exp%100==0){ // If experience is a multiple of 100
            this.setFarmerLevel(this.getFarmerLevel()+1); // Increase the level by 1
        }
    }

    public void buySeed(double seedCost){ // debatable to put this func into main
        /** This function charges the object coin balance of the Models.Farmer when purchasing seeds
         * @param seedCost	            Seed's cost to purchase
         * @param balance               Models.Farmer's object coin balance
         */

        this.setFarmerObjectCoin(this.getFarmerObjectCoin()-seedCost);

    }

    public void showToolList(){
        /** This function displays all the tools available for the farmer
         */
        for (Tool tool: this.farmerTools
             ) {
            System.out.println("Models.Tool Name: " + tool.getToolName() + "\nCost of usage: "  + tool.getToolCost() + "\nExperience Gain:" + tool.getToolExp() + "\n");
        }
    }
}
