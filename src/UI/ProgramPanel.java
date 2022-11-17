package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramPanel extends JPanel {

    public static final int ADDING = 1;
    public static final int MODIFY = 2;
    public static final int QUERY = 3;

    JButton button1;
    JButton button2;
    JButton button3;

    public ProgramPanel(ProgramWindow programWindow) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        ActionListener actionListener = new ActionListener(programWindow);

        button1 = new JButton("1 Dodawanie");
        button1.setSize(450, 450);
        button1.addActionListener(actionListener);

        button2 = new JButton("2 Modyfikacja");
        button2.setSize(450, 450);
        button2.addActionListener(actionListener);

        button3 = new JButton("3 Zapytania");
        button3.setSize(450, 450);
        button3.addActionListener(actionListener);

        add(button1);
        add(button2);
        add(button3);

    }

    public ProgramPanel(ProgramWindow programWindow, int type) {
        switch (type) {
            case ADDING -> {
                System.out.println("jaj");
            }
            case MODIFY -> {
                System.out.println("dup");
            }
            case QUERY -> {
                System.out.println("buź");
            }
        }

    }
    
    private class ActionListener implements java.awt.event.ActionListener {

        ProgramWindow programWindow;

        public ActionListener(ProgramWindow programWindow) {
            this.programWindow = programWindow;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(button1)) {
                System.out.println("1");
                ProgramPanel addPanel = new ProgramPanel(programWindow ,ADDING);
                programWindow.setContentPane(addPanel);
                programWindow.invalidate();
                programWindow.validate();

            } else if (e.getSource().equals(button2)) {
                System.out.println("2");
                ProgramPanel modifyPanel = new ProgramPanel(programWindow, MODIFY);
                programWindow.setContentPane(modifyPanel);
                programWindow.invalidate();
                programWindow.validate();
            } else if (e.getSource().equals(button3)) {
                System.out.println("3");
                ProgramPanel queryPanel = new ProgramPanel(programWindow, QUERY);
                programWindow.setContentPane(queryPanel);
                programWindow.invalidate();
                programWindow.validate();
            }
        }
    }
    
}
