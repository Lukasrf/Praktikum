package controler;


import model.Data;
import view.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controler {
    static View v;
    static Data d;
    public Controler(View v,Data d){
        this.v=v;
        this.d=d;
    }
    public static void set(int i,int i1){
      d.set(i,i1);
    }
    public static boolean get(int i,int i1){
      return d.get(i,i1);
    }
    public static void setgamestatus(){
        d.setGameplay();
    }

}
