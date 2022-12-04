package Views;

import Input.Input;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class MainWindow {
    JFrame mainFrame;

    public MainWindow(Input input){
        this.mainFrame = new JFrame("My Farmer Game");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout());
        this.mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen

        GamePanel gamePanel = new GamePanel();
        this.mainFrame.add(gamePanel);
        //this.mainFrame.addMouseListener(input);
       //this.mainFrame.addMouseMotionListener(input);

        this.mainFrame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(gamePanel.contains(e.getX(),e.getY())){
                    System.out.println("Clicked x:" + e.getX() + "y:" + e.getY());
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });{

        }


        this.mainFrame.pack();

        this.mainFrame.setResizable(false);
        this.mainFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen

    }

    public void setWindowVisible(boolean bool){
        this.mainFrame.setVisible(bool);
    }

    public void initializeGreetingElements(){
        this.mainFrame.add(farmerView.getFarmerNamePromptLbl());
    }


}
