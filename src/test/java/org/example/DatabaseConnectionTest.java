package org.example;

import dao.UsersDAO;
import model.User;
import org.junit.Test;

import java.util.List;

public class DatabaseConnectionTest {

    @Test
    public void initDatabase() {
        User user = new User();
        UsersDAO usersDAO = new UsersDAO();

        user.setId(5L);
        user.setName("Laura");
        user.setEmail("lgumiero@gmail.com");

        usersDAO.persist(user);
    }

    @Test
    public void initGetUserList() {
        UsersDAO usersDAO = new UsersDAO();
        List<User> userList = usersDAO.getUserList();
        userList.forEach(user -> {
            System.out.println(user);
        });

    }
}
