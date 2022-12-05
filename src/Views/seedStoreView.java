package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class seedStoreView extends JPanel {

    JLabel cropType1 = new JLabel("Root Crops");
    JLabel cropType2 = new JLabel("Flowers");
    JLabel cropType3 = new JLabel("Fruit Trees");

    JButton turnipBtn = new JButton("Turnip");
    JButton carrotBtn = new JButton("Carrot");
    JButton potatoBtn = new JButton("Potato");
    JButton roseBtn = new JButton("Rose");
    JButton tulipBtn = new JButton("Tulips");
    JButton sunflowerBtn = new JButton("Sunflower");
    JButton mangoBtn = new JButton("Mango");

    JButton appleBtn = new JButton("Apple");
    JButton[] seedList = new JButton[8];

    public seedStoreView(){
        //ROOT CROPS
        cropType1.setForeground(Color.WHITE);
        cropType1.setBounds(50,10, 100, 40);
        this.add(cropType1);

        turnipBtn.setBounds(50,50,100,40);
        turnipBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(turnipBtn);

        carrotBtn.setBounds(50,100,100,40);
        carrotBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(carrotBtn);

        potatoBtn.setBounds(50,150,100,40);
        potatoBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(potatoBtn);

        // FLOWERS
        cropType2.setForeground(Color.WHITE);
        cropType2.setBounds(200,10, 100, 40);
        this.add(cropType2);

        roseBtn.setBounds(200,50,100,40);
        roseBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(roseBtn);

        tulipBtn.setBounds(200,100,100,40);
        tulipBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(tulipBtn);

        sunflowerBtn.setBounds(200,150,100,40);
        sunflowerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(sunflowerBtn);

        //FRUIT TREES
        cropType3.setForeground(Color.WHITE);
        cropType3.setBounds(350,10, 100, 40);
        this.add(cropType3);

        mangoBtn.setBounds(350,50,100,40);
        mangoBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(mangoBtn);

        appleBtn.setBounds(350,100,100,40);
        appleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(appleBtn);


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

}
