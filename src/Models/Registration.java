package Models;

import java.util.List;

public class Registration {
        private String type;
        private int levelNeeded;
        private double bonusEarnings, costReduction;
        private int plusWaterBonusLimit, plusFertBonusLimit;
        private double registrationFee;



        public Registration( String type, int levelNeeded, float bonusEarnings, float costReduction, int plusWaterBonusLimit,
                             int plusFertBonusLimit, float registrationFee) {
            this.type = type;
            this.levelNeeded = levelNeeded;
            this.bonusEarnings = bonusEarnings;
            this.costReduction = costReduction;
            this.plusWaterBonusLimit = plusWaterBonusLimit;
            this.plusFertBonusLimit = plusFertBonusLimit;
            this.registrationFee = registrationFee;

        }

        public String getType() {
            return type;
        }

        public double getRegistrationFee() {
            return registrationFee;
        }

        public int getLevelNeeded() {
            return levelNeeded;
        }

        public void increaseEarnings(List<Crop> seedList) {
            for (int i = 0; i < seedList.size(); i++) {
                seedList.get(i).setBasePrice(seedList.get(i).getBasePrice() + bonusEarnings);
            }
        }

        public void reduceCost(List<Crop> seedList) {
            for (int i = 0; i < seedList.size(); i++) {
                seedList.get(i).setSeedCost(seedList.get(i).getSeedCost()+costReduction);
            }
        }

        public void increaseWaterBonusLimit(List<Crop> seedList) {
            for (int i = 0; i < seedList.size(); i++) {
                seedList.get(i).setWaterBonus(seedList.get(i).getWaterBonus()+plusWaterBonusLimit);
            }
        }

        public void increaseFertilizerBonusLimit(List<Crop> seedList) {
            for (int i = 0; i < seedList.size(); i++) {
                seedList.get(i).setFertBonus(seedList.get(i).getFertBonus()+plusFertBonusLimit);
            }
        }

        @Override
        public String toString() {
            return " " + type;
        }

}
