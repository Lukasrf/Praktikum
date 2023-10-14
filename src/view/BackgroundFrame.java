package view;

import controler.Controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BackgroundFrame extends JFrame {
    boolean cancelstatus = false;

    public BackgroundFrame() {
        setTitle("Background Image Frame");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        GridBagConstraints frameConstraints = new GridBagConstraints();
        frameConstraints.fill = GridBagConstraints.BOTH;
        frameConstraints.weightx = 1.0;  // Request any extra horizontal space
        frameConstraints.weighty = 1.0;

        // Create a custom panel with a background image
        JPanel backgroundImagePanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bgImage = new ImageIcon("/Users/sakis/Desktop/javas/Boats/src/view/test.jpg");
                g.drawImage(bgImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.fill = GridBagConstraints.BOTH;
        buttonConstraints.weightx = 0.5;
        buttonConstraints.weighty = 0.5;
        buttonConstraints.insets = new Insets(10, 10, 10, 10);  // Some padding around buttons

        JButton mybutton1 = createButton("clickme1");
        JButton mybutton2 = createButton("clickme2");
        JButton mybutton3 = createButton("clickme3");
        JButton mybutton4 = createButton("clickme4");

        backgroundImagePanel.add(mybutton1, buttonConstraints);
        backgroundImagePanel.add(mybutton2, buttonConstraints);
        backgroundImagePanel.add(mybutton3, buttonConstraints);
        backgroundImagePanel.add(mybutton4, buttonConstraints);

        this.add(backgroundImagePanel, frameConstraints);
        this.setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cancelstatus = true;
                System.out.println(cancelstatus);
            }
        });
        return button;
    }

    public static void main(String[] args) {
        new BackgroundFrame();
    }
}

