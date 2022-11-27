/*********************************************************************************************************
 This is to certify that this project is my own work, based on my personal efforts in studying and applying the concepts
 learned. I have constructed the functions and their respective algorithms and corresponding code by myself. The
 program was run, tested, and debugged by my own efforts. I further certify that I have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jilliane Margaux C. Elloso, DLSU ID# 12194026
 Alfred Eugene T. Victoria DLSU ID# 12111724
 *********************************************************************************************************/

import Models.Farmer;
import Models.GameCont;
import Models.Message;
import Models.Tool;
import Views.MainWindow;

import java.util.Scanner;

/** <function description>
 * @param paramName	            <param description>
 */

public class Game {

    public static String getName(String userName){
        /** This is a helper function that contains introductory terminal art and getting userName
         * @param userName	            The player's name (farmerName)
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("\nWhat's your name farmer?");
        userName = sc.next(); // Set farmer name from user input

        return userName;
    }

    public static void printStats(){ //TODO: replace this function with Models.Farmer Statistics chenachena

    }

    public static void doCommand(Farmer farmer, String input){
        /** This function processes user input from menu
         * @param currentTool               acts as user input for prompts
         */

        input = input.toLowerCase(); // convert input to lowercase
        switch(input){
            // Display user actions
            case "1" -> { // Plant
                //seedStore.showSeedList
                //farmer.buySeed
            }
            case "2" -> farmer.showToolList(); // Models.Tool
            case "3" -> { // Harvest
                //farmer.harvest(tile)
            }
            case "4" -> { // Advance Day
                //farmlot.advanceday
            }
            case "5" ->{

                GameCont.setRunning(false);
                //isRunning = (false);// TODO: isRunning change to false (exit main loop to move to game over screen)
                Message.processCommand("quit");
            } // Quit the game
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

        String userInput = "";
        Scanner sc = new Scanner(System.in);
        boolean gameCont = true;
        MainWindow mw = new MainWindow();

        while(gameCont){ // Continue game unless player chooses quit (after game over)
            GameCont.setRunning(true);
            Farmer farmer = new Farmer(""); // Create new farmer (user)
            Message.processCommand("intro"); // Print introductory terminal art (from Models.Message)

            getName(userInput); // Ask for user input farmerName
            userInput = String.valueOf(userInput.charAt(0)).toUpperCase() + userInput.substring(1).toLowerCase();// format farmerName (capitalizes first letter, lowercase the rest)
            farmer.setFarmerName(userInput); // Set farmerName to user input

            Message.processCommand("greeting", farmer.getFarmerName()); // Print greeting Models.Message

            while(GameCont.getIsRunning()){ // Models.Game loop
                // Print player stats (OBJCOIN,
                // DAY, ETC.) -> MP SPECS
                Message.processCommand("menu"); // Print actions available
                userInput = sc.nextLine(); // Ask user for command
                doCommand(farmer, userInput); // Perform command
                checkGame(farmer, GameCont.getIsRunning()); // Check conditions
            }

            do{ // Models.Game over, Continue condition
                Message.processCommand("over"); // game over info + new game or quit
                userInput = sc.nextLine(); // get user input
            }while(!(userInput.equals("1") || userInput.equals("2"))); // user input validation

            if(userInput.equals("2")){
                System.exit(0); // quit program
            }
        }
    }
}