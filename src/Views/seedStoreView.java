package Views;

import Models.Crop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class seedStoreView extends JPanel {

    JLabel cropType1 = new JLabel("Root Crops");
    JLabel cropType2 = new JLabel("Flowers");
    JLabel cropType3 = new JLabel("Fruit Trees");

    JButton turnipBtn = new JButton("Turnips");
    JButton carrotBtn = new JButton("Carrots");
    JButton potatoBtn = new JButton("Potatoes");
    JButton roseBtn = new JButton("Roses");
    JButton tulipBtn = new JButton("Tulips");
    JButton sunflowerBtn = new JButton("Sunflowers");
    JButton mangoBtn = new JButton("Mango");

    JButton appleBtn = new JButton("Apples");
    JButton[] seedList = new JButton[8];



    public seedStoreView(){

        seedList[0] = turnipBtn;
        seedList[1] = carrotBtn;
        seedList[2] = potatoBtn;
        seedList[3] = roseBtn;
        seedList[4] = tulipBtn;
        seedList[5] = sunflowerBtn;
        seedList[6] = mangoBtn;
        seedList[7] = appleBtn;


        //ROOT CROPS
        cropType1.setForeground(Color.WHITE);
        cropType1.setBounds(50,10, 80, 50);
        this.add(cropType1);

        turnipBtn.setBounds(50,50,50,50);
        turnipBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(turnipBtn, "src/Views/seeds/Turnip Seeds.png");
        this.add(turnipBtn);

        carrotBtn.setBounds(50,100,50,50);
        carrotBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(carrotBtn, "src/Views/seeds/Carrot Seeds.png");
        this.add(carrotBtn);

        potatoBtn.setBounds(50,150,50,50);
        potatoBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(potatoBtn, "src/Views/seeds/Potato Seeds.png");
        this.add(potatoBtn);

        // FLOWERS
        cropType2.setForeground(Color.WHITE);
        cropType2.setBounds(200,10, 80, 50);
        this.add(cropType2);

        roseBtn.setBounds(200,50,50,50);
        roseBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(roseBtn, "src/Views/seeds/Rose Seeds.png");
        this.add(roseBtn);

        tulipBtn.setBounds(200,100,50,50);
        tulipBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(tulipBtn, "src/Views/seeds/Tulip Seeds.png");
        this.add(tulipBtn);

        sunflowerBtn.setBounds(200,150,50,50);
        sunflowerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(sunflowerBtn, "src/Views/seeds/Sunflower Seeds.png");
        this.add(sunflowerBtn);

        //FRUIT TREES
        cropType3.setForeground(Color.WHITE);
        cropType3.setBounds(350,10, 80, 50);
        this.add(cropType3);

        mangoBtn.setBounds(350,50,50,50);
        mangoBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(mangoBtn, "src/Views/seeds/Mango Seeds.png");
        this.add(mangoBtn);

        appleBtn.setBounds(350,100,50,50);
        appleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(appleBtn, "src/Views/seeds/Apple Seeds.png");
        this.add(appleBtn);

        for (JButton btn:
                seedList) {
            btn.setActionCommand(btn.getText());
        }



    }

    public void setActionListener(ActionListener listener){
        turnipBtn.addActionListener(listener);
        carrotBtn.addActionListener(listener);
        potatoBtn.addActionListener(listener);
        roseBtn.addActionListener(listener);
        tulipBtn.addActionListener(listener);
        sunflowerBtn.addActionListener(listener);
        mangoBtn.addActionListener(listener);
        appleBtn.addActionListener(listener);
    }

    public void generateSeedImage(JButton btn, String imagePath){
        int PIX_SIZE = 50;

            try {
                BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
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
                String formatName = imagePath.substring(
                        imagePath.lastIndexOf(".") + 1
                );
                ImageIO.write(
                        bufferedImageResult,
                        formatName,
                        new File(imagePath)
                );

                btn.setIcon(new ImageIcon(bufferedImageResult));
                btn.setOpaque(false);
                btn.setContentAreaFilled(false);
                btn.setBorderPainted(false);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            btn.setIcon(new ImageIcon(imagePath)); // scale this image to fit button
            validate();

    }


}
