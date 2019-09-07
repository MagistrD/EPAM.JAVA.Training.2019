package by.epam.hospital.dao.mysqldao;

import by.epam.hospital.config.ConfigurationManager;
import by.epam.hospital.conpool.DBConnectionPool;
import by.epam.hospital.dao.AbstractDAO;
import by.epam.hospital.entities.StaffSpecialization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for staff specialization
 */
public class MySQLSpecializationDAO implements AbstractDAO<Integer, StaffSpecialization> {

    private static final DBConnectionPool CONNECTION_POOL = new DBConnectionPool(ConfigurationManager.get("db.url"),
            ConfigurationManager.get("db.login"), ConfigurationManager.get("db.password"), 16);

    @Override
    public List findAll() throws SQLException {
        List<StaffSpecialization> staffSpecializationList = new ArrayList<StaffSpecialization>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("specializations.select.all"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String specializationName = resultSet.getString(2);
                String specializationType = resultSet.getString(3);
                staffSpecializationList.add(new StaffSpecialization(id, specializationName, specializationType));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception in 'Specialization select all'" + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return staffSpecializationList;
    }

    @Override
    public StaffSpecialization findObjectById(final Integer id) throws SQLException {
        StaffSpecialization specialization = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(
                    ConfigurationManager.get("specializations.select.by.id" + id));
            ResultSet resultSet = preparedStatement.executeQuery();
            String specName = resultSet.getString(2);
            String specType = resultSet.getString(3);
            specialization = new StaffSpecialization(id, specName, specType);
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return specialization;
    }

    @Override
    public boolean delete(final Integer id) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(
                    ConfigurationManager.get("specializations.delete.by.id") + id);
            preparedStatement.executeUpdate();
            b = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return b;
    }

    @Override
    public boolean delete(final StaffSpecialization specialization) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("specializations.delete")
                    + specialization.getStaffSpecializationID());
            preparedStatement.executeUpdate();
            b = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return b;
    }

    @Override
    public boolean create(final StaffSpecialization specialization) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("specializations.insert"));
            preparedStatement.setString(1, specialization.getSpecializationName());
            preparedStatement.setString(2, specialization.getSpecializationType());
            preparedStatement.execute();
            b = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return b;
    }

    @Override
    public boolean update(final StaffSpecialization specialization) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = CONNECTION_POOL.getConnection();
            int id = specialization.getStaffSpecializationID();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("specializations.update") + id);
            preparedStatement.setString(1, specialization.getSpecializationName());
            preparedStatement.setString(2, specialization.getSpecializationType());
            preparedStatement.executeUpdate();
            b = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return b;
    }
}
