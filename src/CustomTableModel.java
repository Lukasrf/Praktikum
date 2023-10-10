import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {
    String[] letters={"A","B","C","D","E","F","G","H","J"};
    String[] columnName;
    JButton2[][] data;
    public CustomTableModel(int size){
        columnName=new String[size];
        data=new JButton2[size][size];
        for(int i=0;i<size;i++){
            columnName[i]=letters[i];
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
        return columnName.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return data[i][i1];
    }
    @Override
    public boolean isCellEditable(int i,int i1){
        return true;
    }
}
