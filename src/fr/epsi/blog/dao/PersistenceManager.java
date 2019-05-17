package fr.epsi.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersistenceManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/epsi_blog?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_LOGIN = "root";
    private static final String DB_PWD = "";

    private static Connection connection;

    public PersistenceManager() {}

    public static Connection getConnection() throws SQLException {
        if ( null == connection || connection.isClosed() ) {
            connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PWD );
        }

        return connection;
    }

    public static void closeConnection() throws SQLException {
        if ( null != connection && !connection.isClosed() ) {
            connection.close();
        }
    }
}

