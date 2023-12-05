package View;

import javax.swing.*;
import java.awt.*;

public class GameTableSplit extends JPanel {
    public GameTableSplit(int size) {
        //The Glasspane
        // Glasspane glassPane = new Glasspane();
        // glassPane.setActive(true);
        //this.setGlassPane(glassPane);
        //glassPane.setVisible(true);


        // Create tables
        GameTable table1 = new GameTable(size);
        GameTable table2 = new GameTable(size);

        // Create a split pane with vertical split
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, table1, table2);

        // Set the initial size of the split pane
        splitPane.setResizeWeight(0.5);
        splitPane.setDividerLocation(0.5); // Adjust as needed

        // Add the split pane to the content pane
        setLayout(new BorderLayout());
        add(splitPane, BorderLayout.CENTER);

        // Set frame properties

        setSize(1400, 1000);
        setVisible(true);
    }
}