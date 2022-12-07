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
    private FarmerType farmerType;
    private List<Tool> farmerTools;
    private Registration registration;

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

    public double isFarmerExp() {
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


    //public void registerFarmerType(String name, double exp, int balance, FarmerType type, List<Crop> seedList, List<Registration> registrationList){
        /** This function allows the farmer to register to gain perks and experience
         * @param //name	            Models.Farmer's name
         * @param //exp               Models.Farmer's experience points
         * @param //balance           Models.Farmer's object coins
         * @param //type              Models.Farmer's farmer type
         */
/*
        registering for "Registered Farmer"
       if(registration.getType().equals("Farmer")) {

            //fail if level condition is not met
           if(farmerLevel < registrationList.get(1).getLevelNeeded())
                return new Message (false, "Must reach level " + registrationList.get(1).getLevelNeeded());
                //fail if there are insufficient funds
            else if(farmerObjectCoin < registrationList.get(1).getRegistrationFee())
                //return new Message (false, "Insufficient Funds");
                //success
            else {
                this.registration = registrationList.get(1);
                registration.increaseEarnings(seedList);
                registration.reduceCost(seedList);
                registration.increaseWaterBonusLimit(seedList);
                registration.increaseFertilizerBonusLimit(seedList);
               farmerObjectCoin=  farmerObjectCoin-registration.getRegistrationFee();
               return new Message (true, "Registered successfully", 0, 0, registration.getRegistrationFee());
            }
        }

                //registering for "Distinguished Farmer"
        else if(registration.getType().equals("Registered Farmer")) {

            //fail if level condition is not met
            if(farmerLevel < registrationList.get(2).getLevelNeeded())
               return new Message (false, "Must reach level " + registrationList.get(2).getLevelNeeded());
                //fail if there are insufficient funds
            else if(farmerObjectCoin < registrationList.get(2).getRegistrationFee())
                return new Message (false, "Insufficient Funds");
                //success
            else {
                this.registration = registrationList.get(2);
                registration.increaseEarnings(seedList);
                registration.reduceCost(seedList);
                registration.increaseWaterBonusLimit(seedList);
                registration.increaseFertilizerBonusLimit(seedList);
                farmerObjectCoin = farmerObjectCoin-registration.getRegistrationFee();
                return new Message (true, "Registered successfully", 0, 0, registration.getRegistrationFee());
            }
        }


        //registering for "Legendary Farmer"
        else {

            //fail if level condition is not met
            if(farmerLevel < registrationList.get(3).getLevelNeeded())
                return new Message  (false, "Must reach level " + registrationList.get(3).getLevelNeeded());
                //fail if there are insufficient funds
            else if(farmerObjectCoin < registrationList.get(3).getRegistrationFee())
                return new Message  (false, "Insufficient Funds");
                //success
            else {
                this.registration = registrationList.get(3);
                registration.increaseEarnings(seedList);
                registration.reduceCost(seedList);
                registration.increaseWaterBonusLimit(seedList);
                registration.increaseFertilizerBonusLimit(seedList);
                farmerObjectCoin = farmerObjectCoin-registration.getRegistrationFee();
                return new Message (true, "Registered successfully", 0, 0, registration.getRegistrationFee());
            }
        }

    }
          */

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
