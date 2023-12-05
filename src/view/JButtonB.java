package View;

import javax.swing.*;
import java.awt.*;


public class JButtonB extends JButton {

    boolean set=false;
    boolean hit=false;
    ImageIcon image=new ImageIcon("src/View/fractal.gif");
    public JButtonB(){
        this.setIcon(image);
    }
    public JButtonB(String text){
        this.setText(text);
    }
    @Override
    public String toString(){
        return this.getText();
    }
}
