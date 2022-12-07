import Models.*;
import Views.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameGUI {

    Game game;

    JFrame mainFrame;
    statsView statsUI = new statsView();
    seedStoreView seedStoreUI = new seedStoreView();

    toolListView toolListUI = new toolListView();
    dayView dayUI = new dayView();

    FarmLot farmLot = new FarmLot();
    FarmLotView farmLotUI = new FarmLotView();
    messageView messagePrompt = new messageView();

    JButton nextDayBtn = new JButton();
    JButton registerFarmerBtn = new JButton();
    JButton seedInfoBtn = new JButton();

    seedInfoView seedInfoUI = new seedInfoView();

    JPanel messageAvatar;

    private String currentTool;
    private String currentTile;
    private String currentSeed;

    public String getCurrentTool() {
        return currentTool;
    }

    public String getCurrentTile() {
        return currentTile;
    }

    public String getCurrentSeed() {
        return currentSeed;
    }

    public void setCurrentTool(String currentTool) {
        this.currentTool = currentTool;
    }

    public void setCurrentTile(String currentTile) {
        this.currentTile = currentTile;
    }

    public void setCurrentSeed(String currentSeed) {
        this.currentSeed = currentSeed;
    }

    public GameGUI(Game game){
        this.game = game;

        // MAIN WINDOW SETTINGS
        mainFrame = new JFrame("My Farmer Game");
        mainFrame.setSize(new Dimension(1200,1000));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setContentPane(new JLabel(new ImageIcon("src/Views/tiles/Background.png"))); // Sets background of window
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen

        createUIElements();

        Farmer farmer = new Farmer("Alfred");
        //TODO: Display farmerName in a label

        // Update farmLot by updating through setFarmLot -> can be used for mapping too



        ActionListener buttonListener = new ActionListener() {
            String prevCmd = "";
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JButton btn:
                        toolListUI.getToolList()) {
                    if(e.getSource().equals(btn)){
                        // If btn is a tool
                        setCurrentTool(e.getActionCommand()); // Set current tool
                        System.out.println(getCurrentTool());
                        prevCmd = "Tool";
                    }
                }

                for (JButton btn :
                        seedStoreUI.getSeedList()) {
                    if(e.getSource().equals(btn)){
                        // If btn is a seed
                        setCurrentSeed(e.getActionCommand()); // Set current seed
                        System.out.println(getCurrentSeed());
                        prevCmd = "Seed";
                    }
                }

                for (int i = 0; i < farmLotUI.getRow(); i++) {
                    for (int j = 0; j < farmLotUI.getCol(); j++) {
                        if(e.getSource().equals((farmLotUI.getFarmTiles()[i][j]))){
                            // If btn is a tile
                            setCurrentTile(e.getActionCommand()); // Set current tile
                            System.out.println(getCurrentTile());

                            updateTile(i,j,farmLot.getFarmTiles()[i][j],farmLotUI.getFarmTiles()[i][j],prevCmd);

                        }

                    }
                }

                if(e.getSource()==seedInfoBtn) // If seed Information opened
                {
                    seedInfoUI.setDefaultCloseOperation(seedInfoUI.EXIT_ON_CLOSE);
                    seedInfoUI.setVisible(true);
                }


            }
        };

        ActionListener popupListener = new ActionListener() {
                @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==seedInfoBtn)
                {
                    seedInfoUI.popup.setVisible(true);
                    seedInfoUI.setBounds(100,100,500,500);
                }


            }
        };

        seedInfoBtn.addActionListener(popupListener);
        toolListUI.setActionListener(buttonListener);
        seedStoreUI.setActionListener(buttonListener);
        farmLotUI.setActionListener(buttonListener);
        mainFrame.setVisible(true);
    }

    public void updateTile(int x, int y, Tile currentTile, JButton btn, String prevCmd){
        if(prevCmd.equals("Tool")){

            switch(getCurrentTool()){
                case "Plow":
                    currentTile.setPlowed(true);
                    btn.setIcon(new ImageIcon("src/Views/tiles/Plowed Soil.png"));
                    break;
                case "Watering Can":

                    break;
                case "Fertilizer":

                    break;
                case "Pickaxe":
                    btn.setIcon(new ImageIcon("src/Views/tiles/Soil.png"));
                    break;
                case "Shovel":

                    break;
                case "Scythe":

                    break;
                default:
                    break;
            }
        }
        else if(prevCmd.equals("Seed")){
            currentTile.setPlantedCrop(null);
            btn.setIcon(new ImageIcon("src/Views/tiles/Seeds on Soil.png"));

        }
    }

    public void createUIElements(){
        /**
         * This function instantiates all the UI elements and their positions, then adds them to the main panel
         */

        // FARMER STATS (BOTTOM LEFT UI)
        statsUI.setBounds(50,650,575,150);
        statsUI.setBackground(Color.gray);

        // SEED STORE (BOTTOM RIGHT UI)
        seedStoreUI.setLayout(null);
        seedStoreUI.setBounds(650,575,500,225);
        seedStoreUI.setBackground(new Color(150,75,0));

        // TOOL LIST (MIDDLE RIGHT UI)
        toolListUI.setBounds(950,100,200,350);
        toolListUI.setBackground(Color.green);

        // DAY COUNTER (MIDDLE-UPPER LEFT UI)
        dayUI.setBounds(50,25,100,50);
        dayUI.setForeground(Color.white);
        // Add this to a class?
        dayUI.setFont(new Font("Arial", Font.PLAIN,20)); //TODO: Change Font?
        dayUI.setText("Day: 0"); //TODO: Make this dynamic

        // FARM LOT (MIDDLE UI)
        farmLotUI.generateLot();
        farmLotUI.setBounds(50,100,800,400);

        // LIL FARMER IMAGE
        messageAvatar = new JPanel(); //TODO: SET IMAGE HERE
        messageAvatar.setBounds(50,525,100,100);
        messageAvatar.setBackground(Color.PINK);

        // LIL FARMER TEXT PROMPTER
        messagePrompt.setBounds(175,525,450,100);

        // NEXT DAY BUTTON
        nextDayBtn.setText("Next Day");
        nextDayBtn.setBounds(950,475,200,75);
        nextDayBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // REGISTER FARMER BUTTON
        registerFarmerBtn.setText("Register Farmer");
        registerFarmerBtn.setBounds(50,830,200,75);
        registerFarmerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //SEED INFO BUTTON
        seedInfoBtn.setText("Seed Info");
        seedInfoBtn.setBounds(600,830,200,75);
        seedInfoBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));



        mainFrame.add(farmLotUI);
        mainFrame.add(statsUI);
        mainFrame.add(seedStoreUI);
        mainFrame.add(toolListUI);
        mainFrame.add(dayUI);
        mainFrame.add(messagePrompt);
        mainFrame.add(messageAvatar);
        mainFrame.add(nextDayBtn);
        mainFrame.add(registerFarmerBtn);
        mainFrame.add(seedInfoBtn);

    }
}

