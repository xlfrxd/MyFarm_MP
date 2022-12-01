package Views;

import java.awt.*;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    public boolean messageOn = false;
    public String message = "";

    public UI(GamePanel gp){
        this.gp = gp;

    }

    public void showMessage(String text){
         message = text;
         messageOn = true;
    }

    public void draw (Graphics2D g2){

        this.g2 = g2;
        drawPlayerStatus();

    }

    public void drawPlayerStatus(){
        //Window Display
        int x = gp.tileSize*2;
        int y = gp.tileSize*15;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*5;
        drawSubWindow(x,y,width,height);

    }
    public void drawSubWindow(int x, int y, int width, int height){
        Color c  = new Color(0,0,0);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);
    }


}
