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
    public JLabel feedback = new JLabel();
    JLabel background = new JLabel();
    public messageView() {

        this.setLayout(null);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setFont(new Font("Arial", Font.PLAIN,20));
        textArea.setText(getMessageText());

        //container.add(textArea);

        feedback.setForeground(Color.WHITE);
        feedback.setBounds(70,30,800,30);
        feedback.setFont(new Font("Helvetica", Font.BOLD,15));

        background.setIcon(new ImageIcon("src/Views/assets/Message Prompt.png"));
        background.setBounds(0,0, 450, 100);

        //this.add(container);
        this.add(feedback);
        this.add(background);
    }
}
