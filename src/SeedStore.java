import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeedStore {
    private List<Crop> seedList;
    private boolean purchaseSuccess;

    public List<Crop> getSeedList() {
        return seedList;
    }

    public void setSeedList(ArrayList<Crop> seedList) {
        this.seedList = seedList;
    }

    public SeedStore() {
        /** Creates a Seed Store object that creates a structure to hold the information of each seed.
         */
        setSeedList(new ArrayList<>(Arrays.asList(
                new Crop("Turnip", "Root Crop", 5,
                        5, 6, 1, 2,
                        0, 1, 2,
                        0, 0, 1, 0, 2) // TURNIP

        ))); //TODO: ADD ALL SEEDS HERE
    }

    public void displaySeedList(){
        /** A helper method that is in charge of displaying all available crops for planting.
         */

        for(int i = 0; i < this.getSeedList().size(); i++) {
            Crop crop = this.getSeedList().get(i); // Instantiate a new crop per array in seedList
            displayCrop(i,crop.getCropName(),crop.getCropType(),crop.getSeedCost(),crop.getExpYield(),crop.getBasePrice(),crop.getMinProduce(),
                    crop.getMaxProduce(),crop.getWaterCount(),crop.getWaterReq(),crop.getWaterBonus(),crop.getFertCount(),crop.getFertReq(),
                    crop.getFertBonus(),crop.getHarvCount(),crop.getHarvReq());
        }
    }

    public void displayCrop(int index, String cropName, String cropType, double seedCost, double expYield, int basePrice,
                            int minProduce, int maxProduce, int waterCount, int waterReq, int waterBonus,
                            int fertCount, int fertReq, int fertBonus, int harvCount, int harvReq){
        /** A helper method that is in charge of organizing and displaying the information of each crop.
         * @param index	            index of the crop
         * @param cropName          the name of the Crop
         * @param cropType 	        the type of the Crop
         * @param seedCost 	        value of seed costs to buy
         * @param expYield	        experience yield if crop is harvested
         * @param basePrice 	    base price of the seed if crop is harvested
         * @param minProduce 	    minimum products produced
         * @param maxProduce       	maximum products produced
         * @param waterCount 	    number of times crop was watered
         * @param waterReq          number of times crop needs to be watered
         * @param waterBonus        water Bonus limit
         * @param fertCount      	number of times crop was fertilized
         * @param fertReq    	    number of times crop needs to be fertilized
         * @param fertBonus     	fertilizer Bonus Limit
         * @param harvCount         number of days passed since crop was planted
         * @param harvReq           number of days until crop becomes ready for harvest
         */
    }

}
