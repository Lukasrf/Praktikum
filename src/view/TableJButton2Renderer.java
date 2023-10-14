package view;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableJButton2Renderer extends JButton2 implements TableCellRenderer {
    Dimension x=new Dimension(20,20);
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object o, boolean b, boolean b1, int i, int i1) {
        //this.setBorderPainted(false);
        //this.setContentAreaFilled(false);
        this.setPreferredSize(new Dimension(40,40));
        this.setText(o.toString());
        return this;
    }
}
