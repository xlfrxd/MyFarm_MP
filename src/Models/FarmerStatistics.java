package Models;

public class FarmerStatistics { // untouched
    public static int timesPlanted;
    public static int timesPlowed;
    public static int timesWatered;
    public static int timesFertilized;
    public static int timesHarvested;
    private static int timesHarvestedSuccessfully;


    public static void addPlanted(){
        /**
         * This function increments timesPlanted
         */
        timesPlanted++;
    }

    public static void addPlowed(){
        /**
         * This function increments timesPlowed
         */
        timesPlowed++;
    }

    public static void addWatered(){
        /**
         * This function increments timesWatered
         */
        timesWatered++;
    }

    public static void addFertil(){
        /**
         * This function increments timesFertilized
         */
        timesFertilized++;
    }

    public static void addHarv(){
        /**
         * This function increments timesHarvested
         */
        timesHarvested++;
    }

    public static void addHarvSuccess(){
        /**
         * This function increments successful timesHarvested
         */
        timesHarvestedSuccessfully++;
    }


}
