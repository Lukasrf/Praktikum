package view;

import javax.swing.*;

public class JButton2 extends JButton {
    public JButton2(){
    }
    public JButton2(String text){
        this.setText(text);
    }
    @Override
    public String toString(){
        return this.getText();
    }
}
