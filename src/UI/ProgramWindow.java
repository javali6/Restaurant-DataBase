package UI;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;


public class ProgramWindow extends JFrame {

    public ProgramWindow(Connection connection) throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        ProgramPanel programPanel = new ProgramPanel(this, connection);
        add(programPanel);
        setResizable(false);

        setVisible(true);
    }
}
