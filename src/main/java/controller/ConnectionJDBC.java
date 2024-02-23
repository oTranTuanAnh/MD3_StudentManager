package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static final String URL = "jdbc:mysql://localhost:3306/studentmanager";
    public static final String USER = "root";
    public static final String PASSWORD = "Tuananh@1993";
    private static Connection connection;

    private ConnectionJDBC(Connection connection) {
        this.connection = connection;
    }
    public static Connection getConnection(){
        if (connection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;

    }
}
