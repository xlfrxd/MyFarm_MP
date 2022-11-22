public class FarmLot { //untouched
    private int farmRow;
    private int farmCol;
    private Tile[][] farmTiles = new Tile[5][10];


    public int getFarmRow() {
        return farmRow;
    }

    public void setFarmRow(int farmRow) {
        this.farmRow = farmRow;
    }

    public int getFarmCol() {
        return farmCol;
    }

    public void setFarmCol(int farmCol) {
        this.farmCol = farmCol;
    }

    public Tile[][] getFarmTiles() {
        return farmTiles;
    }

    public void setFarmTiles(Tile[][] farmTiles) {
        this.farmTiles = farmTiles;
    }

    //TODO: Create a function, <void inputElement(file : String)>, that would convert a file (000101010...) into matrix with or without a rock (can add bonus features)

    //TODO: advanceDay() func here
}
