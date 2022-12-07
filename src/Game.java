/*********************************************************************************************************
 This is to certify that this project is my own work, based on my personal efforts in studying and applying the concepts
 learned. I have constructed the functions and their respective algorithms and corresponding code by myself. The
 program was run, tested, and debugged by my own efforts. I further certify that I have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jilliane Margaux C. Elloso, DLSU ID# 12194026
 Alfred Eugene T. Victoria DLSU ID# 12111724
 *********************************************************************************************************/

import Models.*;

/** <function description>
 * @param paramName	            <param description>
 */

public class Game {


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

    GameGUI mw = new GameGUI(this);


    public Game(){

    }

    public static void main(String[] args) {
        new Game(); // Create mainWindow

    }
}