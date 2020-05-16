package dao;

import jdbc.SingleConnection;
import model.User;
import model.UserTelephone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {

    private Connection connection;

    public UsersDAO() {
        connection = SingleConnection.getConnection();
    }

    public void persist(User user) {
        String sql = "INSERT INTO users (name, email) values (?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.execute();
            connection.commit();
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
    }

    public List<User> getUserList() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users ORDER BY id DESC;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    public User getUser(Integer id) {
        User user = new User();
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public void updateUser(User user) {
        final String sql = "UPDATE users SET name = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setLong(2, user.getId());
            statement.execute();
            connection.commit();
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
    }

    public void deleteUser(Long id) {
        final String sql = "DELETE FROM users WHERE id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.execute();
            connection.commit();
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
    }

    public void persistTelephone(UserTelephone userTelephone) {
        final String sql = "INSERT INTO public.user_telephone(\"number\", type, userid) VALUES (?, ?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userTelephone.getNumber());
            statement.setString(2, userTelephone.getType());
            statement.setLong(3, userTelephone.getUserId());
            statement.execute();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
