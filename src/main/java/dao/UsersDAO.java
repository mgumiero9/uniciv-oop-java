package dao;

import jdbc.SingleConnection;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersDAO {

    private Connection connection;

    public UsersDAO() {
        connection = SingleConnection.getConnection();
    }

    public void save(Users users) {
        String sql = "INSERT INTO users (id, name, email) values (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, users.getId());
            statement.setString(2, users.getName());
            statement.setString(3, users.getEmail());
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
}
