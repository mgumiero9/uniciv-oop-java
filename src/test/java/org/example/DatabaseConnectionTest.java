package org.example;

import dao.UsersDAO;
import model.BeanUserPhone;
import model.User;
import model.UserTelephone;
import org.junit.Test;

import java.util.List;

public class DatabaseConnectionTest {

    @Test
    public void initDatabase() {
        User user = new User();
        UsersDAO usersDAO = new UsersDAO();

        user.setName("Laura");
        user.setEmail("lgumiero@gmail.com");

        usersDAO.persist(user);
    }

    @Test
    public void initGetUserList() {
        UsersDAO usersDAO = new UsersDAO();
        List<User> userList = usersDAO.getUserList();
        userList.forEach(System.out::println);
    }

    @Test
    public void initGetUser() {
        UsersDAO usersDAO = new UsersDAO();
        User user = usersDAO.getUser(3);
        System.out.println(user);
    }

    @Test
    public void initUpdateUser() {
        UsersDAO usersDAO = new UsersDAO();
        User user = new User();
        user.setId(3L);
        user.setName("Name... Updated...");
        usersDAO.updateUser(user);
        System.out.println("command executed");
    }

    @Test
    public void initDeleteUser() {
        UsersDAO usersDAO = new UsersDAO();
        usersDAO.deleteUser(8L);
        System.out.println("command executed");

    }

    @Test
    public void initPersistTelephone() {
        UserTelephone userTelephone = new UserTelephone();
        userTelephone.setNumber("11987282985");
        userTelephone.setType("cel");
        userTelephone.setUserId(1L);

        UsersDAO usersDAO = new UsersDAO();
        usersDAO.persistTelephone(userTelephone);
        System.out.println("telephone persisted");
    }

    @Test
    public void initGetUserPhones() {
        UsersDAO usersDAO = new UsersDAO();
        List<BeanUserPhone> userPhone = usersDAO.getUserPhone();
        for (BeanUserPhone beanUserPhone: userPhone) {
            System.out.println(beanUserPhone);
        }
    }
}
