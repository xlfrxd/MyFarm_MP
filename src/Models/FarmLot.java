package Models;

public class FarmLot { //untouched
    private static final int farmRow = 5;
    private static final int farmCol = 10;
    private Tile[][] farmTiles = new Tile[farmRow][farmCol];

    public Tile[][] getFarmTiles() {
        return farmTiles;
    }

    public void setFarmTiles(Tile[][] farmTiles) {
        this.farmTiles = farmTiles;
    }

    //TODO: Create a function, <void inputElement(file : String)>, that would convert a file (000101010...) into matrix with or without a rock (can add bonus features)

    //TODO: advanceDay() func here
}
