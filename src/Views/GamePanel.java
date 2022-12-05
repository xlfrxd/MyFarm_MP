package Views;

import Views.tiles.tileManage;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {

    final int origTileSize = 16;
    final int scale = 3;

    public final int tileSize = origTileSize*scale; // 48x48 tile
    public final int maxScreenCol = 32;
    public final int maxScreenRow = 24;
    public final int screenWidth = tileSize*maxScreenCol; // 768 px
    public final int screenHeight = tileSize*maxScreenRow; // 576 px


    public tileManage tileM = new tileManage(this);
    public UI ui = new UI(this);
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // improves game render performance
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);
        g2.dispose();
    }



}
