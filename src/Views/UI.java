package Views;

import java.awt.*;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    public boolean messageOn = false;
    public String message = "";

    public static String userName = "";

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font ("Arial", Font.PLAIN,40);
        arial_80B = new Font ("Arial", Font.BOLD, 80);

    }

    public void showMessage(String text){
         message = text;
         messageOn = true;
    }

    public void draw (Graphics2D g2){

        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        drawPlayerStatus();

    }

    public void drawPlayerStatus(){
        //Window Display
        int x = gp.tileSize*2;
        int y = gp.tileSize*15;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*5;
        drawSubWindow(x,y,width,height);

        x+= gp.tileSize;
        y+= gp.tileSize;
        g2.drawString("Howdy," + getUserName(),x,y+2);

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
