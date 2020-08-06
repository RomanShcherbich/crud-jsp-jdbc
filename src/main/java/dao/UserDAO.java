package dao;

import lombok.extern.log4j.Log4j2;
import model.User;

import java.sql.*;
import java.util.*;

@Log4j2
public class UserDAO extends JdbcDAO<User> implements GenericDAO<User> {

    protected static final String USER_TABLE = "`crud_jsp_jdbc_demo`.`users`";

    protected static final String INSERT_STATEMENT = "INSERT INTO `crud_jsp_jdbc_demo`.`users`\n" +
                                                     "(`name`,\n" +
                                                     "`email`,\n" +
                                                     "`country`)\n" +
                                                     "VALUES\n" +
                                                     "(?,\n" +
                                                     "?,\n" +
                                                     "?);\n";
    protected static final String UPDATE_STATEMENT = "UPDATE `crud_jsp_jdbc_demo`.`users`\n" +
                                                     "SET\n" +
                                                     "`name` = ?,\n" +
                                                     "`email` = ?,\n" +
                                                     "`country` = ?\n" +
                                                     "WHERE `id` = ?;\n";
    protected static final String DELETE_STATEMENT = "DELETE FROM `crud_jsp_jdbc_demo`.`users`\n" +
                                                     "WHERE `id` = ?;\n";

    public UserDAO() {
        super(USER_TABLE);
    }

    @Override
    public User create(User user) {
        User createdUser = null;
        try (
                Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(INSERT_STATEMENT);
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            log.info(ps);
            if(ps.executeUpdate() > 0) {
                createdUser = get(connection, getMaxId(connection));
            }
        } catch (SQLException e) {
            log.error(String.format("Can't create user [%s]", user));
            printSQLException(e);
        }
        return createdUser;
    }

    @Override
    public User update(User user) {
        User updatedUser = null;
        try (
                Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(UPDATE_STATEMENT);
                ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setInt(4, user.getId());
            log.error(String.format("[%s] users were update ", ps.executeUpdate()));
            updatedUser = get(connection, user.getId());
        } catch (SQLException e) {
            log.error(String.format("Can't get user [%s]", user));
            printSQLException(e);
        }
        return updatedUser;
    }

    @Override
    public User get(Object id) {
        User user = null;
        int userId = toInt(id);
        try (
                Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_STATEMENT);
        ) {
            user = getUser(userId, ps);
        } catch (SQLException e) {
            log.error(String.format("Can't get user by id [%s]", userId));
            printSQLException(e);
        }
        return user;
    }

    private User get(Connection connection, int id) {
        User user = null;
        try (PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID_STATEMENT)) {
            user = getUser(id, ps);
        } catch (SQLException e) {
            log.error(String.format("Can't get user by id [%s]", id));
            printSQLException(e);
        }
        return user;
    }

    private User getUser(int id, PreparedStatement ps) throws SQLException {
        ps.setInt(1, id);
        log.info(ps);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String name = rs.getString("name");
        String email = rs.getString("email");
        String country = rs.getString("country");
        return new User(id, name, email, country);
    }

    @Override
    public boolean delete(Object id) {
        boolean rowDeleted = false;
        int userId = toInt(id);
        try (
                Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(DELETE_STATEMENT);
        ) {
            log.info(ps);
            ps.setInt(1, userId);
            rowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            log.error(String.format("Can't delete user by id [%s]", userId));
            printSQLException(e);
        }
        return rowDeleted;
    }

    @Override
    public List<User> listAll() {
        List<User> userList = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(SELECT_ALL_STATEMENT);
        ) {
            log.info(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            log.error("Can't select users from database");
            printSQLException(e);
        }
        return userList;
    }

}
