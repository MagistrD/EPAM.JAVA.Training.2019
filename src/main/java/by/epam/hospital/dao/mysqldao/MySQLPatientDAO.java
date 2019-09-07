package by.epam.hospital.dao.mysqldao;

import by.epam.hospital.conpool.DBConnectionPool;
import by.epam.hospital.dao.AbstractDAO;
import by.epam.hospital.entities.Patient;
import by.epam.hospital.config.ConfigurationManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MySQL for Patient DAO
 */
public class MySQLPatientDAO implements AbstractDAO<Integer, Patient> {
    private static final DBConnectionPool CONNECTION_POOL = new DBConnectionPool(ConfigurationManager.get("db.url"),
            ConfigurationManager.get("db.login"), ConfigurationManager.get("db.password"), 16);

    /**
     * find all patients
     *
     * @return List of patients
     * @throws SQLException exc
     */
    public List<Patient> findAll() throws SQLException {
        List<Patient> patientList = new ArrayList<Patient>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("patient.select.all"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String secondName = resultSet.getString(3);
                String surname = resultSet.getString(4);
                patientList.add(new Patient(id, firstName, secondName, surname));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception in 'Patient - select all'" + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return patientList;
    }

    /**
     * find patient by ID
     *
     * @param id ID
     * @return Patient
     * @throws SQLException exc
     */
    public Patient findObjectById(final Integer id) throws SQLException {
        Patient patient = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("patient.select.by.id" + id));
            ResultSet resultSet = preparedStatement.executeQuery();
            String firstName = resultSet.getString(2);
            String secondName = resultSet.getString(3);
            String surname = resultSet.getString(4);
            patient = new Patient(id, firstName, secondName, surname);
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return patient;
    }

    /**
     * create patient
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
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("patient.delete.by.id" + id));
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

    /**
     * delete Patient
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean delete(final Patient object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("appointment.delete"
                    + object.getPatientID()));
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

    /**
     * create patient
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean create(final Patient object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("patient.insert"));
            preparedStatement.setString(1, object.getFirstName());
            preparedStatement.setString(2, object.getSecondName());
            preparedStatement.setString(3, object.getSurname());
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

    /**
     * update Patient
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean update(final Patient object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("patient.update"
                    + object.getPatientID()));
            preparedStatement.setString(1, object.getFirstName());
            preparedStatement.setString(2, object.getSecondName());
            preparedStatement.setString(3, object.getSurname());
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

    /**
     * create patient and return ID
     *
     * @param firstName  first name
     * @param secondName second name
     * @param surname    surname
     * @return id
     * @throws SQLException sql exception
     */
    public int createPatientAndReturnID(final String firstName, final String secondName, final String surname)
            throws SQLException {
        int id = -1;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("patient.insert"),
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, secondName);
            preparedStatement.setString(3, surname);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return id;
    }
}
