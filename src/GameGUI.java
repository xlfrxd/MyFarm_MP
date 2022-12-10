import Models.*;
import Views.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GameGUI {

    Game game;

    JFrame mainFrame;

    Farmer farmer = new Farmer("Farmer");
    FarmerStatistics farmerStats = new FarmerStatistics();

    statsView statsUI = new statsView();
    seedStoreView seedStoreUI = new seedStoreView();
    toolListView toolListUI = new toolListView();
    dayView dayUI = new dayView();
    JLabel dayBackground = new JLabel();

    FarmLot farmLot = new FarmLot();
    String[][] farmMap = new String[farmLot.getFarmRow()][farmLot.getFarmCol()];

    FarmLotView farmLotUI = new FarmLotView();
    messageView messagePrompt = new messageView();
    JButton nextDayBtn = new JButton();

    JButton registerFarmerBtn = new JButton();
    JButton seedInfoBtn = new JButton();
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

    DecimalFormat df = new DecimalFormat("0.00");

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
        mainFrame = new JFrame("Sprout Valley");
        mainFrame.setSize(new Dimension(1200,1000));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setContentPane(new JLabel(new ImageIcon("src/Views/tiles/Background.png"))); // Sets background of window
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen

        createUIElements();

        ActionListener buttonListener = new ActionListener() {
            String prevCmd = "";
            @Override
            public void actionPerformed(ActionEvent e) {

                for (JButton btn:
                        toolListUI.getToolList()) {
                    if(e.getSource().equals(btn)){
                        // If btn is a tool
                        setCurrentTool(e.getActionCommand()); // Set current tool

                        String toolPath = "src/Views/tools/" + currentToolName + ".png";
                        setCursor(toolPath);
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

                                System.out.println(currentSeedName);
                                String toolPath = "src/Views/seeds/" + currentSeedName + " Seeds.png";
                                setCursor(toolPath);
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

                            if(checkTile(i,j,currentTile,prevCmd)){ // checks if command can be executed to current tile
                                updateAllTiles(); // updates tiles assets and information
                                executeTile(farmLotUI.getFarmTiles()[i][j],currentTile,prevCmd);
                                updateTile(farmLotUI.getFarmTiles()[i][j],prevCmd); // updates current tile image
                            }
                            else{
                                Random randomPrompt = new Random();
                                switch(randomPrompt.nextInt(2)){
                                    case 0:
                                        messagePrompt.feedback.setText("Oops! That didn't work!");
                                        break;
                                    case 1:
                                        messagePrompt.feedback.setText("Can you try that again?");
                                        break;
                                }

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
                    dayUI.setText("Day "+ dayUI.getDay()); // displays day information

                }

                if(e.getSource()==registerFarmerBtn){
                    if(farmer.getFarmerLevel()%5==0){
                        FarmerType ableType = null;
                        for (FarmerType type:
                                farmer.getFarmerTypes()) {
                            if(type.getFarmerLevelReq()==farmer.getFarmerLevel()/5){
                                farmer.setFarmerType(type);
                                farmer.setFarmerObjectCoin(farmer.getFarmerObjectCoin()-type.getFarmerRegFee());
                                messagePrompt.feedback.setText("You have registered as " + type.getFarmerTypeName());
                                statsUI.farmerType.setText(" "+ type.getFarmerTypeName());
                                break;
                            }
                        }
                    }
                    messagePrompt.feedback.setText("You are unable to register at this time.");

                }

                // CHECK IF ALL PLANTS WITHERED

                boolean allPlantsWithered=false;
                for(Tile[] tiles: farmLot.getFarmTiles()){
                    for(Tile tile: tiles){
                        if(tile.getPlantedCrop()!=null) {
                            allPlantsWithered = tile.getIsWithered();
                        }
                    }
                }


                // GAME END
                if(allPlantsWithered){
                        if(farmer.getFarmerObjectCoin()<=5){
                            // END CONDITION
                            JFrame endFrame = new JFrame("Game over, try again?");
                            endFrame.setVisible(true);
                        }
                }



                System.out.println("Balance:"+farmer.getFarmerObjectCoin());
                System.out.println("Experience:"+farmer.getFarmerExp());
                System.out.println("Level:"+farmer.getFarmerLevel());
                statsUI.balance.setText("Balance: " + df.format(farmer.getFarmerObjectCoin()));
                statsUI.experience.setText("Experience: "+farmer.getFarmerExp());
                statsUI.level.setText("Level: "+farmer.getFarmerLevel());
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
        registerFarmerBtn.addActionListener(buttonListener);

        toolListUI.setActionListener(buttonListener);
        seedStoreUI.setActionListener(buttonListener);
        farmLotUI.setActionListener(buttonListener);
        mainFrame.setVisible(true);
    }

    public void setCursor(String filePath){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(filePath);;
        Cursor c = toolkit.createCustomCursor(image, new Point(0,
                0), "cursor");
        mainFrame.setCursor(c);
        toolListUI.setCursor(c);
        seedStoreUI.setCursor(c);
        farmLotUI.setCursor(c);
    }

    public void executeTile(JButton currentBtn, Tile currentTile, String prevCmd){
        /**
         * Executes tool commands to selected tile then updates information necessary
         */


        switch (prevCmd) {
            case "Tool" -> {
                if (!currentToolName.equals("Scythe")){
                    this.messagePrompt.feedback.setText(currentToolName + " was used"); // update user with tool usage information
                }


                switch (currentToolName) {
                    case "Plow":
                        currentTile.setPlowed(true);
                        this.farmer.setFarmerExp(this.farmer.getFarmerExp() + currentTool.getToolExp());
                        currentBtn.setToolTipText("<html>A plowed tile<br><br><i>Try planting on the plot to start growing crops</i></html>");

                        break;
                    case "Watering Can":
                        if (currentTile.getPlantedCrop().getWaterCount() != currentTile.getPlantedCrop().getWaterBonus()) {
                            currentTile.getPlantedCrop().setWaterCount(currentTile.getPlantedCrop().getWaterCount() + 1); // Adds the water count of the current tile crop
                            this.farmer.setFarmerExp(this.farmer.getFarmerExp() + currentTool.getToolExp());
                            currentBtn.setToolTipText("<html>" + currentTile.getPlantedCrop().getCropName() + "<br>" + "Times Watered: " + currentTile.getPlantedCrop().getWaterCount() + "<br>" + "Times Fertilized: " + currentTile.getPlantedCrop().getFertCount() + "<br><br><i>" + String.valueOf(currentTile.getPlantedCrop().getHarvReq() - currentTile.getPlantedCrop().getHarvCount()) + " days until harvest</i></html>");

                        }
                        break;
                    case "Fertilizer":
                        if (currentTile.getPlantedCrop().getFertCount() != currentTile.getPlantedCrop().getFertBonus()) {
                            currentTile.getPlantedCrop().setFertCount(currentTile.getPlantedCrop().getFertCount() + 1);
                            this.farmer.setFarmerExp(this.farmer.getFarmerExp() + currentTool.getToolExp());
                            currentBtn.setToolTipText("<html>" + currentTile.getPlantedCrop().getCropName() + "<br>" + "Times Watered: " + currentTile.getPlantedCrop().getWaterCount() + "<br>" + "Times Fertilized: " + currentTile.getPlantedCrop().getFertCount() + "<br><br><i>" + String.valueOf(currentTile.getPlantedCrop().getHarvReq() - currentTile.getPlantedCrop().getHarvCount()) + " days until harvest</i></html>");

                        }
                        break;
                    case "Pickaxe":
                        this.farmer.setFarmerObjectCoin(this.farmer.getFarmerObjectCoin() - currentTool.getToolCost());
                        this.farmer.setFarmerExp(this.farmer.getFarmerExp() + currentTool.getToolExp());
                        currentBtn.setToolTipText("<html>An empty tile<br><br><i>Try plowing the plot to start growing crops</i></html>");
                        currentTile.setHasRock(false);
                        break;
                    case "Shovel":
                        this.farmer.setFarmerObjectCoin(this.farmer.getFarmerObjectCoin() - currentTool.getToolCost());
                        this.farmer.setFarmerExp(this.farmer.getFarmerExp() + currentTool.getToolExp());
                        currentTile.setPlantedCrop(null);
                        currentBtn.setToolTipText("<html>An empty tile<br><br><i>Try plowing the plot to start growing crops</i></html>");

                        break;
                    case "Scythe":
                        Random random = new Random();
                        double harvestTotal, finalHarvestPrice;
                        double waterBonus, fertilizerBonus;
                        int productsProduced = random.nextInt(currentTile.getPlantedCrop().getMaxProduce() + 1 - currentTile.getPlantedCrop().getMinProduce()) + currentTile.getPlantedCrop().getMinProduce(); // randomly generated produce from min and max yield
                        double basePricePerPiece = currentTile.getPlantedCrop().getBasePrice();


                        // Computing Harvest Price per Specs
                        harvestTotal = productsProduced * (basePricePerPiece + this.farmer.getFarmerType().getFarmerBonusEarnings());
                        waterBonus = harvestTotal * 0.2 * (currentTile.getPlantedCrop().getWaterCount() - 1);
                        fertilizerBonus = harvestTotal * 0.5 * currentTile.getPlantedCrop().getFertCount();
                        finalHarvestPrice = harvestTotal + waterBonus + +fertilizerBonus;

                        if (currentTile.getPlantedCrop().getCropType().equals("Flower")) { // Flower premium
                            finalHarvestPrice = finalHarvestPrice * 1.1;
                        }

                        if(currentTile.getPlantedCrop()==null){
                            currentBtn.setToolTipText("<html>An empty tile<br><br><i>Try plowing the plot to start growing crops</i></html>");
                        }


                        // Update farmer stats
                        this.farmer.setFarmerExp(this.farmer.getFarmerExp() + currentTile.getPlantedCrop().getExpYield());
                        this.farmer.setFarmerObjectCoin(this.farmer.getFarmerObjectCoin() + finalHarvestPrice);
                        this.messagePrompt.feedback.setText("Earned " + df.format(finalHarvestPrice) + " from " + productsProduced + " pcs of " + currentTile.getPlantedCrop().getCropName() + "!");
                        currentTile.setPlantedCrop(null);
                        currentTile.setWithered(false);
                        farmerStats.setTimesHarvested(farmerStats.getTimesHarvested()+1);
                        statsUI.harvested.setText("Harvested: " + farmerStats.getTimesHarvested() + " crop/s" );
                        //clearLabel();
                        break;
                    default:
                        break;
                }
            }
            case "Seed" -> {
                for (Crop crop :
                        seedStore.getSeedList()) {
                    if (crop.getCropName().equals(this.currentSeedName)) { // Get the currentSeed from seedStore
                        currentSeed = new Crop(crop.getCropName(), crop.getCropType(), crop.getSeedCost(), crop.getExpYield(), crop.getBasePrice(), crop.getMinProduce(), crop.getMaxProduce(), crop.getWaterCount(), crop.getWaterReq(), crop.getWaterBonus()+this.farmer.getFarmerType().getFarmerWaterBonusLimit(), crop.getFertCount(), crop.getFertReq(), crop.getFertBonus()+this.farmer.getFarmerType().getFarmerFertBonusLimit(), crop.getHarvCount(), crop.getHarvReq());
                    }
                }

                this.messagePrompt.feedback.setText(this.currentSeedName + " was planted"); // update user with seed planted information
                currentTile.setPlantedCrop(currentSeed); // Plants the current Crop to the current Tile
                this.farmer.setFarmerObjectCoin(this.farmer.getFarmerObjectCoin() - (this.currentSeed.getSeedCost()-this.farmer.getFarmerType().getFarmerSeedCostReduction())); // deduct seedCost from balance
                currentBtn.setToolTipText("<html>" + currentTile.getPlantedCrop().getCropName() + "<br>" + "Times Watered: " + currentTile.getPlantedCrop().getWaterCount() + "<br>" + "Times Fertilized: " + currentTile.getPlantedCrop().getFertCount() + "<br><br><i>" + String.valueOf(currentTile.getPlantedCrop().getHarvReq() - currentTile.getPlantedCrop().getHarvCount()) + " days until harvest</i></html>");
                currentTile.setPlowed(false);
                currentTile.setHasRock(false);
            }
            default -> {
            }
        }

        updateFarmerLevel();



        if(this.farmer.getFarmerLevel()%5==0 && this.farmer.getFarmerLevel()!=0){
            FarmerType ableType = null;
            for (FarmerType type:
                 farmer.getFarmerTypes()) {
                if(type.getFarmerLevelReq()==this.farmer.getFarmerLevel()/5){
                    ableType = type;
                    break;
                }
            }
            if(ableType!=null){
                this.messagePrompt.feedback.setText("You can register as a " + ableType.getFarmerTypeName() + " farmer type!");
            }
        }
    }

    public void updateFarmerLevel(){
        /**
         * Updates farmer level accdg to next level
         */
        if(this.farmer.getFarmerLevel()==0){
            this.farmer.setFarmerLevel((int) this.farmer.getFarmerExp() / ((this.farmer.getFarmerLevel() + 1) * 100));
        }
        else if(this.farmer.getFarmerExp()/((this.farmer.getFarmerLevel()+1)*100) >= this.farmer.getFarmerLevel()) {
            this.farmer.setFarmerLevel(this.farmer.getFarmerLevel() + 1);
        }

    }


    public boolean checkTile(int row, int col, Tile currentTile, String prevCmd){
        boolean valid = false;
        switch(prevCmd){
            case "Tool":
                switch(currentToolName){
                    case "Plow":
                        if(this.farmer.getFarmerObjectCoin() >= currentTool.getToolCost()) { // if farmer can use tool based on its cost
                            if (!currentTile.getIsPlowed() && !currentTile.getHasRock() && currentTile.getPlantedCrop()==null) {
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

                            if (currentTile.getPlantedCrop() != null && !currentTile.getHasRock()) {

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

                            if (currentTile.getPlantedCrop() != null && !currentTile.getHasRock()) {
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
                                if(currentSeedName.equals("Mangoes") || currentSeedName.equals("Apples")){
                                    // if the current seed is a tree seed
                                    valid = checkSurroundingTiles(row,col);

                                }
                            }
                        }
                    }
                }
                break;
            default:
                valid = false;
                break;
        }
        return valid;
    }

    public boolean checkSurroundingTiles(int x, int y){
        if(x == 0 || y == 0 || x == this.farmLot.getFarmRow() || y == this.farmLot.getFarmCol()){
            return false;
        }
        else{
            if(this.farmLot.getFarmTiles()[x - 1][y].getPlantedCrop() == null || this.farmLot.getFarmTiles()[x][y - 1].getPlantedCrop() == null || this.farmLot.getFarmTiles()[x - 1][y - 1].getPlantedCrop() == null || this.farmLot.getFarmTiles()[x][y].getPlantedCrop() == null || this.farmLot.getFarmTiles()[x + 1][x - 1].getPlantedCrop() == null || this.farmLot.getFarmTiles()[x - 1][y + 1].getPlantedCrop() == null){
                return false;
            }
        }
        return true;
    }

    public void updateAllTiles(){
        /*
        Updates all tile info, assets, and seed information in tooltips
         */
        for(int i = 0; i < farmLotUI.getRow(); i++) {
            for (int j = 0; j < farmLotUI.getCol(); j++){
                if(farmLot.getFarmTiles()[i][j].getPlantedCrop()!=null) { // if tile has an occupied crop

                    if(farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvCount()==farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvReq()/2){
                        farmLotUI.getFarmTiles()[i][j].setIcon(new ImageIcon("src/Views/tiles/Seedling.png"));// Update plant icon to seedling

                    }
                    else if(farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvCount()==farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvReq() && farmLot.getFarmTiles()[i][j].getPlantedCrop().getWaterCount()>=farmLot.getFarmTiles()[i][j].getPlantedCrop().getWaterReq() && farmLot.getFarmTiles()[i][j].getPlantedCrop().getFertCount()>=farmLot.getFarmTiles()[i][j].getPlantedCrop().getFertReq()){
                        String filePath = "src/Views/tiles/" + farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " on Soil.png";
                        farmLotUI.getFarmTiles()[i][j].setIcon(new ImageIcon(filePath));// Update plant icon to harvestable

                        farmLotUI.getFarmTiles()[i][j].setToolTipText("<html>"+farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " is harvestable!<br><br><i>Use a scythe to harvest the plant</i></html>");

                        messagePrompt.feedback.setText(farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " is harvestable!");
                    }
                    else if(farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvCount()==farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvReq() && (farmLot.getFarmTiles()[i][j].getPlantedCrop().getWaterCount()<farmLot.getFarmTiles()[i][j].getPlantedCrop().getWaterReq() || farmLot.getFarmTiles()[i][j].getPlantedCrop().getFertCount()<farmLot.getFarmTiles()[i][j].getPlantedCrop().getFertReq())){
                        farmLotUI.getFarmTiles()[i][j].setIcon(new ImageIcon("src/Views/tiles/Withered.png"));// Update plant icon to withered
                        farmLot.getFarmTiles()[i][j].setWithered(true); // Update plant info
                        farmLotUI.getFarmTiles()[i][j].setToolTipText("<html>"+farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " has withered<br><br><i>Use a shovel to remove the plant</i></html>");

                        messagePrompt.feedback.setText(farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " withered");
                    }
                    else if(farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvCount()>farmLot.getFarmTiles()[i][j].getPlantedCrop().getHarvReq()){
                        farmLotUI.getFarmTiles()[i][j].setIcon(new ImageIcon("src/Views/tiles/Withered.png"));// Update plant icon to withered
                        farmLot.getFarmTiles()[i][j].setWithered(true); // Update plant info

                        farmLotUI.getFarmTiles()[i][j].setToolTipText("<html>"+farmLot.getFarmTiles()[i][j].getPlantedCrop().getCropName() + " has withered<br><br><i>Use a shovel to remove the plant</i></html>");

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
            switch(getCurrentTool()){
                case "Plow":
                    currentBtn.setIcon(new ImageIcon("src/Views/tiles/Plowed Soil.png"));
                    currentBtn.setToolTipText("<html>A plowed tile<br><br><i>Try planting on the plot to start growing crops</i></html>");

                    break;
                case "Watering Can":
                    // Soil watered?
                    break;
                case "Fertilizer":
                    // Soil fertilized?
                    break;
                case "Pickaxe":
                case "Shovel":
                case "Scythe":
                    currentBtn.setIcon(new ImageIcon("src/Views/tiles/Soil.png"));
                    break;
                default:
                    break;
            }
        }
        else if(prevCmd.equals("Seed")){
            currentBtn.setIcon(new ImageIcon("src/Views/tiles/Seeds on Soil.png")); // Update the farmLotUI button
            currentBtn.setToolTipText("<html>" + this.currentTile.getPlantedCrop().getCropName() + "\n" + "Times Watered: " + this.currentTile.getPlantedCrop().getWaterCount() + "<br>" + "Times Fertilized: " + this.currentTile.getPlantedCrop().getFertCount() + "<br><br><i>" + String.valueOf(this.currentTile.getPlantedCrop().getHarvReq() - this.currentTile.getPlantedCrop().getHarvCount()) + " days until harvest</i></html>");
            farmerStats.setTimesPlanted(farmerStats.getTimesPlanted()+1);
            statsUI.planted.setText("Planted: " + farmerStats.getTimesPlanted() + " seed/s" );

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

        //statsUI.farmerType.setText("Farmer");
        statsUI.balance.setText("Balance: " + df.format(farmer.getFarmerObjectCoin()));
        statsUI.experience.setText("Experience: "+farmer.getFarmerExp());
        statsUI.planted.setText("Planted: " + farmerStats.getTimesPlanted() + " seed/s" );
        statsUI.harvested.setText("Harvested: " + farmerStats.getTimesHarvested() + " crop/s" );


        // SEED STORE (BOTTOM RIGHT UI)
        seedStoreUI.setLayout(null);
        seedStoreUI.setBounds(650,575,500,225);
        seedStoreUI.setBackground(new Color(150,75,0));

        // TOOL LIST (MIDDLE RIGHT UI)
        toolListUI.setLayout(null);
        toolListUI.setBounds(950,100,200,300);
        toolListUI.setBackground(Color.green);

        // DAY COUNTER (MIDDLE-UPPER LEFT UI)
        dayUI.setBounds(70,20,100,50);
        dayUI.setForeground(Color.WHITE);
        dayUI.setFont(new Font("Helvetica", Font.BOLD,20));
        dayBackground = new JLabel(); //TODO: SET IMAGE HERE
        dayBackground.setBounds(50,25,100,50);
        dayBackground.setIcon(new ImageIcon("src/Views/assets/Day.png"));

        // initialize the first day once jframe opens
        dayUI.setDay(1);
        dayUI.setText("Day "+dayUI.getDay());

        // FARM LOT (MIDDLE UI)
        farmLotUI.generateLot();
        setMap(farmMap);
        loadMap(farmMap);
        farmLotUI.setBounds(50,110,800,400);
        farmLotUI.setOpaque(false);

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
        nextDayBtn.setBounds(930,400,200,150);
        nextDayBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // REGISTER FARMER BUTTON
        registerFarmerBtn.setLayout(null);
        generateButtonImage(100,registerFarmerBtn, "src/Views/assets/Register Farmer.png");
        registerFarmerBtn.setBounds(100,830,250,75);
        registerFarmerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //SEED INFO BUTTON
        seedInfoBtn.setLayout(null);
        generateButtonImage(100,seedInfoBtn, "src/Views/assets/Help.png");
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
        mainFrame.add(dayBackground);

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

    public void loadMap(String[][] map){
        for(int i = 0; i < farmLot.getFarmRow(); i++){
            for(int j = 0; j < farmLot.getFarmCol(); j++){
                if(map[i][j].equals("1")){
                    farmLot.getFarmTiles()[i][j].setHasRock(true);
                    farmLot.getFarmTiles()[i][j].setPlantedCrop(null);
                    farmLotUI.getFarmTiles()[i][j].setIcon(new ImageIcon("src/Views/tiles/Rock on Soil.png"));
                    farmLotUI.getFarmTiles()[i][j].setToolTipText("<html>A rock tile<br><br><i>Try removing it first before you start growing crops</i></html>");;
                }
                else{
                    farmLotUI.getFarmTiles()[i][j].setToolTipText("<html>An empty tile<br><br><i>Try plowing the plot to start growing crops</i></html>");
                }
            }
        }

    }
    
    public void setMap(String[][] map){
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("src/Views/maps/default_map.txt"));
            String line = reader.readLine();
            int i=0,j;
            while (line != null) {
                j=0;
                for (char c :
                        line.toCharArray()) {
                    if(j==10){
                        break;
                    }
                    map[i][j]=String.valueOf(c);
                    j++;
                }
                i++;
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public FarmLot getFarmLot() {
        return farmLot;
    }

    public void setFarmLot(FarmLot farmLot) {
        this.farmLot = farmLot;
    }

    public FarmLotView getFarmLotUI() {
        return farmLotUI;
    }

    public void setFarmLotUI(FarmLotView farmLotUI) {
        this.farmLotUI = farmLotUI;
    }
}

