package Models;

public class FarmLot { //untouched
    private final int farmRow = 5;

    private final int farmCol = 10;
    private Tile[][] farmTiles = new Tile[farmRow][farmCol];
    public Tile[][] getFarmTiles() {
        return farmTiles;
    }
    public void setFarmTiles(Tile[][] farmTiles) {
        this.farmTiles = farmTiles;
    }

    public FarmLot(){
        for(int i = 0; i < farmRow; i++){
            for(int j = 0; j < farmCol; j++){
                farmTiles[i][j] = new Tile();
            }
        }
    }


    public int getFarmRow() {
        return farmRow;
    }

    public int getFarmCol() {
        return farmCol;
    }
}
