import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableJButton2Renderer extends JButton2 implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object o, boolean b, boolean b1, int i, int i1) {
        this.setText(o.toString());
        return this;
    }
}
