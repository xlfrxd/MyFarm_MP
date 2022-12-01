package Views.tiles;

import Views.GamePanel;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStream;
import static javax.imageio.ImageIO.read;


public class tileManage {

    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];
    public tileManage(GamePanel gp){

        this.gp = gp;
        tile = new Tile[10];
        mapTileNum=new int [gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap();
    }
    public void getTileImage(){
        try{
            File file = new File("src/Views/tiles/Grass.png");
            FileInputStream fis = new FileInputStream(file);
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(fis);

            file = new File("src/Views/tiles/Soil.png");
            fis = new FileInputStream(file);
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(fis);

            file = new File("src/Views/tiles/Rock on Tile.png");
            fis = new FileInputStream(file);
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(fis);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(){

        try{
            InputStream is = getClass().getResourceAsStream("/Views/maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col< gp.maxScreenCol && row< gp.maxScreenRow){
                String line = br.readLine(); // reads number line by line

                while(col < gp.maxScreenCol){

                    String numbers[]=line.split(" "); // stores the number map unto an array

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col== gp.maxScreenCol){
                    col=0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){

        }
    }

    public void draw (Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col <gp.maxScreenCol && row < gp.maxScreenRow){

            int tileNum = mapTileNum[col][row];//extract tile number

            g2.drawImage(tile[tileNum].image,x,y,gp.tileSize,gp.tileSize,null);
            col++;
            x+=gp.tileSize;

            if(col==gp.maxScreenCol){
                col=0;
                x=0;
                row++;
                y+=gp.tileSize;
            }
        }
    }
}
