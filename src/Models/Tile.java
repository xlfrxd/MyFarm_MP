package Models;

public class Tile { // untouched
    private Crop plantedCrop;
    private boolean isPlowed;
    private boolean isWithered;
    private boolean hasRock;

    public Tile(){
        plantedCrop = null;
        isPlowed = false;
        isWithered = false;
        hasRock = false;
    }

    public Tile getTile(){
        return this;
    }


    public boolean getIsPlowed() {
        return isPlowed;
    }

    public void setPlowed(boolean plowed) {
        isPlowed = plowed;
    }

    public Crop getPlantedCrop() {
        return plantedCrop;
    }

    public void setPlantedCrop(Crop plantedCrop) {
        this.plantedCrop = plantedCrop;
    }

    public boolean getIsWithered() {
        return isWithered;
    }

    public void setWithered(boolean withered) {
        isWithered = withered;
    }

    public boolean getHasRock() {
        return hasRock;
    }

    public void setHasRock(boolean hasRock) {
        this.hasRock = hasRock;
    }

}
