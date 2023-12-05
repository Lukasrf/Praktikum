package View;

import javax.swing.*;
import java.awt.*;

public class GameTableSplitContainer extends JFrame {
    public GameTableSplitContainer() {
        this.setMinimumSize(new Dimension(400,400));
        this.setMaximumSize(new Dimension(1000,1000));
        ImageIcon backgroundImage=new ImageIcon("src/View/fractal.gif");
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                double scaleX = (double) getWidth() / backgroundImage.getIconWidth();
                double scaleY = (double) getHeight() / backgroundImage.getIconHeight();
                // Scale and draw the image to fill the panel
                g.drawImage(backgroundImage.getImage(), 0, 0, (int) (backgroundImage.getIconWidth() * scaleX), (int) (backgroundImage.getIconHeight() * scaleY), this);
            }
        };
        GameTableSplit twoTablesFrame = new GameTableSplit(6);
        // Set up padding
        int padding = 40;
        Insets paddingInsets = new Insets(padding, padding, padding, padding);

        // Create a panel to act as the content pane
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));

        // Add the TwoTablesFrame to the center of the content pane with padding
        contentPane.add(twoTablesFrame, BorderLayout.CENTER);


        // Set the content pane

        setContentPane(contentPane);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);  // Center on screen
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameTableSplitContainer());
    }
}
