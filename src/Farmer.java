import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Farmer {
    // Superclass
    private String farmerName;
    private int farmerObjectCoin;
    private double farmerExp;
    private int farmerLevel;
    private FarmerType farmerType;
    private List<Tool> farmerTools;

    public Farmer(String farmerName){
        this.farmerName = farmerName;
        this.farmerExp = 0;
        this.farmerLevel = 0;
        this.farmerObjectCoin = 100;

        setFarmerTools(new ArrayList<Tool>(Arrays.asList(
                new Tool("Plow", 0, 0.5),
                new Tool("Watering Can", 0, 0.5),
                new Tool("Fertilizer", 10, 4)
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

    public int getFarmerObjectCoin() {
        return farmerObjectCoin;
    }

    public void setFarmerObjectCoin(int farmerObjectCoin) {
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


    public void updateLevel(int exp, int level){
        /** This function updates the farmer's level based on its experience
         * @param exp               Famer's current exp count
         * @param level	            Farmer's current level
         */

        if(exp%100==0){ // If experience is a multiple of 100
            level+=1; // Increase the level by 1
        }
    }

    public void registerFarmerType(String name, double exp, int balance, FarmerType type){
        /** This function allows the farmer to register to gain perks and experience
         * @param name	            Farmer's name
         * @param exp               Farmer's experience points
         * @param balance           Farmer's object coins
         * @param type              Farmer's farmer type
         */

    }


    public static void buySeed(int seedCost, int balance){ // debatable to put this func into main
        /** This function charges the object coin balance of the Farmer when purchasing seeds
         * @param seedCost	            Seed's cost to purchase
         * @param balance               Farmer's object coin balance
         */

    }

    public void showToolList(){
        /** This function displays all the tools available for the farmer
         */
        for (Tool tool: this.farmerTools
             ) {
            System.out.println("Tool Name: " + tool.getToolName() + "\nCost of usage: "  + tool.getToolCost() + "\nExperience Gain:" + tool.getToolExp() + "\n");
        }
    }
}
