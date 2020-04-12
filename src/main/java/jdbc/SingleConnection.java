package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

    private static final String url = "jdbc:postgresql://localhost:5432/posjava";
    private static final String user = "postgres";
    private static final String password = "admin";
    private static Connection connection = null;

    static {
        connect();
    }

    public SingleConnection() {
        connect();
    }

    private static void connect() {
        try {
            if (connection == null) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
                System.out.println("Successfully Connected to DB");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        return connection;
    }
}
