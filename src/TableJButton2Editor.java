import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class TableJButton2Editor implements TableCellEditor {
    JButton2 button2=new JButton2();
    public TableJButton2Editor(){
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                stopCellEditing();
            }
        });
    }
    @Override
    public Component getTableCellEditorComponent(JTable jTable, Object o, boolean b, int i, int i1) {
        JButton2 modelbutton=(JButton2)o;
        modelbutton.setText("clicked");
        return modelbutton;
    }

    @Override
    public Object getCellEditorValue() {
        return button2.getText();
    }

    @Override
    public boolean isCellEditable(EventObject eventObject) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject eventObject) {
        return false;
    }

    @Override
    public boolean stopCellEditing() {
        return true;
    }

    @Override
    public void cancelCellEditing() {

    }

    @Override
    public void addCellEditorListener(CellEditorListener cellEditorListener) {

    }

    @Override
    public void removeCellEditorListener(CellEditorListener cellEditorListener) {

    }
}
