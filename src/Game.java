import javax.swing.*;
import java.awt.*;

/*********************************************************************************************************
 This is to certify that this project is my own work, based on my personal efforts in studying and applying the concepts
 learned. I have constructed the functions and their respective algorithms and corresponding code by myself. The
 program was run, tested, and debugged by my own efforts. I further certify that I have not copied in part or whole or
 otherwise plagiarized the work of other students and/or persons.

 Jilliane Margaux C. Elloso, DLSU ID# 12194026
 Alfred Eugene T. Victoria DLSU ID# 12111724
 *********************************************************************************************************/

public class Game {

    GameGUI mw = new GameGUI(this);

    public static void main(String[] args) {

        SoundHandler.RunMusic("src/sfx/Music Background.wav",-20,true);

        new TitleScreen();
    }
}