package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class seedInfoView extends JFrame {
    public JFrame popup;
    JButton closeBtn = new JButton();

    public seedInfoView ()
    {
        popup = new JFrame("Seed Information");
        popup.setSize(new Dimension(500,500));
        popup.setLayout(null);
        popup.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen
        popup.setLayout(new BorderLayout());
        popup.setContentPane(new JLabel(new ImageIcon("src/Views/tiles/Background.png"))); // Sets background of window
        popup.setResizable(false);
        popup.setLocationRelativeTo(null); // Allows window to display relative to the center of the screen

        closeBtn.setText("Close");
        closeBtn.setBounds(50,80,200,75);
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
}