package org.example;

import jdbc.SingleConnection;
import org.junit.Test;

public class DatabaseConnectionTest {

    @Test
    public void initDatabase() {
        SingleConnection.getConnection();
    }
}
