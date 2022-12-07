package Views;

import javax.swing.*;
import java.awt.*;

public class messageView extends JPanel {
    Container container = new Container();
    JTextArea textArea = new JTextArea();

    JLabel background = new JLabel();
    public messageView() {
        setBackground(Color.cyan);

        container.add(textArea);

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setFont(new Font("Arial", Font.PLAIN,20));
        textArea.setText("TEST");

        background.setIcon(new ImageIcon("src/Views/assets/Message Prompt.png"));
        background.setBounds(0,0, 450, 100);

        this.add(container);
        this.add(background);
    }
}
