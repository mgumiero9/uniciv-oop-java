package org.example;

import dao.UsersDAO;
import model.Users;
import org.junit.Test;

public class DatabaseConnectionTest {

    @Test
    public void initDatabase() {
        Users users = new Users();
        UsersDAO usersDAO = new UsersDAO();

        users.setId(3L);
        users.setName("Laura");
        users.setEmail("lgumiero@gmail.com");

        usersDAO.save(users);
    }
}
