import UI.ProgramWindow;
import net.sf.jasperreports.engine.JasperCompileManager;

import javax.sound.midi.Sequence;
import java.sql.*;


public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Minecraft@1907!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "select idPracownika, nazwisko, imię, stanowisko " +
                "from pracownicy " +
                "where `status studenta` = 'tak'");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) +
                   " " + resultSet.getString(3));

        }

        new ProgramWindow(connection);

    }
}