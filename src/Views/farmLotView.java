package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class farmLotView extends JPanel {


    JButton[] farmTiles = new JButton[50];

    public void generateLot(){


        FlowLayout layout = new FlowLayout();
        Container container = new Container();
        container.setLayout(new GridLayout(5,10));
        layout.setHgap(5);
        layout.setVgap(5);
        this.setLayout(layout);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

        int PIX_SIZE = 80;

        for (int i = 0; i < 50; i++) {
            JButton btn = new JButton();
            farmTiles[i] = btn;
            btn.setActionCommand(String.valueOf(i));
            btn.setPreferredSize(new Dimension(PIX_SIZE,PIX_SIZE));

            try {
                BufferedImage bufferedImage = ImageIO.read(new File("src/Views/tiles/Soil.png"));
                BufferedImage bufferedImageResult = new BufferedImage(
                        PIX_SIZE,
                        PIX_SIZE,
                        bufferedImage.getType()
                );
                Graphics2D g2d = bufferedImageResult.createGraphics();
                g2d.drawImage(
                        bufferedImage,
                        0,
                        0,
                        PIX_SIZE,
                        PIX_SIZE,
                        null
                );
                g2d.dispose();
                String formatName = "src/Views/tiles/Soil.png".substring(
                        "src/Views/tiles/Soil.png".lastIndexOf(".") + 1
                );
                ImageIO.write(
                        bufferedImageResult,
                        formatName,
                        new File("src/Views/tiles/Soil.png")
                );

                btn.setIcon(new ImageIcon(bufferedImageResult));
                btn.setOpaque(false);
                btn.setContentAreaFilled(false);
                btn.setBorderPainted(false);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            btn.setIcon(new ImageIcon("src/Views/tiles/Soil.png")); // scale this image to fit button
            container.add(btn);
            validate();
        }




        this.add(container);
    }

    public void allocateTileImage(String filePath){

    }

    public void setActionListener(ActionListener listener){
        for (JButton btn :
                farmTiles) {
            btn.addActionListener(listener);
        }
    }

}
