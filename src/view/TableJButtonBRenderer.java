package View;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableJButtonBRenderer extends JButtonB implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object o, boolean b, boolean b1, int i, int i1) {
        //this.setBorderPainted(false);
        //this.setContentAreaFilled(false);
        JButtonB modelbutton=(JButtonB)o;
        //modelbutton.setText(toString());
        return modelbutton;
    }
}
