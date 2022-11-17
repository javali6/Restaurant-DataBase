package UI;

import javax.swing.*;
import java.awt.*;


public class ProgramWindow extends JFrame {

    public ProgramWindow() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ProgramPanel programPanel = new ProgramPanel();
    }
}
