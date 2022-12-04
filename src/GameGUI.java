import Models.FarmLot;
import Models.Farmer;
import Models.Message;
import Views.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameGUI implements ActionListener {

    Game game;

    Farmer farmer;

    JFrame mainFrame;
    statsView statsUI = new statsView();
    seedStoreView seedStoreUI = new seedStoreView();
    toolListView toolListUI = new toolListView();
    dayView dayUI = new dayView();
    farmLotView farmLotUI = new farmLotView();
    JButton nextDayBtn = new JButton();

    public JTextArea messagePrompt;
    JPanel messageAvatar;

    public GameGUI(Game game){
        this.game = game;

        // MAIN WINDOW SETTINGS
        mainFrame = new JFrame("My Farmer Game");
        mainFrame.setSize(new Dimension(1200,1050));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen
        mainFrame.getContentPane().setBackground(Color.black); // Sets background of window
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen

        createUIElements();

        ActionListener toolListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Current tool:" + e.getActionCommand());
            }
        };
        ActionListener currentTile = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Current tile index:" + e.getActionCommand());
            }
        };

        toolListUI.setActionListener(toolListener);
        farmLotUI.setActionListener(currentTile);
        mainFrame.setVisible(true);

    }

    public void createUIElements(){
        // FARMER STATS (BOTTOM LEFT UI)
        statsUI.setBounds(50,750,500,200);
        statsUI.setBackground(Color.gray);

        // SEED STORE (BOTTOM RIGHT UI)
        seedStoreUI.setBounds(650,750,500,200);
        seedStoreUI.setBackground(Color.blue);

        // TOOL LIST (MIDDLE RIGHT UI)
        toolListUI.setBounds(950,100,200,450);
        toolListUI.setBackground(Color.green);

        // DAY COUNTER (MIDDLE-UPPER LEFT UI)
        dayUI.setBounds(50,25,100,50);
        dayUI.setForeground(Color.white);
        // Add this to a class?
        dayUI.setFont(new Font("Arial", Font.PLAIN,20));
        dayUI.setText("Day: 0");

        // FARM LOT (MIDDLE UI)
        farmLotUI.generateLot();
        farmLotUI.setBounds(50,100,875,450);

        // LIL FARMER IMAGE
        messageAvatar = new JPanel();
        //messageAvatar.setBounds(150,575,100,200); // its own image
        messageAvatar.setBounds(150,575,550,150); // is a larger image
        messageAvatar.setBackground(Color.PINK);

        // LIL FARMER TEXT PROMPTER
        messagePrompt = new JTextArea("HELLO");
        messagePrompt.setBounds(300,600,350,100);
        messagePrompt.setBackground(Color.cyan);
        messagePrompt.setForeground(Color.white);
        messagePrompt.setEditable(false);
        messagePrompt.setLineWrap(true);
        messagePrompt.setWrapStyleWord(true);

        messagePrompt.setFont(new Font("Arial", Font.PLAIN,20));

        // NEXT DAY BUTTON
        nextDayBtn.setText("Next Day");
        nextDayBtn.setBounds(750,625,200,100);
        nextDayBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


        mainFrame.add(statsUI);
        mainFrame.add(seedStoreUI);
        mainFrame.add(toolListUI);
        mainFrame.add(dayUI);
        mainFrame.add(farmLotUI);
        mainFrame.add(messagePrompt);
        mainFrame.add(messageAvatar);
        mainFrame.add(nextDayBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Tool Selected
//        if(e.getActionCommand().equals("Plow")){
//            messagePrompt.setText("You Plowed a Tile!");
//        } else if (e.getActionCommand().equals("Watering Can")) {
//            messagePrompt.setText("You Watered a Tile!");
//        } else if (e.getActionCommand().equals("Fertilizer")) {
//            messagePrompt.setText("You Fertilized a Tile!");
//        } else if (e.getActionCommand().equals("Pickaxe")) {
//            messagePrompt.setText("You Broke a Rock!");
//        } else if (e.getActionCommand().equals("Shovel")) {
//            messagePrompt.setText("You Shoved a Shit!");
//        }
//        else if (e.getActionCommand().equals("Scythe")) {
//            messagePrompt.setText("You Harvested a Tile!");
//        }


    }
}
