/*********************************************************************************************************
 This is to certify that this project is my own work, based on my personal efforts in studying and applying the concepts
 learned. I have constructed the functions and their respective algorithms and corresponding code by myself. The
 program was run, tested, and debugged by my own efforts. I further certify that I have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jilliane Margaux C. Elloso, DLSU ID# 12194026
 Alfred Eugene T. Victoria DLSU ID# 12111724
 *********************************************************************************************************/

import java.util.Scanner;

/** <function description>
 * @param paramName	            <param description>
 */

public class Main {
    private String userName;
    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static String getName(String userName){
        /** This is a helper function that contains introductory terminal art and getting userName
         * @param userName	            The player's name (farmerName)
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("\nWhat's your name farmer?");
        userName = sc.next(); // Set farmer name from user input

        return userName;
    }

    public static void printIntro(){

    }

    public static void printStats(){ //TODO: replace this function with Farmer Statistics chenachena

    }

    public void execute(Farmer farmer, String input){
        /** This function processes user input from menu
         * @param currentTool               acts as user input for prompts
         */


        input.toLowerCase(); // convert input to lowercase
        switch(input){
            // Display user actions
            case "1" -> { // Plant
                //farmer.showSeedList
            }
            case "2" -> { // Tool
                farmer.showToolList();
            }
            case "3" -> { // Harvest

            }
            case "4" -> { // Advance Day

            }
            case "5" -> { // Quit the game
                Message.processCommand("quit");
                setIsRunning(false);// TODO: isRunning change to false (exit main loop to move to game over screen)
            }
            default -> {
                Message.throwUnknownError(input); // Unknown input
            }
        }
    }

    public static void useTool(Farmer farmer, Tool currentTool){ //TODO: [UML] CHANGED chooseTool -> useTool from UML
        /** This function utilizes a tool chosen by the user onto the tile
         * @param currentTool               acts as user input for prompts
         */
    }

    public static void checkGame(Farmer farmer, boolean myGame) {
        /** This function checks myGame for conditions in continuing game
         * @param myGame	            acts as game's validity to continue
         */
        if(myGame){ // If conditions are met
            //TODO: Change <myGame> into conditions for a game to continue running
            }
        else{ // Conditions not met; stop game
            myGame = false;
            }
        }

    public static void main(String[] args) {
        Message ms = new Message();
        String userInput = "";
        Scanner sc = new Scanner(System.in);
        boolean gameCont = true;
        boolean isRunning = true;

        while(gameCont){ // Continue game unless player chooses quit (after game over)
            Farmer farmer = new Farmer(""); // Create new farmer (user)

            Message.processCommand("intro"); // Print introductory terminal art (from Message)

            userInput = getName(userInput); // Ask for user input farmerName
            userInput = String.valueOf(userInput.charAt(0)).toUpperCase() + userInput.substring(1).toLowerCase();// format farmerName (capitalizes first letter, lowercase the rest)
            farmer.setFarmerName(userInput); // Set farmerName to user input

            Message.processCommand("greeting", farmer.getFarmerName()); // Print greeting Message

            while(isRunning){ // Game loop
                // Print player stats (OBJCOIN, DAY, ETC.) -> MP SPECS
                Message.processCommand("menu"); // Print actions available
                execute(farmer, userInput); // Perform commands
                checkGame(farmer, isRunning); // Check conditions // TODO: IMPLEMENT " Check conditions to continue game and update isRunning if necessary "
            }

            do{ // Game over, Continue condition
                Message.processCommand("over");
                System.out.println(
                        "Game Over!\n" +
                        "[1] New Game    [2] Exit"); // TODO: Utilize Message Class() for stuff like this
                sc.nextLine();
            }while(userInput!="1" || userInput!="2"); // user input validation
        }
    }
}