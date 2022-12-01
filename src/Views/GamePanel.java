package Views;

import javax.swing.*;
import java.awt.*;
import Views.tiles.tileManage;

public class GamePanel extends JPanel {

    final int origTileSize = 16;
    final int scale = 3;

    final int tileSize = origTileSize*scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize*maxScreenCol; // 768 px
    final int screenHeight = tileSize*maxScreenRow; // 576 px

    tileManage tileM = new tileManage(this);
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
