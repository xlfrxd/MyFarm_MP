import Models.FarmLot;
import Models.Farmer;
import Models.Message;
import Models.Tool;
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

    messageView messagePrompt = new messageView();
    JPanel messageAvatar;

    public GameGUI(Game game){
        this.game = game;

        // MAIN WINDOW SETTINGS
        mainFrame = new JFrame("My Farmer Game");
        mainFrame.setSize(new Dimension(1200,1000));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen
        mainFrame.getContentPane().setBackground(Color.black); // Sets background of window
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen

        createUIElements();

        //Tool currentTool = new Tool();
        String currentTool;
        ActionListener buttonListener = new ActionListener() {
            JButton previousButton = null;
            JButton lastButton = null;
            @Override
            public void actionPerformed(ActionEvent e) {
                lastButton = (JButton) e.getSource();
                // TODO: Integrate last button and previous button to perform command Plow->Tile or Seed->Tile
                previousButton = lastButton;
            }
        };
        ActionListener currentTile = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Current tile index:" + e.getActionCommand());
            }
        };

        ActionListener currentSeed = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Current seed:" + e.getActionCommand());
            }
        };

        toolListUI.setActionListener(buttonListener);
        farmLotUI.setActionListener(currentTile);
        seedStoreUI.setActionListener(currentSeed);
        mainFrame.setVisible(true);

    }

    public void createUIElements(){
        // FARMER STATS (BOTTOM LEFT UI)
        statsUI.setBounds(50,650,575,150);
        statsUI.setBackground(Color.gray);

        // SEED STORE (BOTTOM RIGHT UI)
        seedStoreUI.setLayout(null);
        seedStoreUI.setBounds(650,575,500,225);
        seedStoreUI.setBackground(Color.blue);

        // TOOL LIST (MIDDLE RIGHT UI)
        toolListUI.setBounds(950,100,200,350);
        toolListUI.setBackground(Color.green);

        // DAY COUNTER (MIDDLE-UPPER LEFT UI)
        dayUI.setBounds(50,25,100,50);
        dayUI.setForeground(Color.white);
        // Add this to a class?
        dayUI.setFont(new Font("Arial", Font.PLAIN,20));
        dayUI.setText("Day: 0");

        // FARM LOT (MIDDLE UI)
        farmLotUI.generateLot();
        farmLotUI.setBounds(50,100,875,415);

        // LIL FARMER IMAGE
        messageAvatar = new JPanel();
        //messageAvatar.setBounds(150,575,100,200); // its own image
        messageAvatar.setBounds(50,525,100,100); // is a larger image
        messageAvatar.setBackground(Color.PINK);

        // LIL FARMER TEXT PROMPTER
        messagePrompt.setBounds(175,525,450,100);



        // NEXT DAY BUTTON
        nextDayBtn.setText("Next Day");
        nextDayBtn.setBounds(950,475,200,75);
        nextDayBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


        mainFrame.add(farmLotUI);
        mainFrame.add(statsUI);
        mainFrame.add(seedStoreUI);
        mainFrame.add(toolListUI);
        mainFrame.add(dayUI);
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
