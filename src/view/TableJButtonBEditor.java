package View;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class TableJButtonBEditor implements TableCellEditor {
    JButtonB modelbutton;
    ActionListener e1=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            modelbutton.setText(modelbutton.getText()+"1");
        }
    };

    public TableJButtonBEditor(){
    }
    @Override
    public Component getTableCellEditorComponent(JTable jTable, Object o, boolean b, int i, int i1) {
        this.modelbutton = (JButtonB) o;
        modelbutton.hit = true;
        modelbutton.addActionListener(e1);
        return modelbutton;
    }

    @Override
    public Object getCellEditorValue() {
        return modelbutton.getText();
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
