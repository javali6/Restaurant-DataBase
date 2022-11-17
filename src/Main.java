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

        ResultSet resultSet = statement.executeQuery("select * from lokale");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("ulica"));
        }
    }
}