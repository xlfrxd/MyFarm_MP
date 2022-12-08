package Views;

import javax.swing.*;
import java.awt.*;

public class messageView extends JPanel {
    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    String messageText ="hellow";
    Container container = new Container();
    JTextArea textArea = new JTextArea();

    JLabel background = new JLabel();
    public messageView() {


        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setFont(new Font("Arial", Font.PLAIN,20));
        textArea.setText(getMessageText());

        container.add(textArea);

        background.setIcon(new ImageIcon("src/Views/assets/Message Prompt.png"));
        background.setBounds(0,0, 450, 100);

        this.add(container);
        this.add(background);
    }
}
