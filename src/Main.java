import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        JFrame frame=new JFrame("welcome");
        int size =Integer.parseInt(JOptionPane.showInputDialog(frame,"Enter Game size"));
        CustomTableModel model=new CustomTableModel(size);
        JTable table=new JTable(model);
        JScrollPane js=new JScrollPane(table);
        for(int i=0;i<size;i++){
            table.getColumnModel().getColumn(i).setCellRenderer(new TableJButton2Renderer());
            table.getColumnModel().getColumn(i).setCellEditor(new TableJButton2Editor());
        }
        frame.add(js);
        frame.setVisible(true);
        frame.pack();
    }
}