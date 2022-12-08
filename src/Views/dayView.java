package Views;

import javax.swing.*;

public class dayView extends JLabel {

    public dayView(){
        setText(String.valueOf(getDay()));
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int day;
}
