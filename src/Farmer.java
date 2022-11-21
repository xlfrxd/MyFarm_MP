public class Farmer {
    // Superclass
    private static String farmerName;
    private static int farmerObjectCoin;
    private static double farmerExp;
    private static int farmerLevel;
    private static FarmerType farmerType;

    public static String getFarmerName() {
        return farmerName;
    }

    public static void setFarmerName(String farmerName) {
        Farmer.farmerName = farmerName;
    }

    public static int getFarmerObjectCoin() {
        return farmerObjectCoin;
    }

    public static void setFarmerObjectCoin(int farmerObjectCoin) {
        Farmer.farmerObjectCoin = farmerObjectCoin;
    }

    public static double isFarmerExp() {
        return farmerExp;
    }

    public static void setFarmerExp(double farmerExp) {
        Farmer.farmerExp = farmerExp;
    }

    public static int getFarmerLevel() {
        return farmerLevel;
    }

    public static void setFarmerLevel(int farmerLevel) {

        Farmer.farmerLevel = farmerLevel;
    }

    //public static ArrayList<Tool> farmerTools;

    public static void updateLevel(int level){
        /** This function updates the farmer's level based on its experience
         * @param level	            Farmer's current level
         */

    }

    public static void registerFarmerType(String name, double exp, int balance, FarmerType type){
        /** This function allows the farmer to register to gain perks and experience
         * @param name	            Farmer's name
         * @param exp               Farmer's experience points
         * @param balance           Farmer's object coins
         * @param type              Farmer's farmer type
         */

    }

    // debatable to put this func into main
    public static void buySeed(int seedCost, int balance){
        /** This function charges the object coin balance of the Farmer when purchasing seeds
         * @param seedCost	            Seed's cost to purchase
         * @param balance               Farmer's object coin balance
         */

    }
}
