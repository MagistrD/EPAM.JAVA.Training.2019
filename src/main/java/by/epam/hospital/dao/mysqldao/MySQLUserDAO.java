package by.epam.hospital.dao.mysqldao;

import by.epam.hospital.config.ConfigurationManager;
import by.epam.hospital.conpool.DBConnectionPool;
import by.epam.hospital.dao.AbstractDAO;
import by.epam.hospital.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO for Users
 */
public class MySQLUserDAO implements AbstractDAO<Integer, User> {
    private static final DBConnectionPool CONNECTION_POOL = new DBConnectionPool(ConfigurationManager.get("db.url"),
            ConfigurationManager.get("db.login"), ConfigurationManager.get("db.password"), 16);

    @Override
    public List<User> findAll() throws SQLException {
        return null;
    }

    @Override
    public User findObjectById(final Integer id) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(final Integer id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(final User object) throws SQLException {
        return false;
    }

    @Override
    public boolean create(final User object) throws SQLException {
        return false;
    }

    @Override
    public boolean update(final User object) throws SQLException {
        return false;
    }

    /**
     * find user from DB by parameters
     *
     * @param username username
     * @param password password
     * @param type     user type
     * @return user
     * @throws SQLException sql exception
     */
    public User findUser(final String username, final String password, final String type) throws SQLException {
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            if (type.equals("staff")) {
                preparedStatement = connection.prepareStatement(String.format(ConfigurationManager.
                        get("authentication.select.staff.user"), username, password));
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                int staffUserID = resultSet.getInt(1);
                String staffUsername = resultSet.getString(2);
                String staffPassword = resultSet.getString(3);
                int peopleID = resultSet.getInt(4);
                String userType = "staff";
                String userSubType = resultSet.getString(5);
                user = new User(staffUserID, staffUsername, staffPassword, peopleID, userType, userSubType);
            } else {
                preparedStatement = connection.prepareStatement(String.format(ConfigurationManager.
                        get("authentication.select.patient.user"), username, password));
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                int patientUserID = resultSet.getInt(1);
                String patientUsername = resultSet.getString(2);
                String patientPassword = resultSet.getString(3);
                int peopleID = resultSet.getInt(4);
                String userType = "patient";
                user = new User(patientUserID, patientUsername, patientPassword, peopleID, userType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return user;
    }

    /**
     * create user with patient or staff id
     *
     * @param username username
     * @param password password
     * @param id       id
     * @return is create
     * @throws SQLException sql exception
     */
    public boolean createUserWithID(final String username, final String password, final int id) throws SQLException {
        boolean flag = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.
                    get("registration.create.patient.user"));
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }

        return flag;
    }
}
