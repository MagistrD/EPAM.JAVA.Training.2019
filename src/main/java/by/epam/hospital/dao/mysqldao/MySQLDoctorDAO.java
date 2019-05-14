package by.epam.hospital.dao.mysqldao;

import by.epam.hospital.conpool.DBConnectionPool;
import by.epam.hospital.dao.AbstractDAO;
import by.epam.hospital.entities.Doctor;
import by.epam.hospital.config.ConfigurationManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * MySQL DAO for Doctor
 */
public class MySQLDoctorDAO implements AbstractDAO<Integer, Doctor> {
    private static final DBConnectionPool CONNECTION_POOL = new DBConnectionPool(ConfigurationManager.get("db.url"),
            ConfigurationManager.get("db.login"), ConfigurationManager.get("db.password"), 16);


    /**
     * find all doctors
     *
     * @return List od doctors
     * @throws SQLException exc
     */
    public List<Doctor> findAll() throws SQLException {
        List<Doctor> doctorList = new ArrayList<Doctor>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.doctor.select.all"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String secondName = resultSet.getString(3);
                String surname = resultSet.getString(4);
                int specialization = resultSet.getInt(5);
                doctorList.add(new Doctor(id, firstName, secondName, surname, specialization));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception in 'Staff select all'" + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return doctorList;
    }

    /**
     * find doctor by ID
     *
     * @param id ID
     * @return Doctor
     * @throws SQLException exc
     */
    public Doctor findObjectById(final Integer id) throws SQLException {
        Doctor doctor = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.doctor.select.by.id" + id));
            ResultSet resultSet = preparedStatement.executeQuery();

            String firstName = resultSet.getString(2);
            String secondName = resultSet.getString(3);
            String surname = resultSet.getString(4);
            int specialization = resultSet.getInt(5);

            doctor = new Doctor(id, firstName, secondName, surname, specialization);
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }


        return doctor;
    }

    /**
     * delete doctor by ID
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
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.doctor.delete.by.id" + id));
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
     * delete doctor
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean delete(final Doctor object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.doctor.delete"
                    + object.getDoctorID()));
            preparedStatement.executeUpdate();
            b = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        object.getDoctorID();
        return b;
    }

    /**
     * create doctor
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean create(final Doctor object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.doctor.insert"));
            preparedStatement.setString(1, object.getFirstName());
            preparedStatement.setString(2, object.getSecondName());
            preparedStatement.setString(3, object.getSurname());
            preparedStatement.setInt(4, object.getStaffType());
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
     * update doctor
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean update(final Doctor object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.doctor.update"));
            preparedStatement.setString(1, object.getFirstName());
            preparedStatement.setString(2, object.getSecondName());
            preparedStatement.setString(3, object.getSurname());
            preparedStatement.setInt(4, object.getStaffType());
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
