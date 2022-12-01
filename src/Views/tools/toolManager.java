package Views.tools;

import Views.GamePanel;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStream;
import static javax.imageio.ImageIO.read;


public class toolManager {

    GamePanel gp;
    public Views.tool.Tool[] tools;
    public toolManager(GamePanel gp){

        this.gp = gp;
        tools = new Views.tool.Tool[5];
        getToolImage();
    }
    public void getToolImage(){
        try{
            File file = new File("src/Views/tools/Plow.png");
            FileInputStream fis = new FileInputStream(file);
            tools[0] = new Views.tool.Tool();
            tools[0].image = ImageIO.read(fis);

            file = new File("src/Views/tools/Watering Can.png");
            fis = new FileInputStream(file);
            tools[1] = new Views.tool.Tool();
            tools[1].image = ImageIO.read(fis);

            file = new File("src/Views/tools/Pickaxe.png");
            fis = new FileInputStream(file);
            tools[2] = new Views.tool.Tool();
            tools[2].image = ImageIO.read(fis);

            file = new File("src/Views/tools/Shovel.png");
            fis = new FileInputStream(file);
            tools[3] = new Views.tool.Tool();
            tools[3].image = ImageIO.read(fis);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
