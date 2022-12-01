package Views;

import Views.tiles.tileManage;
import Views.tools.toolManager;

import java.awt.*;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_20, arial_80B;
    public boolean messageOn = false;
    public String message = "";
    public toolManager toolM = new toolManager(gp);
    public static String userName = "";

    public UI(GamePanel gp){
        this.gp = gp;
        arial_20= new Font ("Arial", Font.PLAIN,20);
        arial_80B = new Font ("Arial", Font.BOLD, 80);

    }

    public void showMessage(String text){
         message = text;
         messageOn = true;
    }

    public void draw (Graphics2D g2){

        this.g2 = g2;
        g2.setFont(arial_20);
        g2.setColor(Color.white);
        drawPlayerStatus();
        drawSeedStore();
        drawToolGroup();

    }

    public void drawPlayerStatus(){
        //Window Display
        int x = gp.tileSize;
        int y = gp.tileSize*15;
        int width = gp.screenWidth - (gp.tileSize*20);
        int height = gp.tileSize*5;
        drawSubWindow(x,y,width,height);

        x+= gp.tileSize;
        y+= gp.tileSize;
        g2.drawString("Howdy," + getUserName(),x,y+2);

    }

    public void drawSeedStore(){
        //Window Display
        int x = gp.tileSize*13;
        int y = gp.tileSize*15;
        int width = gp.screenWidth - (gp.tileSize*14);
        int height = gp.tileSize*5;
        drawSubWindow(x,y,width,height);

        x+= gp.tileSize;
        y+= gp.tileSize;
        g2.drawString("Seed Store" + getUserName(),x,y+2);

    }
    public void drawToolGroup(){
        //Frame
        int frameX = gp.tileSize*27;
        int frameY = gp.tileSize;
        int frameWidth = gp.screenWidth - (gp.tileSize*28);
        int frameHeight = gp.screenWidth - (gp.tileSize*20);
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        frameX+= gp.tileSize;
        frameY+= gp.tileSize;

        g2.drawString("Tools" + getUserName(),frameX+30,frameY);

        //Tool Names Text
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(20F));

        int textX = frameX + 50;
        int textY = (frameY + gp.tileSize) - 10;
        int lineHeight = 50;

        g2.drawString("Plow", textX, textY);
        textY += lineHeight;

        g2.drawString("Water", textX, textY);
        textY += lineHeight;

        g2.drawString("Pickaxe", textX, textY);
        textY += lineHeight;

        g2.drawString("Shovel", textX, textY);
        textY += lineHeight;

        int tailX = (frameX + frameWidth) - 150;
        textY = frameY+8;

        //Tool Icons
        g2.drawImage(toolM.tools[0].image,tailX - gp.tileSize,textY,gp.tileSize,gp.tileSize,null);
        textY+=gp.tileSize;
        g2.drawImage(toolM.tools[1].image,tailX - gp.tileSize,textY,gp.tileSize,gp.tileSize,null);
        textY+=gp.tileSize;
        g2.drawImage(toolM.tools[2].image,tailX - gp.tileSize,textY,gp.tileSize,gp.tileSize,null);
        textY+=gp.tileSize;
        g2.drawImage(toolM.tools[3].image,tailX - gp.tileSize,textY,gp.tileSize,gp.tileSize,null);
        textY+=gp.tileSize;




    }


    public void drawSubWindow(int x, int y, int width, int height){
        Color c  = new Color(0,0,0);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);

        c = new Color (255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25,25);

    }
    public String getUserName() {
        return userName;
    }
   public static void setUserName(String userName) {
       UI.userName = userName;
   }




}
