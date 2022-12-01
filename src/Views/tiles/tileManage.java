package Views.tiles;

import Views.GamePanel;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

import static javax.imageio.ImageIO.read;


public class tileManage {

    GamePanel gp;
    Tile[] tile;

    public tileManage(GamePanel gp){

        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }
    public void getTileImage(){
        try{
            tile[0]= new Tile();
            tile[0].image = read(getClass().getResourceAsStream("Views/tiles/Grass.png"));
            tile[1]= new Tile();
            tile[1].image = read(getClass().getResourceAsStream("Views/tiles/Soil.png"));
            tile[2]= new Tile();
            tile[2].image = read(getClass().getResourceAsStream("Views/tiles/Rock on Tile.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw (Graphics2D g2){
        g2.drawImage(tile[0].image,0,0,48,48,null);
        g2.drawImage(tile[1].image,48,0,48,48,null);
        g2.drawImage(tile[2].image,96,0,48,48,null);
    }
}
