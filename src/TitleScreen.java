import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class TitleScreen extends JFrame{

    public static JFrame titleFrame;
    public JButton playBtn = new JButton("play");
    public JButton quitBtn = new JButton("quit");


    public TitleScreen(){

        titleFrame = new JFrame("Sprout Valley");
        titleFrame.setSize(new Dimension(900,900));
        titleFrame.setLayout(null);
        titleFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen
        titleFrame.setLayout(new BorderLayout());
        titleFrame.setContentPane(new JLabel(new ImageIcon("src/Views/assets/Title Screen.png"))); // Sets background of window
        titleFrame.setResizable(false);
        titleFrame.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen

        generateButtonImage(playBtn,"src/Views/assets/Play Button.png");
        playBtn.setBounds(150,680,300,100);
        playBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playBtn.addActionListener(btnListener);
        titleFrame.add(playBtn);

        generateButtonImage(quitBtn,"src/Views/assets/Quit Button.png");
        quitBtn.setBounds(500,680,300,100);
        quitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        quitBtn.addActionListener(btnListener);
        titleFrame.add(quitBtn);

        titleFrame.setVisible(true);
    }

    ActionListener btnListener = new ActionListener() {

        /**
         * Sets button action when button is clicked
         */

        @Override
        public void actionPerformed(ActionEvent e) {
            SoundHandler.RunMusic("src/sfx/buttonClick_sfx.wav",0);
            if(e.getSource()==playBtn)
            {
                titleFrame.setVisible(false);
                new Game();
            }
            if(e.getSource()==quitBtn)
            {
                titleFrame.setVisible(false);
            }
        }
    };

    public void generateButtonImage(JButton btn, String imagePath){
        int PIX_SIZE = 300;

        try {
            BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
            BufferedImage bufferedImageResult = new BufferedImage(
                    PIX_SIZE,
                    100,
                    bufferedImage.getType()
            );
            Graphics2D g2d = bufferedImageResult.createGraphics();
            g2d.drawImage(
                    bufferedImage,
                    0,
                    0,
                    PIX_SIZE,
                    100,
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


    public static void setVisibleTrue(){
        titleFrame.setVisible(true);
    }
}
