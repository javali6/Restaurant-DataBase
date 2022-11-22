package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ProgramPanel extends JPanel {

    public static final int ADDING = 1;
    public static final int MODIFY = 2;
    public static final int QUERY = 3;

    JButton button1;
    JButton button2;
    JButton button3;
    JButton backButton = new JButton("Powrót");;

    Connection connection;

    public ProgramPanel(ProgramWindow programWindow, Connection connection) {
        this.connection = connection;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        ActionListener actionListener = new ActionListener(programWindow, this);
        setBackground(Color.GRAY);

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
                ActionListener actionListener = new ActionListener(programWindow, this);
                System.out.println("jaj");
                setBackground(Color.lightGray);
                add(backButton);
                backButton.addActionListener(actionListener);
            }
            case MODIFY -> {
                ActionListener actionListener = new ActionListener(programWindow, this);
                System.out.println("dup");
                setBackground(Color.lightGray);
                add(backButton);
                backButton.addActionListener(actionListener);
            }
            case QUERY -> {
                ActionListener actionListener = new ActionListener(programWindow, this);
                System.out.println("buź");
                setBackground(Color.lightGray);
                add(backButton);
                backButton.addActionListener(actionListener);
            }
        }

    }
    
    private class ActionListener implements java.awt.event.ActionListener {

        ProgramWindow programWindow;
        ProgramPanel programPanel;

        public ActionListener(ProgramWindow programWindow, ProgramPanel programPanel) {
            this.programWindow = programWindow;
            this.programPanel = programPanel;
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
            } else if (e.getSource().equals(backButton)) {
                System.out.println("4");
                programPanel = new ProgramPanel(programWindow, connection);
                programWindow.setContentPane(programPanel);
                programWindow.invalidate();
                programWindow.validate();

            }
        }
    }
    
}
