package UI;

import javax.swing.*;
import java.awt.*;


public class ProgramWindow extends JFrame {

    public ProgramWindow() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        ProgramPanel programPanel = new ProgramPanel(this);
        add(programPanel);
        setResizable(false);

        setVisible(true);
    }
}
