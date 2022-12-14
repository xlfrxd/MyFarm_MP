package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FarmLotView extends JPanel {


    public JButton[][] getFarmTiles() {
        return farmTiles;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    private int row = 5;
    private int col = 10;
    JButton[][] farmTiles = new JButton[row][col];

    public void generateLot(){


        FlowLayout layout = new FlowLayout();
        Container container = new Container();
        container.setLayout(new GridLayout(5,10));
        //layout.setHgap(5);
        //layout.setVgap(5);
        this.setLayout(layout);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

        int PIX_SIZE = 80;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                farmTiles[i][j] = new JButton();
                farmTiles[i][j].setPreferredSize(new Dimension(PIX_SIZE, PIX_SIZE));

                farmTiles[i][j].setActionCommand(i + "," + j);
                farmTiles[i][j].setPreferredSize(new Dimension(PIX_SIZE, PIX_SIZE));

                farmTiles[i][j].setOpaque(false);
                farmTiles[i][j].setContentAreaFilled(false);
                farmTiles[i][j].setBorderPainted(false);
                farmTiles[i][j].setIcon(new ImageIcon("src/Views/tiles/Soil.png")); // scale this image to fit button
                container.add(farmTiles[i][j]);
                validate();
            }
        }

        this.add(container);
    }

    public void setTilePlowed() {

    }

    public void setActionListener(ActionListener listener){
       for(int i=0; i < row; i++){
           for (int j=0; j < col; j++){
               farmTiles[i][j].addActionListener(listener);

           }
       }
    }
}
