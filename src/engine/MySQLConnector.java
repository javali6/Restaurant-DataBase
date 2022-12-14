package engine;

import java.sql.*;

public class MySQLConnector {

    private Connection connection;

    public MySQLConnector() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Minecraft@1907!!");
    }

    public ResultSet executeQuery(String sql, Object... args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }
        return statement.executeQuery();
    }

    public int executeUpdate(String sql, Object... args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            statement.setObject(i+1, args[i]);
        }
        return statement.executeUpdate();
    }

    public void close() throws SQLException {
        connection.close();
    }

    public Connection getConnection() {
        return connection;
    }
}
