import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class TableCellButtonEditor implements TableCellEditor {
    JButton2 button=new JButton2();
    public TableCellButtonEditor(){
       button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               stopCellEditing();
           }
       });
    }
    @Override
    public Component getTableCellEditorComponent(JTable jTable, Object o, boolean b, int i, int i1) {
        JButton modelButton=(JButton)o;
        modelButton.setText("clicked");
        button.setText(modelButton.getText());
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return button.getText();
    }

    @Override
    public boolean isCellEditable(EventObject eventObject) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject eventObject) {
        return true;
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
