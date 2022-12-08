package Views;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class seedInfoView extends JFrame {
    public JFrame popup;
    JButton closeBtn = new JButton();

    public seedInfoView ()
    {
        popup = new JFrame("Seed Information");
        popup.setSize(new Dimension(800,800));
        popup.setLayout(null);
        popup.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen
        popup.setLayout(new BorderLayout());
        popup.setContentPane(new JLabel(new ImageIcon("src/Views/assets/Seed Info.png"))); // Sets background of window
        popup.setResizable(false);
        popup.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen

        generateButtonImage(closeBtn,"src/Views/assets/Close.png");
        closeBtn.setBounds(370,680,50,50);
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeBtn.addActionListener(popupListener);
        popup.add(closeBtn);
    }

    ActionListener popupListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==closeBtn)
            {
                popup.setVisible(false);
            }
        }
    };

    public void generateButtonImage(JButton btn, String imagePath){
        int PIX_SIZE = 80;

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
}