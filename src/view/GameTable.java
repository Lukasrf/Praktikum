package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GameTable extends JPanel {

    public GameTable(int size) {
        setLayout(new GridBagLayout());
        GridBagConstraints panelConstraints = new GridBagConstraints();
        panelConstraints.fill = GridBagConstraints.BOTH;  //Table/Panel adaptor
        panelConstraints.weightx = 0.5;
        panelConstraints.weighty = 0.5;

        JPanel backgroundImagePanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) { // background image repainter
                super.paintComponent(g);
                ImageIcon bgImage = new ImageIcon("src/View/test.jpg");
                g.drawImage(bgImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };

        CustomTableModel model = new CustomTableModel(size);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setOpaque(false);
        table.setShowGrid(false);
        table.setTableHeader(null);

        for (int i = 0; i < size; i++) {                                // Table cell editor/renderer setzten
            table.getColumnModel().getColumn(i).setCellEditor(new TableJButtonBEditor());
            table.getColumnModel().getColumn(i).setPreferredWidth(table.getRowHeight());
            table.getColumnModel().getColumn(i).setCellRenderer(new TableJButtonBRenderer());
        }

        GridBagConstraints tableConstraints = new GridBagConstraints();
        tableConstraints.fill = GridBagConstraints.BOTH;
        tableConstraints.weightx = 0.5;
        tableConstraints.weighty = 0.5;
        backgroundImagePanel.add(table, tableConstraints);
        this.add(backgroundImagePanel, panelConstraints);

        table.addComponentListener(new ComponentAdapter() { //Table cell resizer auf quadrat
            @Override
            public void componentResized(ComponentEvent e) {
                int height = table.getHeight();
                int newRowHeight = height / table.getRowCount();
                if (newRowHeight > 0) {
                    table.setRowHeight(newRowHeight);
                }
            }
        });


        this.setVisible(true);
    }}


