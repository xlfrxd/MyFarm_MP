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

//                try {
//                    BufferedImage bufferedImage = ImageIO.read(new File("src/Views/tiles/Soil.png"));
//                    BufferedImage bufferedImageResult = new BufferedImage(
//                            PIX_SIZE,
//                            PIX_SIZE,
//                            bufferedImage.getType()
//                    );
//                    Graphics2D g2d = bufferedImageResult.createGraphics();
//                    g2d.drawImage(
//                            bufferedImage,
//                            0,
//                            0,
//                            PIX_SIZE,
//                            PIX_SIZE,
//                            null
//                    );
//                    g2d.dispose();
//                    String formatName = "src/Views/tiles/Soil.png".substring(
//                            "src/Views/tiles/Soil.png".lastIndexOf(".") + 1
//                    );
//                    ImageIO.write(
//                            bufferedImageResult,
//                            formatName,
//                            new File("src/Views/tiles/Soil.png")
//                    );
//
//                    farmTiles[i][j].setIcon(new ImageIcon(bufferedImageResult));
//
//
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }

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
               farmTiles[i][j].setToolTipText("<html>An empty tile<br><br><i>Try plowing the plot to start growing crops</i></html>");

           }
       }
    }
}
