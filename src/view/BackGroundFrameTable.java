package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class BackGroundFrameTable extends JFrame {

    public BackGroundFrameTable(int size){
        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();
        frameConstraints.fill = GridBagConstraints.BOTH;
        frameConstraints.weightx = 1.0;  // Give component the entire horizontal space
        frameConstraints.weighty = 1.0;
        JPanel backgroundImagePanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bgImage = new ImageIcon("/Users/sakis/Desktop/javas/Boats/src/view/test.jpg");
                g.drawImage(bgImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        CustomTableModel model=new CustomTableModel(size);
        JTable table=new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setOpaque(false);
        table.setShowGrid(false);
        //JScrollPane js=new JScrollPane(table);
        for(int i=0;i<size;i++){
            table.getColumnModel().getColumn(i).setCellEditor(new TableJButton2Editor());
            table.getColumnModel().getColumn(i).setCellRenderer(new TableJButton2Renderer());
        }
        GridBagConstraints tableConstraints=new GridBagConstraints();
        tableConstraints.fill = GridBagConstraints.BOTH;
        tableConstraints.weightx = 1.0;
        tableConstraints.weighty = 1.0;
        backgroundImagePanel.add(table,tableConstraints);
        this.add(backgroundImagePanel,frameConstraints);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int height = table.getHeight();
                int newRowHeight = height / table.getRowCount();  // divide the total height by the number of rows
                if (newRowHeight > 0) {  // Ensure newRowHeight is greater than 0
                    table.setRowHeight(newRowHeight);
            }
        }});
        this.setVisible(true);
        this.pack();
    }
}
