import UI.ProgramWindow;
import engine.MySQLConnector;
import engine.Queries;
import net.sf.jasperreports.engine.*;

import javax.sound.midi.Sequence;
import java.sql.*;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) throws SQLException, JRException {

        MySQLConnector connection = new MySQLConnector();
        new ProgramWindow(connection);

    }
}