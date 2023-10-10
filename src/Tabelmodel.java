import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class Tabelmodel extends AbstractTableModel {
    private String[] letters={"A","B","C","D","E","F","G","H","I","J"};
    private String[] columnNames;
    private JButton2[][] data;
    public Tabelmodel(int size){
       columnNames=new String[size];
       data=new JButton2[size][size];
        for(int i=0;i<size;i++){
            columnNames[i]=letters[i];
            for(int j=0;j<size;j++){
                data[i][j]=new JButton2("UNCLICKED");
            }
        }
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int i, int j) {
        return data[i][j];
    }
    @Override public boolean isCellEditable(int i,int j){
        return true;
    }
}
