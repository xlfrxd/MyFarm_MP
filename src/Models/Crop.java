package Models;

public class Crop {
    private String cropName;
    private String cropType;
    private double seedCost;
    private double expYield;
    private double basePrice;
    private int minProduce;
    private int maxProduce;
    private int waterCount;
    private int waterReq;
    private int waterBonus;
    private int fertCount;
    private int fertReq;
    private int fertBonus;
    private int harvCount;
    private int harvReq;

    public Crop(String cropName, String cropType, double seedCost, double expYield, double basePrice,
                int minProduce, int maxProduce, int waterCount, int waterReq, int waterBonus,
                int fertCount, int fertReq, int fertBonus, int harvCount, int harvReq) {
           /** Creates a Models.Crop object by supplying the name, type, how many
            * times it was watered and fertilized, how much water and fertilizer needed,
            * how many days since it was planted, how many days for it to harvest, products
            * produced, seed costs to buy, experience yield and price of seed when harvested.
            *
            * @param cropName 	        the name of the Models.Crop
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
        this.cropName = cropName; // Instantiates cropName via parameter
        this.cropType = cropType; // Instantiates cropType via parameter
        this.seedCost = seedCost; // Instantiates seedCost via parameter
        this.expYield = expYield; // Instantiates expYield via parameter
        this.basePrice = basePrice; // Instantiates basePrice via parameter
        this.waterCount = waterCount; // Instantiates water count via parameter
        this.waterBonus = waterBonus; // Instantiates waterBonus via parameter
        this.waterReq = waterReq; // Instantiates waterNeeded via parameter
        this.fertCount = fertCount; // Instantiates fertilizer via parameter
        this.fertBonus = fertBonus; // Instantiates fertilizerBonus via parameter
        this.fertReq = fertReq; // Instantiates fertilizerNeeded via parameter
        this.harvCount = harvCount; // Instantiates harvest via parameter
        this.harvReq = harvReq; // Instantiates harvestNeeded via parameter
        this.minProduce = minProduce; // Instantiates minProduce via parameter
        this.maxProduce = maxProduce; // Instantiates maxProduce via parameter
    }


    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public double getSeedCost() {
        return seedCost;
    }

    public void setSeedCost(double seedCost) {
        this.seedCost = seedCost;
    }

    public double getExpYield() {
        return expYield;
    }

    public void setExpYield(double expYield) {
        this.expYield = expYield;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getMinProduce() {
        return minProduce;
    }

    public void setMinProduce(int minProduce) {
        this.minProduce = minProduce;
    }

    public int getMaxProduce() {
        return maxProduce;
    }

    public void setMaxProduce(int maxProduce) {
        this.maxProduce = maxProduce;
    }

    public int getWaterCount() {
        return waterCount;
    }

    public void setWaterCount(int waterCount) {
        this.waterCount = waterCount;
    }

    public int getWaterReq() {
        return waterReq;
    }

    public void setWaterReq(int waterReq) {
        this.waterReq = waterReq;
    }

    public int getWaterBonus() {
        return waterBonus;
    }

    public void setWaterBonus(int waterBonus) {
        this.waterBonus = waterBonus;
    }

    public int getFertCount() {
        return fertCount;
    }

    public void setFertCount(int fertCount) {
        this.fertCount = fertCount;
    }

    public int getFertReq() {
        return fertReq;
    }

    public void setFertReq(int fertReq) {
        this.fertReq = fertReq;
    }

    public int getFertBonus() {
        return fertBonus;
    }

    public void setFertBonus(int fertBonus) {
        this.fertBonus = fertBonus;
    }

    public int getHarvCount() {
        return harvCount;
    }

    public void setHarvCount(int harvCount) {
        this.harvCount = harvCount;
    }

    public int getHarvReq() {
        return harvReq;
    }

    public void setHarvReq(int harvReq) {
        this.harvReq = harvReq;
    }




}
