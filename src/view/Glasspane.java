package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Glasspane extends JPanel {  //JPanel das über einer gesamten komponente aktiviert werden kann
        boolean active;
        public Glasspane() {
            setOpaque(false);
            active=false;
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) { // Wenn active==true absorbiert alle clicks bis active==false
                    if (active) {
                        e.consume();
                    }
                }
            });
        }


        @Override
        protected void paintComponent(Graphics g) { //Farbe manager/Repaint Manager
            // Draw a semi-transparent background over the entire glass pane
            g.setColor(new Color(0, 0, 0, 128));
            g.fillRect(0, 0, getWidth(), getHeight());
        }

    public void setActive(boolean active) {
        this.active = active;
        setVisible(active);
        // Ensure that the glass pane receives mouse events when active
        if (active) {
            requestFocusInWindow();
        }
        // Notify the system that the state of the glass pane has changed
        firePropertyChange("active", !active, active);
    }
    }

