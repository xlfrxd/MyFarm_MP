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
    private static boolean isRunning = true;

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
        System.out.println("  _____                    _               ____  _                 _       _             \r\n"
                + " |  ___|_ _ _ __ _ __ ___ (_)_ __   __ _  / ___|(_)_ __ ___  _   _| | __ _| |_ ___  _ __ \r\n"
                + " | |_ / _` | '__| '_ ` _ \\| | '_ \\ / _` | \\___ \\| | '_ ` _ \\| | | | |/ _` | __/ _ \\| '__|\r\n"
                + " |  _| (_| | |  | | | | | | | | | | (_| |  ___) | | | | | | | |_| | | (_| | || (_) | |   \r\n"
                + " |_|  \\__,_|_|  |_| |_| |_|_|_| |_|\\__, | |____/|_|_| |_| |_|\\__,_|_|\\__,_|\\__\\___/|_|   \r\n"
                + "                                   |___/                                                 ");
    }

    public static void printMenu(String input){
        /** This function checks myGame for conditions in continuing game
         * @param input	            acts as user input for prompts
         */
        input.toLowerCase(); // convert input to lowercase

        switch(input){

            default -> Message.throwUnknownError(input);
        }
    }

    public static void checkGame(boolean myGame) {
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

        while(gameCont){ // Continue game unless player chooses quit (after game over)
            Farmer farmer = new Farmer(); // Create new farmer (user)
            printIntro(); // Print introductory terminal art

            farmer.setFarmerName(getName(userInput)); // Get farmerName and set farmerName


            while(isRunning){ // Game loop
                System.out.println("Howdy, " + farmer.getFarmerName()); // test
                checkGame(isRunning); // Check conditions to continue game
            }

            do{
                System.out.println("Game Over!\n" +
                        "[1] New Game    [2] Exit");
                sc.nextLine();
            }while(userInput!="1" || userInput!="2");

        }
    }
}