package View;

import javax.swing.table.AbstractTableModel;

/**
 * Class used as the table model for the grid<br>
 *
 */
public class CustomTableModel extends AbstractTableModel {

    String[] letters={"A","B","C","D","E","F","G","H","J"};
    String[] columnName;
    JButtonB[][] data;
    /**
     * The constructor of the Table Model <br>
     *
     *@param size the integer that sets the size of the grid <br>
     */
    public CustomTableModel(int size){
        columnName=new String[size];
        data=new JButtonB[size][size];
        for(int i=0;i<size;i++){
            columnName[i]=letters[i];
            for(int j=0;j<size;j++){
                data[i][j]= new JButtonB();

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
