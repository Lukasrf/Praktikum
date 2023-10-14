package view;

import controler.Controler;

import javax.swing.*;
import javax.swing.text.BoxView;
import java.awt.event.*;

public class View extends JComponent{


    public View(int size){

            JFrame frame1=new JFrame("welcome");
            JButton button1=new JButton2("next");
            frame1.add(button1);
            frame1.setVisible(true);
            frame1.pack();
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    CustomTableModel model=new CustomTableModel(4);
                    JTable table=new JTable(model);
                    JScrollPane js=new JScrollPane(table);
                    for(int i=0;i<size;i++){
                        table.getColumnModel().getColumn(i).setCellRenderer(new TableJButton2Renderer());
                        table.getColumnModel().getColumn(i).setCellEditor(new TableJButton2Editor());
                    }
                    frame1.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            System.out.println("wtfffff");
                            Controler.setgamestatus();
                            super.windowClosing(e);
                        }
                    });
                    frame1.getContentPane().removeAll();
                    frame1.add(js);
                    frame1.revalidate();
                    frame1.repaint();
                    frame1.setVisible(true);
                    frame1.pack();
                }
            });
        }
  }

