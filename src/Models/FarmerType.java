package Models;

public class FarmerType { //untouched
    private String farmerTypeName;


    public int getFarmerLevelReq() {
        return farmerLevelReq;
    }

    public void setFarmerLevelReq(int farmerLevelReq) {
        this.farmerLevelReq = farmerLevelReq;
    }

    private int farmerLevelReq;
    private int farmerBonusEarnings;
    private int farmerSeedCostReduction;
    private int farmerWaterBonusLimit;
    private int farmerFertBonusLimit;
    private int farmerRegFee;

public FarmerType(String farmerTypeName, int farmerLevelReq, int farmerBonusEarnings, int farmerSeedCostReduction, int farmerWaterBonusLimit, int farmerFertBonusLimit, int farmerRegFee){
    this.farmerTypeName = farmerTypeName;
    this.farmerLevelReq = farmerLevelReq;
    this.farmerBonusEarnings = farmerBonusEarnings;
    this.farmerSeedCostReduction = farmerSeedCostReduction;
    this.farmerWaterBonusLimit = farmerWaterBonusLimit;
    this.farmerFertBonusLimit = farmerFertBonusLimit;
    this.farmerRegFee   = farmerRegFee;
}
    public String getFarmerTypeName() {
        return farmerTypeName;
    }

    public void setFarmerTypeName(String farmerTypeName) {
        this.farmerTypeName = farmerTypeName;
    }

    public int getFarmerBonusEarnings() {
        return farmerBonusEarnings;
    }

    public void setFarmerBonusEarnings(int farmerBonusEarnings) {
        this.farmerBonusEarnings = farmerBonusEarnings;
    }

    public int getFarmerSeedCostReduction() {
        return farmerSeedCostReduction;
    }

    public void setFarmerSeedCostReduction(int farmerSeedCostReduction) {
        this.farmerSeedCostReduction = farmerSeedCostReduction;
    }

    public int getFarmerWaterBonusLimit() {
        return farmerWaterBonusLimit;
    }

    public void setFarmerWaterBonusLimit(int farmerWaterBonusLimit) {
        this.farmerWaterBonusLimit = farmerWaterBonusLimit;
    }

    public int getFarmerFertBonusLimit() {
        return farmerFertBonusLimit;
    }

    public void setFarmerFertBonusLimit(int farmerFertBonusLimit) {
        this.farmerFertBonusLimit = farmerFertBonusLimit;
    }

    public int getFarmerRegFee() {
        return farmerRegFee;
    }

    public void setFarmerRegFee(int farmerRegFee) {
        this.farmerRegFee = farmerRegFee;
    }

}
