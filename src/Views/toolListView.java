package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class toolListView extends JPanel {

    JButton plowBtn = new JButton("Plow");
    JButton waterBtn = new JButton("Watering Can");
    JButton fertBtn = new JButton("Fertilizer");
    JButton pickBtn = new JButton("Pickaxe");
    JButton shovBtn = new JButton("Shovel");
    JButton scythBtn = new JButton("Scythe");

    public JButton[] getToolList() {
        return toolList;
    }

    JButton[] toolList = new JButton[6];

    public toolListView(){

        setLayout(new FlowLayout());

        ButtonGroup btnGroup = new ButtonGroup();

        toolList[0] = plowBtn;
        toolList[1] = waterBtn;
        toolList[2] = fertBtn;
        toolList[3] = pickBtn;
        toolList[4] = shovBtn;
        toolList[5] = scythBtn;

        for (JButton btn :
                toolList) {
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setPreferredSize(new Dimension(150,50));
            btnGroup.add(btn);
            this.add(btn);
        }
    }

    public void setActionListener(ActionListener listener){
        plowBtn.addActionListener(listener);
        waterBtn.addActionListener(listener);
        fertBtn.addActionListener(listener);
        pickBtn.addActionListener(listener);
        shovBtn.addActionListener(listener);
        scythBtn.addActionListener(listener);
    }
}
