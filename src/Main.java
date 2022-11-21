/*********************************************************************************************************
 This is to certify that this project is my own work, based on my personal efforts in studying and applying the concepts
 learned. I have constructed the functions and their respective algorithms and corresponding code by myself. The
 program was run, tested, and debugged by my own efforts. I further certify that I have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jilliane Margaux C. Elloso, DLSU ID# 12194026
 Alfred Eugene T. Victoria DLSU ID# 12111724
 *********************************************************************************************************/

/** <function description>
 * @param <paramName>	            <param description>
 */

public class   Main {
    public static boolean isRunning = true;

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



        while(isRunning){ // Game loop

            checkGame(isRunning); // Check conditions to continue game
        }
    }
}