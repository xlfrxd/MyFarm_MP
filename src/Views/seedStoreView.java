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

    JLabel rectangle = new JLabel();

    JLabel cropType1 = new JLabel("Root Crops");
    JLabel cropType2 = new JLabel("Flowers");
    JLabel cropType3 = new JLabel("Fruit Trees");

    JButton turnipBtn = new JButton("Turnips");
    JLabel turnipLbl = new JLabel("Turnips");
    JButton carrotBtn = new JButton("Carrots");
    JLabel carrotLbl = new JLabel("Carrots");
    JButton potatoBtn = new JButton("Potatoes");
    JLabel potatoLbl = new JLabel("Potato");
    JButton roseBtn = new JButton("Roses");
    JLabel roseLbl = new JLabel("Roses");
    JButton tulipBtn = new JButton("Tulips");
    JLabel tulipLbl = new JLabel("Tulips");
    JButton sunflowerBtn = new JButton("Sunflowers");
    JLabel sunflowerLbl = new JLabel("Sunflowers");
    JButton mangoBtn = new JButton("Mango");
    JLabel mangoLbl = new JLabel("Mango");

    JButton appleBtn = new JButton("Apples");
    JLabel appleLbl = new JLabel("Apples");
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
        cropType1.setBounds(80,10, 80, 50);
        this.add(cropType1);
        //Turnips
        turnipBtn.setBounds(85,45,50,50);
        turnipBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(turnipBtn, "src/Views/seeds/Turnip Seeds.png");
        this.add(turnipBtn);

        turnipLbl.setForeground(Color.WHITE);
        turnipLbl.setBounds(130,45,50,50);
        this.add(turnipLbl);

        //Carrots
        carrotBtn.setBounds(85,95,50,50);
        carrotBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(carrotBtn, "src/Views/seeds/Carrot Seeds.png");
        this.add(carrotBtn);

        carrotLbl.setForeground(Color.WHITE);
        carrotLbl.setBounds(130,95,50,50);
        this.add(carrotLbl);

        //Potatoes
        potatoBtn.setBounds(85,145,50,50);
        potatoBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(potatoBtn, "src/Views/seeds/Potato Seeds.png");
        this.add(potatoBtn);

        potatoLbl.setForeground(Color.WHITE);
        potatoLbl.setBounds(130,145,50,50);
        this.add(potatoLbl);

        // FLOWERS
        cropType2.setForeground(Color.WHITE);
        cropType2.setBounds(200,10, 80, 50);
        this.add(cropType2);

        //Rose
        roseBtn.setBounds(200,45,50,50);
        roseBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(roseBtn, "src/Views/seeds/Rose Seeds.png");
        this.add(roseBtn);

        roseLbl.setForeground(Color.WHITE);
        roseLbl.setBounds(245,45,50,50);
        this.add(roseLbl);

        //Tulips
        tulipBtn.setBounds(200,95,50,50);
        tulipBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(tulipBtn, "src/Views/seeds/Tulip Seeds.png");
        this.add(tulipBtn);
        tulipLbl.setForeground(Color.WHITE);
        tulipLbl.setBounds(245,95,50,50);
        this.add(tulipLbl);

        //Sunflower
        sunflowerBtn.setBounds(200,145,50,50);
        sunflowerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(sunflowerBtn, "src/Views/seeds/Sunflower Seeds.png");
        this.add(sunflowerBtn);

        sunflowerLbl.setForeground(Color.WHITE);
        sunflowerLbl.setBounds(245,145,70,50);
        this.add(sunflowerLbl);

        //FRUIT TREES
        cropType3.setForeground(Color.WHITE);
        cropType3.setBounds(300,10, 80, 50);
        this.add(cropType3);
        //Mangoes
        mangoBtn.setBounds(310,45,50,50);
        mangoBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(mangoBtn, "src/Views/seeds/Mango Seeds.png");
        this.add(mangoBtn);

        mangoLbl.setForeground(Color.WHITE);
        mangoLbl.setBounds(355,45,50,50);
        this.add(mangoLbl);

        //Apples
        appleBtn.setBounds(310,95,50,50);
        appleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateSeedImage(appleBtn, "src/Views/seeds/Apple Seeds.png");
        this.add(appleBtn);

        appleLbl.setForeground(Color.WHITE);
        appleLbl.setBounds(355,95,50,50);
        this.add(appleLbl);

        for (JButton btn:
                seedList) {
            btn.setActionCommand(btn.getText());
        }

        rectangle.setIcon(new ImageIcon("C:\\Users\\Jill\\Desktop\\MCO2 - CCPROG3\\MyFarm_MP\\src\\Views\\seeds\\Store Background.png"));
        rectangle.setBounds(0,0, 500, 225);
        this.add(rectangle);



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


    }




}
