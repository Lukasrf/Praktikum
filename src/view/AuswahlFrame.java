package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuswahlFrame extends JFrame {
    JButton b1,b2;
    public AuswahlFrame(){
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
        backgroundPanel.setPreferredSize(new Dimension(300,300));
        this.setMinimumSize(new Dimension(400,400));
        this.setMaximumSize((new Dimension(800,800)));


        GridBagLayout gridBagLayout=new GridBagLayout();
        this.setLayout(gridBagLayout);
        GridBagConstraints gbc=new GridBagConstraints();
        BoxLayout boxLayout=new BoxLayout(backgroundPanel,1);
        backgroundPanel.setLayout(boxLayout);


        this.b1=new JButton("Einzelspieler");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        this.b2=new JButton("MehrSpieler");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });


        backgroundPanel.add(Box.createVerticalGlue());
        backgroundPanel.add(b1);
        backgroundPanel.add(b2);
        backgroundPanel.add(Box.createVerticalGlue());

        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setContentPane(backgroundPanel);
        this.setVisible(true);
        this.pack();
    }
}

