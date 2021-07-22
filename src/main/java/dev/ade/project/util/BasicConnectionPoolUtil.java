package dev.ade.project.util;

import dev.ade.project.exception.ArgumentFormatException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicConnectionPoolUtil {

    private static String url;
    private static final String password = System.getenv("PASSWORD");
    private static final String username = System.getenv("USERNAME");
    private static List<Connection> connectionPool;
    private static final List<Connection> usedConnections = new ArrayList<>();

    private static final boolean IS_TEST = Boolean.parseBoolean(System.getenv("TEST"));


    public BasicConnectionPoolUtil(String url, List<Connection> pool) {
        BasicConnectionPoolUtil.url = url;
        BasicConnectionPoolUtil.connectionPool = pool;
    }

    public static int initialize(String url, int poolSize) throws SQLException, ArgumentFormatException {
        if (url == null || poolSize < 1) {
            throw new ArgumentFormatException();
        }
        BasicConnectionPoolUtil.url = url;
        connectionPool = new ArrayList<>(poolSize);

        for(int i = 0; i < poolSize; i++){
            connectionPool.add(createConnection());
        }
        return 1;
    }

    public static Connection getConnection() {
        Connection connection = null;
        if (IS_TEST) {
            try {
                connection = DriverManager.getConnection("jdbc:h2:~/test");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            connection = connectionPool.remove(connectionPool.size() - 1);
            usedConnections.add(connection);
        }
        return connection;
    }

    public static boolean releaseConnection(Connection connection) {
        if (connection != null) {
            connectionPool.add(connection);
        }
        return usedConnections.remove(connection);
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void shutdown() throws SQLException {
        usedConnections.forEach(BasicConnectionPoolUtil::releaseConnection);
        for (Connection c : connectionPool){
            c.close();
        }
    }

    public static int getSize(){
        return connectionPool.size() + usedConnections.size();
    }

}
