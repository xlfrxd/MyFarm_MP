package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class toolListView extends JPanel {

    JLabel toolBackground = new JLabel();
    JButton plowBtn = new JButton("Plow");
    JLabel plowLbl = new JLabel("Plow");
    JButton waterBtn = new JButton("Watering Can");
    JLabel waterLbl = new JLabel("Watering");
    JLabel canLbl = new JLabel("Can");

    JButton fertBtn = new JButton("Fertilizer");
    JLabel fertLbl = new JLabel("Fertilizer");

    JButton pickBtn = new JButton("Pickaxe");
    JLabel pickLbl = new JLabel("Pickaxe");
    JButton shovBtn = new JButton("Shovel");
    JLabel shovLbl = new JLabel("Shovel");
    JButton scythBtn = new JButton("Scythe");
    JLabel scythLbl = new JLabel("Scythe");

    public JButton[] getToolList() {
        return toolList;
    }

    JButton[] toolList = new JButton[6];

    public toolListView(){

        toolList[0] = plowBtn;
        toolList[1] = waterBtn;
        toolList[2] = fertBtn;
        toolList[3] = pickBtn;
        toolList[4] = shovBtn;
        toolList[5] = scythBtn;
        //PLOW
        plowBtn.setBounds(25,15,50,50);
        plowBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateToolImage(plowBtn, "src/Views/tools/Plow.png");
        this.add(plowBtn);

        plowLbl.setForeground(Color.WHITE);
        plowLbl.setBounds(35,40,70,50);
        this.add(plowLbl);
        //WATERING CAN
        waterBtn.setBounds(125,10,50,50);
        waterBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateToolImage(waterBtn, "src/Views/tools/Watering Can.png");
        this.add(waterBtn);

        waterLbl.setForeground(Color.WHITE);
        waterLbl.setBounds(120,37,70,50);
        this.add(waterLbl);

        canLbl.setForeground(Color.WHITE);
        canLbl.setBounds(135,50,70,50);
        this.add(canLbl);

         //FERTILIZER
        fertBtn.setBounds(30,110,50,50);
        fertBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateToolImage(fertBtn, "src/Views/tools/Fertilizer.png");
        this.add(fertBtn);

        fertLbl.setForeground(Color.WHITE);
        fertLbl.setBounds(25,145,70,50);
        this.add(fertLbl);

         //PICKAXE
        pickBtn.setBounds(125,110,50,50);
        pickBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateToolImage(pickBtn, "src/Views/tools/Pickaxe.png");
        this.add(pickBtn);

        pickLbl.setForeground(Color.WHITE);
        pickLbl.setBounds(120,145,70,50);
        this.add(pickLbl);

        //SHOVEL
        shovBtn.setBounds(28,215,50,50);
        shovBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateToolImage(shovBtn, "src/Views/tools/Shovel.png");
        this.add(shovBtn);

        shovLbl.setForeground(Color.WHITE);
        shovLbl.setBounds(30,245,70,50);
        this.add(shovLbl);

        //SCYTHE
        scythBtn.setBounds(120,215,50,50);
        scythBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateToolImage(scythBtn, "src/Views/tools/Scythe.png");
        this.add(scythBtn);

        scythLbl.setForeground(Color.WHITE);
        scythLbl.setBounds(125,245,70,50);
        this.add(scythLbl);

        for (JButton btn:
                toolList) {
            btn.setActionCommand(btn.getText());
        }

        toolBackground.setIcon(new ImageIcon("src/Views/tools/Tool Background.png"));
        toolBackground.setBounds(0,0, 200, 300);
        this.add(toolBackground);

    }

    public void setActionListener(ActionListener listener){
        plowBtn.addActionListener(listener);
        waterBtn.addActionListener(listener);
        fertBtn.addActionListener(listener);
        pickBtn.addActionListener(listener);
        shovBtn.addActionListener(listener);
        scythBtn.addActionListener(listener);
    }

    public void generateToolImage(JButton btn, String imagePath){
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
