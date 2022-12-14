package UI;

import engine.MySQLConnector;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;


public class ProgramWindow extends JFrame {

    public ProgramWindow(MySQLConnector connection) throws HeadlessException, SQLException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        ProgramPanel programPanel = new ProgramPanel(this, connection);
        add(programPanel);
        setResizable(false);

        setVisible(true);
    }
}
