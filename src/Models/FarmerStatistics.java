package Models;

public class FarmerStatistics { // untouched
    public static int timesPlanted;

    public static int getTimesPlanted() {
        return timesPlanted;
    }

    public void setTimesPlanted(int timesPlanted) {
        FarmerStatistics.timesPlanted = timesPlanted;
    }

    public int getTimesHarvested() {
        return timesHarvested;
    }

    public static void setTimesHarvested(int timesHarvested) {
        FarmerStatistics.timesHarvested = timesHarvested;
    }

    public static int timesHarvested;



}
