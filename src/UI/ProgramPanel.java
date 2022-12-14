package UI;

import engine.MySQLConnector;
import engine.ReportGenerator;
import net.sf.jasperreports.engine.JRException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class ProgramPanel extends JPanel {

    public static final int ADDING = 1;
    public static final int MODIFY = 2;
    public static final int QUERY = 3;
    public static final int ADDITIONAL = 4;

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton backButton = new JButton("Powrót");
    JButton repButton1;
    JButton repButton2;
    JButton repButton3;
    JButton repButton4;

    JTextArea reportTwoText = new JTextArea("wprowadź warunek: (nazwa województwa)");

    MySQLConnector connection;

    String[] listOfTables ={"Lokale", "Magazyn", "Menu",
            "Skladniki", "Pracownicy", "Rachunki", "Sale", "Wyposazenie kuchni",
            "Wyposazenie sali", "Zamowienia", "Zapotrzebowanie"};

    String[] listOfQuery = {"Zapytanie", "Zapytanie2"};

    public ProgramPanel(ProgramWindow programWindow, MySQLConnector connection) {
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

        button4 = new JButton("4 Dodatki");
        button4.setSize(450, 450);
        button4.addActionListener(actionListener);

        add(button1);
        add(button2);
        add(button3);
        add(button4);

    }

    public ProgramPanel(ProgramWindow programWindow, int type) {
        switch (type) {
            case ADDING -> {
                BorderLayout borderLayout = new BorderLayout();
                setLayout(borderLayout);

                ActionListener actionListener = new ActionListener(programWindow, this);
                System.out.println("dodawanie");
                setBackground(Color.lightGray);
                add(backButton, BorderLayout.PAGE_END);
                backButton.addActionListener(actionListener);

               JComboBox<String> comboBox = new JComboBox<>(listOfTables);
               comboBox.setPreferredSize(new Dimension(300, 50));
               add(comboBox, BorderLayout.PAGE_START);

               TextField textField = new TextField("wpisz tekst", 4);
               textField.setPreferredSize(new Dimension(500, 300));
               add(textField, BorderLayout.CENTER);

               JButton confirmButton = new JButton("WPROWADŹ");
               confirmButton.setPreferredSize(new Dimension(100, 50));
               confirmButton.setMargin(new Insets(500, 0, 500, 0));
               add(confirmButton, BorderLayout.LINE_END);


            }
            case MODIFY -> {
                BorderLayout borderLayout = new BorderLayout();
                setLayout(borderLayout);

                ActionListener actionListener = new ActionListener(programWindow, this);
                System.out.println("modyfikacja");
                setBackground(Color.lightGray);
                add(backButton, BorderLayout.PAGE_END);
                backButton.addActionListener(actionListener);

                JComboBox<String> comboBox = new JComboBox<>(listOfTables);
                comboBox.setPreferredSize(new Dimension(300, 50));
                add(comboBox, BorderLayout.PAGE_START);

                TextField textField = new TextField("wpisz tekst", 4);
                textField.setPreferredSize(new Dimension(500, 300));
                add(textField, BorderLayout.CENTER);

                JButton confirmButton = new JButton("WPROWADŹ");
                confirmButton.setPreferredSize(new Dimension(100, 50));
                confirmButton.setMargin(new Insets(500, 0, 500, 0));
                add(confirmButton, BorderLayout.LINE_END);
            }
            case QUERY -> {
                BorderLayout borderLayout = new BorderLayout();
                setLayout(borderLayout);

                ActionListener actionListener = new ActionListener(programWindow, this);
                System.out.println("zapytania");
                setBackground(Color.lightGray);
                add(backButton, BorderLayout.PAGE_END);
                backButton.addActionListener(actionListener);

                JComboBox<String> comboBox = new JComboBox<>(listOfQuery);
                comboBox.setPreferredSize(new Dimension(300, 50));
                add(comboBox, BorderLayout.PAGE_START);

                TextField textField = new TextField("wpisz tekst", 4);
                textField.setPreferredSize(new Dimension(500, 300));
                add(textField, BorderLayout.CENTER);

                JButton confirmButton = new JButton("POKAŻ");
                confirmButton.setPreferredSize(new Dimension(100, 50));
                confirmButton.setMargin(new Insets(500, 0, 500, 0));
                add(confirmButton, BorderLayout.LINE_END);
            }
            case ADDITIONAL -> {
                GridLayout gridLayout = new GridLayout(5, 2, 100, 100);
                setLayout(gridLayout);

                ActionListener actionListener = new ActionListener(programWindow, this);
                setBackground(Color.lightGray);

                //PIERWSZY RAPORT
                JLabel reportOneLabel = new JLabel("LISTA PRACOWNIKA PODZIELONA ZE WZGLEDU NA UMOWE");
                repButton1 = new JButton("Generuj");
                add(reportOneLabel);
                add(repButton1);
                repButton1.addActionListener(actionListener);

                //DRUGI RAPORT
                repButton2 = new JButton("Generuj");
                add(reportTwoText);
                add(repButton2);
                repButton2.addActionListener(actionListener);

                //TRZECI RAPORT
                JLabel reportTwoLabel = new JLabel("LISTA WSZYSTKICH RACHUNKÓW ");
                repButton3 = new JButton("Generuj");
                add(reportTwoLabel);
                add(repButton3);
                repButton3.addActionListener(actionListener);

                //CZWARTY RAPORT
                JLabel reportThreeLabel = new JLabel("CZWARTY Z WYKRESEM RAPORT ");
                repButton4 = new JButton("Generuj");
                add(reportThreeLabel);
                add(repButton4);
                repButton4.addActionListener(actionListener);

                JLabel backLabel = new JLabel("POWRÓT DO MENU GŁOWNEGO ");
                add(backLabel);
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

            } else if (e.getSource().equals(button4)) {
                System.out.println("5");
                ProgramPanel addonsPanel = new ProgramPanel(programWindow, ADDITIONAL);
                programWindow.setContentPane(addonsPanel);
                programWindow.invalidate();
                programWindow.validate();

            } else if (e.getSource().equals(repButton1)) {

                firstReport();

            } else if (e.getSource().equals(repButton2)) {

                secondReport();

            } else if (e.getSource().equals(repButton3)) {

                ReportGenerator reportGenerator;
                try {
                    reportGenerator = new ReportGenerator();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    reportGenerator.generateThirdReport();
                } catch (JRException | SQLException ex) {
                    throw new RuntimeException(ex);
                }

            } else if (e.getSource().equals(repButton4)) {

                ReportGenerator reportGenerator;
                try {
                    reportGenerator = new ReportGenerator();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    reportGenerator.generateFourthReport();
                } catch (JRException | SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }

        private void firstReport() {
            ReportGenerator reportGenerator;
            try {
                reportGenerator = new ReportGenerator();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            try {
                reportGenerator.generateFirstReport();
            } catch (JRException | SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        private void secondReport() {
            ReportGenerator reportGenerator;
            try {
                reportGenerator = new ReportGenerator();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                String condition = reportTwoText.getText();
                System.out.println(condition);
                reportGenerator.generateSecondReport(condition);
            } catch (JRException | SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    
}
