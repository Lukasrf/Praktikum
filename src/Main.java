import javax.swing.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test Table Made of Buttons");
        JFrame frame= new JFrame("welcome");
        int size=Integer.parseInt(JOptionPane.showInputDialog(frame,"Choose your grid size"));
        Tabelmodel model=new Tabelmodel(size);
        JTable table= new JTable(model);
        JScrollPane js=new JScrollPane(table);
        for(int i=0;i<size;i++){
                table.getColumnModel().getColumn(i).setCellEditor(new TableCellButtonEditor());
                table.getColumnModel().getColumn(i).setCellRenderer(new TableCellButtonRenderer());
            }
        frame.add(js);
        frame.setVisible(true);
        frame.pack();
    }
}