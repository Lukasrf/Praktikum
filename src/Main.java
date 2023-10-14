import controler.Controler;
import model.Data;
import view.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        View view=new View(12);
        Data data=new Data(12);
        Controler controler=new Controler(view,data);
        }
    }
