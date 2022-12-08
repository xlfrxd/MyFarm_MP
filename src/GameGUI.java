import Models.*;
import Views.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GameGUI {

    Game game;

    JFrame mainFrame;

    Farmer farmer = new Farmer("Farmer");
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

    private int currentDay;

    private String currentToolName;
    private String currentSeedName;

    private Tool currentTool;

    private Crop currentSeed;
    private Tile currentTile;

    private Message currentMessage;
    public Message getCurrentMessage() {
        return currentMessage;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }

    public Crop getCurrentSeed() {
        return currentSeed;
    }

    public void setCurrentSeed(Crop currentSeed) {
        this.currentSeed = currentSeed;
    }

    public void setCurrentMessage(Message currentMessage) {
        this.currentMessage = currentMessage;
    }

    public String getCurrentTool() {
        return currentToolName;
    }

    public Tile getCurrentTile() {
        return currentTile;
    }

    public String getCurrentSeedName() {
        return currentSeedName;
    }

    public void setCurrentTool(String currentTool) {
        this.currentToolName = currentTool;
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }

    public void setCurrentSeedName(String currentSeedName) {
        this.currentSeedName = currentSeedName;
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
                        setCurrentSeedName(e.getActionCommand()); // Set current seed
                        for (Crop crop :
                                seedStore.getSeedList()) {
                            if (crop.getCropName().equals(currentSeedName)) { // Get the currentSeed from seedStore
                                currentSeed = new Crop(crop.getCropName(),crop.getCropType(),crop.getSeedCost(),crop.getExpYield(),crop.getBasePrice(),crop.getMinProduce(),crop.getMaxProduce(),crop.getWaterCount(),crop.getWaterReq(),crop.getWaterBonus(),crop.getFertCount(),crop.getFertReq(),crop.getFertBonus(),crop.getHarvCount(),crop.getHarvReq());

                            }
                        }
                        prevCmd = "Seed";
                    }
                }

                for (int i = 0; i < farmLotUI.getRow(); i++) {
                    for (int j = 0; j < farmLotUI.getCol(); j++) {
                        if(e.getSource().equals((farmLotUI.getFarmTiles()[i][j]))){
                            // If btn is a tile
                            setCurrentTile(farmLot.getFarmTiles()[i][j].getTile()); // Set current tile

                            for (Tool tool :
                                    farmer.getFarmerTools()) {
                                if (tool.getToolName().equals(currentToolName)) { // Get the currentTool from toolList
                                    currentTool = tool;

                                    break;
                                }
                            }



                            if(checkTile(currentTile,prevCmd)){ // checks if command can be executed to current tile
                                executeTile(currentTile,prevCmd);
                                updateTile(farmLotUI.getFarmTiles()[i][j],prevCmd); // updates current tile image
                                System.out.println(prevCmd + " was Successful"); // update messageprompt to user
                                messagePrompt.feedback.setText(prevCmd + " was Successful");
                            }
                            else{
                                System.out.println(prevCmd + " Failed"); // update messageprompt to user
                                messagePrompt.feedback.setText(prevCmd + " Failed");

                            }
                        }

                    }
                }

                if(e.getSource()==seedInfoBtn) // If seed Information opened
                {
                    seedInfoUI.setDefaultCloseOperation(seedInfoUI.EXIT_ON_CLOSE);
                    seedInfoUI.setVisible(true);
                }

                if(e.getSource()==nextDayBtn){
                    System.out.println("Day Pressed");
                    // Update day
                    for(int i=0; i < farmLot.getFarmRow(); i++){
                        for(int j=0; j < farmLot.getFarmCol(); j++){
                            if(farmLot.getFarmTiles()[i][j].getPlantedCrop()!=null){
                                farmLot.getFarmTiles()[i][j].getPlantedCrop().setHarvCount(farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvCount() + 1); // Add a day to each planted crop
                            }
                        }
                    }

                    // update farmer stats
                    updateAllTiles(); // updates tiles assets and information
                    dayUI.setDay(dayUI.getDay() + 1); // adds a day to counter
                    dayUI.setText("Day: "+ dayUI.getDay()); // displays day information

                }

                System.out.println("Bal:"+farmer.getFarmerObjectCoin());
                statsUI.balance.setText("Bal: " + farmer.getFarmerObjectCoin());
                System.out.println("Exp:"+farmer.getFarmerExp());
                statsUI.experience.setText("Exp: "+farmer.getFarmerExp());
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

        nextDayBtn.addActionListener(buttonListener);
        toolListUI.setActionListener(buttonListener);
        seedStoreUI.setActionListener(buttonListener);
        farmLotUI.setActionListener(buttonListener);
        mainFrame.setVisible(true);
    }

    public void executeTile(Tile currentTile, String prevCmd){
        clearLabel();
        switch(prevCmd) {
            case "Tool":
                switch (currentToolName) {
                    case "Plow":
                            currentTile.setPlowed(true);
                            this.farmer.setFarmerExp(this.farmer.getFarmerExp()+currentTool.getToolExp());
                        break;
                    case "Watering Can":
                        if(currentTile.getPlantedCrop().getWaterCount()!=currentTile.getPlantedCrop().getWaterBonus()){
                            currentTile.getPlantedCrop().setWaterCount(currentTile.getPlantedCrop().getWaterCount() + 1); // Adds the water count of the current tile crop
                            this.farmer.setFarmerExp(this.farmer.getFarmerExp()+currentTool.getToolExp());
                            System.out.println("This tile's water count is " + currentTile.getPlantedCrop().getWaterCount());
                            messagePrompt.feedback.setText("This tile's water count is " + currentTile.getPlantedCrop().getWaterCount());
                        }
                        break;
                    case "Fertilizer":
                        if(currentTile.getPlantedCrop().getFertCount()!=currentTile.getPlantedCrop().getFertBonus()) {
                            currentTile.getPlantedCrop().setFertCount(currentTile.getPlantedCrop().getFertCount() + 1);
                            this.farmer.setFarmerExp(this.farmer.getFarmerExp()+currentTool.getToolExp());

                        }
                        break;
                    case "Pickaxe":
                        this.farmer.setFarmerExp(this.farmer.getFarmerExp()+currentTool.getToolExp());

                        break;
                    case "Shovel":
                        this.farmer.setFarmerExp(this.farmer.getFarmerExp()+currentTool.getToolExp());

                        currentTile.setPlantedCrop(null);
                        break;
                    case "Scythe":
                        Random random = new Random();
                        double harvestTotal = 0, finalHarvestPrice = 0;
                        double waterBonus, fertilizerBonus;
                        int productsProduced = random.nextInt(currentTile.getPlantedCrop().getMaxProduce() + 1 - currentTile.getPlantedCrop().getMinProduce()) + currentTile.getPlantedCrop().getMinProduce(); // randomly generated produce from min and max yield
                        double basePricePerPiece = currentTile.getPlantedCrop().getBasePrice();

                        System.out.println("Prices per piece: " + productsProduced);
                        messagePrompt.feedback.setText("Prices per piece: " + productsProduced);


                        // Computing Harvest Price per Specs
                        harvestTotal = productsProduced * (basePricePerPiece + this.farmer.getFarmerType().getFarmerBonusEarnings());
                        waterBonus = harvestTotal * 0.2 * (currentTile.getPlantedCrop().getWaterCount() - 1);
                        fertilizerBonus = harvestTotal * 0.5 * currentTile.getPlantedCrop().getFertCount();
                        finalHarvestPrice = harvestTotal + waterBonus + + fertilizerBonus;

                        if(currentTile.getPlantedCrop().getCropType().equals("Flower")) { // Flower premium
                            finalHarvestPrice = finalHarvestPrice * 1.1;
                        }

                        System.out.println("Earned " + finalHarvestPrice + " from " + productsProduced + " " + currentTile.getPlantedCrop().getCropName() + "!");
                        messagePrompt.feedback.setText("Earned " + finalHarvestPrice + " from " + productsProduced + " " + currentTile.getPlantedCrop().getCropName() + "!");

                        // Update farmer stats
                        this.farmer.setFarmerExp(this.farmer.getFarmerExp()+currentTile.getPlantedCrop().getExpYield());
                        this.farmer.setFarmerObjectCoin(this.farmer.getFarmerObjectCoin()+finalHarvestPrice);
                        currentTile.setPlantedCrop(null);
                        break;
                    default:
                        break;
                }

                break;
            case "Seed":
                farmer.setFarmerObjectCoin(this.farmer.getFarmerObjectCoin()-this.currentSeed.getSeedCost()); // deduct seedCost from balance
                for (Crop crop :
                        seedStore.getSeedList()) {
                    if (crop.getCropName().equals(currentSeedName)) { // Get the currentSeed from seedStore
                        currentSeed = new Crop(crop.getCropName(),crop.getCropType(),crop.getSeedCost(),crop.getExpYield(),crop.getBasePrice(),crop.getMinProduce(),crop.getMaxProduce(),crop.getWaterCount(),crop.getWaterReq(),crop.getWaterBonus(),crop.getFertCount(),crop.getFertReq(),crop.getFertBonus(),crop.getHarvCount(),crop.getHarvReq());

                    }
                }
                currentTile.setPlantedCrop(currentSeed); // Plants the current Crop to the current Tile
                currentTile.setPlowed(false);
                currentTile.setHasRock(false);

                break;
            default:

                break;
        }
    }

    public boolean checkTile(Tile currentTile, String prevCmd){
        boolean valid = false;
        clearLabel();

        switch(prevCmd){
            case "Tool":
                switch(currentToolName){
                    case "Plow":
                        if(this.farmer.getFarmerObjectCoin() >= currentTool.getToolCost()) { // if farmer can use tool based on its cost
                            if (!currentTile.getIsPlowed()) {
                                valid = true;
                            }
                        }
                        break;
                    case "Watering Can":
                        if(this.farmer.getFarmerObjectCoin() >= currentTool.getToolCost()) { // if farmer can use tool based on its cost

                            if (currentTile.getPlantedCrop() != null) {

                                if (currentTile.getPlantedCrop().getWaterCount() != currentTile.getPlantedCrop().getWaterBonus()) {
                                    valid = true;
                                }
                            }
                        }
                        break;
                    case "Fertilizer":
                        if(this.farmer.getFarmerObjectCoin() >= currentTool.getToolCost()) { // if farmer can use tool based on its cost

                            if (currentTile.getPlantedCrop() != null) {

                                if (currentTile.getPlantedCrop().getFertCount() != currentTile.getPlantedCrop().getFertBonus()) {
                                    valid = true;
                                }
                            }
                        }
                        break;
                    case "Pickaxe":
                        if(this.farmer.getFarmerObjectCoin() >= currentTool.getToolCost()) { // if farmer can use tool based on its cost
                            if (currentTile.getHasRock()) {
                                valid = true;
                            }
                        }
                        break;
                    case "Shovel":
                        if(this.farmer.getFarmerObjectCoin() >= currentTool.getToolCost()) { // if farmer can use tool based on its cost

                            if (currentTile.getPlantedCrop() != null) {
                                valid = true;
                            }
                        }
                        break;
                    case "Scythe":
                        if(currentTile.getPlantedCrop()!=null){
                            if(currentTile.getPlantedCrop().getHarvCount()==currentTile.getPlantedCrop().getHarvReq() && currentTile.getPlantedCrop().getWaterCount()>=currentTile.getPlantedCrop().getWaterReq() && currentTile.getPlantedCrop().getFertCount()>=currentTile.getPlantedCrop().getFertReq()) {
                                valid = true;
                            }
                        }
                        break;
                    default:
                        break;
                }

                break;
            case "Seed":
                if(this.farmer.getFarmerObjectCoin() >= currentSeed.getSeedCost()){ // if farmer can purchase seed based on seedCost
                    if(!currentTile.getHasRock()){ // Checks if current tile does not have a rock
                        if(currentTile.getIsPlowed()){ // Checks if current tile is plowed
                            if(currentTile.getPlantedCrop()==null){ // Checks if current tile is empty
                                valid = true;
                            }
                        }
                    }
                }
                else{
                    System.out.println("No money!\n");
                    messagePrompt.feedback.setText("No money!\n");

                }
                break;
            default:
                valid = false;
                break;
        }
        return valid;
    }

    public void updateAllTiles(){

        clearLabel();
        /*
        Updates all tile info and assets if they are withering or growing
         */
        for(int i = 0; i < farmLotUI.getRow(); i++) {
            for (int j = 0; j < farmLotUI.getCol(); j++){
                if(farmLot.getFarmTiles()[i][j].getPlantedCrop()!=null) { // if tile has an occupied crop

                    if(farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvCount()==farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvReq()/2){
                        farmLotUI.getFarmTiles()[i][j].setIcon(new ImageIcon("src/Views/tiles/Seedling.png"));// Update plant icon to seedling
                        System.out.println(farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " is halfway from harvest!");
                        messagePrompt.feedback.setText(farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " is halfway from harvest!");
                    }
                    else if(farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvCount()==farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvReq() && farmLot.getFarmTiles()[i][j].getPlantedCrop().getWaterCount()>=farmLot.getFarmTiles()[i][j].getPlantedCrop().getWaterReq() && farmLot.getFarmTiles()[i][j].getPlantedCrop().getFertCount()>=farmLot.getFarmTiles()[i][j].getPlantedCrop().getFertReq()){
                        farmLotUI.getFarmTiles()[i][j].setIcon(new ImageIcon(""));// Update plant icon to harvestable
                        System.out.println(farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " is harvestable!");
                        messagePrompt.feedback.setText(farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " is harvestable!");
                    }
                    else if(farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvCount()==farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvReq() && (farmLot.getFarmTiles()[i][j].getPlantedCrop().getWaterCount()<farmLot.getFarmTiles()[i][j].getPlantedCrop().getWaterReq() || farmLot.getFarmTiles()[i][j].getPlantedCrop().getFertCount()<farmLot.getFarmTiles()[i][j].getPlantedCrop().getFertReq())){
                        farmLotUI.getFarmTiles()[i][j].setIcon(new ImageIcon(""));// Update plant icon to withered
                        farmLot.getFarmTiles()[i][j].setWithered(true); // Update plant info
                        System.out.println(farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " withered");
                        messagePrompt.feedback.setText(farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " withered");
                    }
                    else if(farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvCount()>farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvReq()){
                        farmLotUI.getFarmTiles()[i][j].setIcon(new ImageIcon(""));// Update plant icon to withered
                        farmLot.getFarmTiles()[i][j].setWithered(true); // Update plant info
                        System.out.println(farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " withered");
                        messagePrompt.feedback.setText(farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " withered");
                    }
                }
            }
        }
    }

    public void updateTile(JButton currentBtn, String prevCmd){
        /**
         * This function updates the current tile's assets when tile interaction occurs
         */

        /*
        Tile interaction with tools and seed planting
         */
        if(prevCmd.equals("Tool")){

            // TODO: BE SURE TO CHECK CONDITIONS ACCDG TO SPECS BEFORE USING TOOLS, IMPLEMENT A CHECKING FUNCTION
            // TODO: CREATE A FUNCTION THAT WOULD DO THE FUNCTIONALITIES OF THESE BUTTONS AND TOOLS
            // TODO: UPDATE USER MESSAGE PROMPT
            switch(getCurrentTool()){
                case "Plow":
                    currentBtn.setIcon(new ImageIcon("src/Views/tiles/Plowed Soil.png"));
                    break;
                case "Watering Can":
                    // Soil watered?
                    break;
                case "Fertilizer":
                    // Soil fertilized?
                    break;
                case "Pickaxe":
                    currentBtn.setIcon(new ImageIcon("src/Views/tiles/Soil.png"));
                    break;
                case "Shovel":
                    currentBtn.setIcon(new ImageIcon("src/Views/tiles/Soil.png"));
                    break;

                case "Scythe":
                    currentBtn.setIcon(new ImageIcon("src/Views/tiles/Soil.png"));
                    break;
                default:
                    break;
            }
        }
        else if(prevCmd.equals("Seed")){
                currentBtn.setIcon(new ImageIcon("src/Views/tiles/Seeds on Soil.png")); // Update the farmLotUI button
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
        dayUI.setFont(new Font("Arial", Font.PLAIN,20)); //TODO: Change Font?

        // initialize the first day once jframe opens
        dayUI.setDay(1);
        dayUI.setText("Day: "+dayUI.getDay());
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
        messagePrompt.setForeground(Color.black);
        messagePrompt.setVisible(true);

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
//            ImageIO.write(
//                    bufferedImageResult,
//                    formatName,
//                    new File(imagePath)
//            );

            btn.setIcon(new ImageIcon(bufferedImageResult));
            btn.setOpaque(false);
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(false);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btn.setIcon(new ImageIcon(imagePath)); // scale this image to fit button


    }

    public int getCurrentDay() {
        return currentDay;
    }

    //@Override
    public void clearLabel() {
        messagePrompt.feedback.setText("");

    }


    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }
}

