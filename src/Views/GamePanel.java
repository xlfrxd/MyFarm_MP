package Views;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    final int origTileSize = 16;
    final int scale = 3;

    final int tileSize = origTileSize*scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize*maxScreenCol; // 768 px
    final int screenHeight = tileSize*maxScreenRow; // 576 px


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.blue);
        this.setDoubleBuffered(true); // improves game render performance
    }
}
