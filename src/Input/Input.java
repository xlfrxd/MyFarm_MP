package Input;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements MouseListener, MouseMotionListener {
   private Point mousePosition;
   private boolean mouseClicked;
   private boolean mousePressed;

   public Input(){
       mousePosition = new Point(0,0);
   }

   public void clearMouseClick(){
       mouseClicked = false;
   }

    public Point getMousePosition() {
        return mousePosition;
    }

    public boolean isMouseClicked() {
        return mouseClicked;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    @Override
    public void mouseClicked(MouseEvent e){

    }

    @Override
    public void mousePressed(MouseEvent e){
       mousePressed = true;

    }

    @Override
    public void mouseReleased(MouseEvent e){
       mouseClicked = true;
       mousePressed = false;

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){

    }

    @Override
    public void mouseDragged(MouseEvent e){
       mousePosition = new Point(e.getPoint().getLocation().x, e.getPoint().getLocation().y);

    }

    @Override
    public void mouseMoved(MouseEvent e){
        mousePosition = new Point(e.getPoint().getLocation().x, e.getPoint().getLocation().y);
    }

}

