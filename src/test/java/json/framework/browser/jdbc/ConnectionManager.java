package json.framework.browser.jdbc;

import utils.Logger;

import java.sql.*;

public class ConnectionManager {
    private static Connection connection;
    private static  String sqlUrl;
    private static String login;
    private static String password;

    public static Connection getConnection() {
        Connection connection = null;
                try {
                    connection = DriverManager.getConnection(sqlUrl, login, password);
                    if(!connection.isClosed()) {
                    Logger.info("connection has been established");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                return connection;
    }

    public static ResultSet getResultSet(String sql)  {
        Connection connection = getConnection();
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        }catch (SQLException throwables) {
            Logger.error("statement has not been gotten");
        }
        return resultSet;
    }
}
