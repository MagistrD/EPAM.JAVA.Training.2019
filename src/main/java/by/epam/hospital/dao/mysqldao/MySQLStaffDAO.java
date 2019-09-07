package by.epam.hospital.dao.mysqldao;

import by.epam.hospital.conpool.DBConnectionPool;
import by.epam.hospital.dao.AbstractDAO;
import by.epam.hospital.entities.Staff;
import by.epam.hospital.config.ConfigurationManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for Staff entity
 */
public class MySQLStaffDAO implements AbstractDAO<Integer, Staff> {
    private static final DBConnectionPool CONNECTION_POOL = new DBConnectionPool(ConfigurationManager.get("db.url"),
            ConfigurationManager.get("db.login"), ConfigurationManager.get("db.password"), 16);

    /**
     * Select all staff
     *
     * @return List of staff
     * @throws SQLException exception
     */
    public List<Staff> findAll() throws SQLException {
        List<Staff> staffList = new ArrayList<Staff>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.select.all"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String secondName = resultSet.getString(3);
                String surname = resultSet.getString(4);
                int specialization = resultSet.getInt(5);
                staffList.add(new Staff(id, firstName, secondName, surname, specialization));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception in 'Staff select all'" + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return staffList;
    }

    /**
     * find Staff by ID
     *
     * @param id ID
     * @return Staff
     * @throws SQLException exc
     */
    public Staff findObjectById(final Integer id) throws SQLException {
        Staff staff = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("" + id));
            ResultSet resultSet = preparedStatement.executeQuery();
            int staffID = resultSet.getInt(1);
            String firstName = resultSet.getString(2);
            String secondName = resultSet.getString(3);
            String surname = resultSet.getString(4);
            int specialization = resultSet.getInt(5);

            staff = new Staff(staffID, firstName, secondName, surname, specialization);
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return staff;
    }

    /**
     * delete Staff
     *
     * @param id ID
     * @return true if success
     * @throws SQLException exc
     */
    public boolean delete(final Integer id) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.delete.by.id") + id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return b;
    }

    /**
     * delete staff
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean delete(final Staff object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            //------------------------------
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.delete"));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return b;
    }

    /**
     * create Staff
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean create(final Staff object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.insert"));
            preparedStatement.setString(1, object.getFirstName());
            preparedStatement.setString(2, object.getSecondName());
            preparedStatement.setString(3, object.getSurname());
            preparedStatement.setInt(4, object.getStaffType());
            preparedStatement.execute();
            b = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return b;
    }

    /**
     * update Staff
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean update(final Staff object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            int id = object.getStaffID();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.update") + id);
            preparedStatement.setString(1, object.getFirstName());
            preparedStatement.setString(2, object.getSecondName());
            preparedStatement.setString(3, object.getSurname());
            preparedStatement.setInt(4, object.getStaffType());
            preparedStatement.executeUpdate();
            b = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        }
        return b;
    }
}
