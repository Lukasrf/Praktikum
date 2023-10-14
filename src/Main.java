import controler.Controler;
import model.Data;
import view.CustomTableModel;
import view.TableJButton2Editor;
import view.TableJButton2Renderer;
import view.View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        View view=new View(4);
        Data data=new Data(4);
        Controler controler=new Controler(view,data);

        }
    }
