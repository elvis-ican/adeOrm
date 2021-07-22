package dev.ade.project.util;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The ConnectionUtil class provides a static getConnection method
 * to connect to the postrgresql database.
 */
public class ConnectionUtil {
    private static Connection connection;
    private static final boolean IS_TEST = Boolean.parseBoolean(System.getenv("TEST"));
    private static String url;
    private static final String USERNAME = System.getenv("USERNAME");
    private static final String PASSWORD = System.getenv("PASSWORD");

    /**
     * The getConnection method returns a singleton Connection object.
     * A local database mirrors the actual deployed web database is used for testing.
     */
    public static Connection getConnection() {
        try {
            if (IS_TEST) {
                connection = DriverManager.getConnection("jdbc:h2:~/test");
            } else if (connection == null || connection.isClosed()) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    /**
     * The getConnection method returns a singleton Connection object.
     * A local database mirrors the actual deployed web database is used for testing.
     *
     * @param url the endpoint with port and db schema
     * @return 0 for fail, 1 for success
     */
    public static int setConnection(String url) {
        if (url == null) {
            return 0;
        }
        ConnectionUtil.url = url;
        return 1;
    }

    /**
     * getConnectionFromPool will return a connection from a pool of connections.
     * Contains: Initial and Min / Max pool size. Pool resize Quantity. Idle Timeout. Max Wait time.
     *
     * Optionally: Connection validation.
     */
}

