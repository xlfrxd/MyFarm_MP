import Models.*;
import Views.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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

    JButton nextDayBtn = new JButton("Next Day");
    JButton registerFarmerBtn = new JButton("Register Farmer");
    JButton seedInfoBtn = new JButton("Seed Info");

    seedInfoView seedInfoUI = new seedInfoView();

    JLabel messageAvatar;



    SeedStore seedStore = new SeedStore();

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

                            updateTile(i,j,farmLot.getFarmTiles()[i][j].getTile(),farmLotUI.getFarmTiles()[i][j],prevCmd);

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

            // TODO: BE SURE TO CHECK CONDITIONS ACCDG TO SPECS BEFORE USING TOOLS, IMPLEMENT A CHECKING FUNCTION
            // TODO: CREATE A FUNCTION THAT WOULD DO THE FUNCTIONALITIES OF THESE BUTTONS AND TOOLS
            switch(getCurrentTool()){
                case "Plow":
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
            for (Crop crop:
                 seedStore.getSeedList()) {
                if(crop.getCropName().equals(currentSeed)) { // Get the currentSeed from seedStore
                    currentTile.setPlantedCrop(crop); // Plants the current Crop to the current Tile
                    break;
                }
            }
                btn.setIcon(new ImageIcon("src/Views/tiles/Seeds on Soil.png")); // Update the farmLotUI button
            // TODO: CREATE PLANT FUNCTION FOR THIS
                System.out.println(currentTile.getPlantedCrop().getCropName() + " was planted at tile ("  + x + "," + y + ")");

        }
    }

    public void createUIElements(){
        /**
         * This function instantiates all the UI elements and their positions, then adds them to the main panel
         */

        // FARMER STATS (BOTTOM LEFT UI)
        statsUI.setLayout(null);
        statsUI.setBounds(50,650,575,150);
        statsUI.setBackground(Color.gray);

        // SEED STORE (BOTTOM RIGHT UI)
        seedStoreUI.setLayout(null);
        seedStoreUI.setBounds(650,575,500,225);
        seedStoreUI.setBackground(new Color(150,75,0));

        // TOOL LIST (MIDDLE RIGHT UI)
        toolListUI.setLayout(null);
        toolListUI.setBounds(950,100,200,300);
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

        messageAvatar = new JLabel(); //TODO: SET IMAGE HERE
        messageAvatar.setBounds(50,525,100,100);
        messageAvatar.setIcon(new ImageIcon("src/Views/assets/Player Icon.png"));

        // LIL FARMER TEXT PROMPTER
        messagePrompt.setLayout(null);
        messagePrompt.setBounds(175,525,450,100);

        // NEXT DAY BUTTON
        nextDayBtn.setLayout(null);
        generateButtonImage(100,nextDayBtn, "src/Views/assets/Next Day.png");
        nextDayBtn.setForeground(Color.BLACK);
        nextDayBtn.setBounds(980,400,200,150);
        nextDayBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


        // REGISTER FARMER BUTTON
        registerFarmerBtn.setLayout(null);
        generateButtonImage(100,registerFarmerBtn, "src/Views/assets/Register Farmer.png");
        registerFarmerBtn.setForeground(Color.BLACK);
        registerFarmerBtn.setBounds(100,830,250,75);
        registerFarmerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //SEED INFO BUTTON
        seedInfoBtn.setLayout(null);
        generateButtonImage(100,seedInfoBtn, "src/Views/assets/Help.png");
        seedInfoBtn.setForeground(Color.BLACK);
        seedInfoBtn.setBounds(380,830,200,75);
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

    public void generateButtonImage(int PIX_SIZE,JButton btn, String imagePath){

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

