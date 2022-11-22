public class Tile {
    private boolean isPlowed;
    private Crop plantedCrop;
    private boolean isWithered;
    private boolean hasRock;


    public boolean isPlowed() {
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

    public boolean isWithered() {
        return isWithered;
    }

    public void setWithered(boolean withered) {
        isWithered = withered;
    }

    public boolean isHasRock() {
        return hasRock;
    }

    public void setHasRock(boolean hasRock) {
        this.hasRock = hasRock;
    }

}
