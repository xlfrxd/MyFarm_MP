package Views;

import javax.swing.*;
import java.awt.*;

public class messageView extends JPanel {
    Container container = new Container();
    JTextArea textArea = new JTextArea();
    public messageView() {
        setBackground(Color.cyan);

        container.add(textArea);

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setFont(new Font("Arial", Font.PLAIN,20));
        textArea.setText("TEST");

        this.add(container);
    }
}
