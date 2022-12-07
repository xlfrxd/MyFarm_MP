package Models;

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
                new Crop("Turnips", "Root", 5,
                        7.5, 6, 1, 2,
                        0, 1, 2,
                        0, 0, 1, 0, 2), // TURNIP
                new Crop("Carrots", "Root", 10,
                        5, 9, 1,2,
                        0,1,2,
                        0,0,1,0,3), // CARROT
                new Crop("Potatoes", "Root", 20,
                        12.5, 3,1,10,
                        0,3,4,
                        0,1,2,0,5 ), // POTATO
                new Crop("Roses", "Flower", 5,2.5,   //ROSE
                5,1,1,0,1,2,
                0,0,1,0,1),
                new Crop("Tulips", "Flower", 10,5,
                        9,1,1,0,2,3, //TULIPS
                        0,0,1,0,2),
                new Crop("Sunflowers", "Flower", 20,7.5,  //SUNFLOWER
                        19,1,1,0,2,3,
                        0,1,2,0,3),
                new Crop("Mangoes", "Fruit Tree", 100,25,  //MANGO
                        8,5,15,0,7,7,
                        0,4,4,0,10),
                new Crop("Apples", "Fruit Tree", 200,25,  //APPLE
                        5,10,15,0,7,7,
                        0,5,5,0,10)
        )));
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

    public void displayCrop(int index, String cropName, String cropType, double seedCost, double expYield, double basePrice,
                            int minProduce, int maxProduce, int waterCount, int waterReq, int waterBonus,
                            int fertCount, int fertReq, int fertBonus, int harvCount, int harvReq){
        /** A helper method that is in charge of organizing and displaying the information of each crop.
         * @param index	            index of the crop
         * @param cropName          the name of the Models.Crop
         * @param cropType 	        the type of the Models.Crop
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
