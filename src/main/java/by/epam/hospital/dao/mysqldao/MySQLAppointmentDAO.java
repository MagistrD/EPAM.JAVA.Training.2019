package by.epam.hospital.dao.mysqldao;

import by.epam.hospital.conpool.DBConnectionPool;
import by.epam.hospital.config.ConfigurationManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * MySQL appointment DAO
 */
public class MySQLAppointmentDAO implements AbstractDAO<Integer, Appointment> {
    private static final DBConnectionPool CONNECTION_POOL = new DBConnectionPool(ConfigurationManager.get("db.url"),
            ConfigurationManager.get("db.login"), ConfigurationManager.get("db.password"), 16);

    @Override
    public List<Appointment> findAll() throws SQLException {
        List<Appointment> appointmentList = new ArrayList<Appointment>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("appointment.select.all"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String description = resultSet.getString(2);
                Date appointmentDate = resultSet.getDate(3);
                Date dateOfExecution = resultSet.getDate(4);
                int executorID = resultSet.getInt(5);
                int typeID = resultSet.getInt(6);
                appointmentList.add(new Appointment(id, description, appointmentDate, dateOfExecution, executorID,
                        typeID));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception in 'Staff select all'" + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return appointmentList;
    }

    @Override
    public Appointment findObjectById(final Integer id) throws SQLException {
        Appointment appointment = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("appointment.select.by.id" + id));
            ResultSet resultSet = preparedStatement.executeQuery();
            String description = resultSet.getString(2);
            Date appointmentDate = resultSet.getDate(3);
            Date dateOfExecution = resultSet.getDate(4);
            int executorID = resultSet.getInt(5);
            int typeID = resultSet.getInt(6);
            appointment = new Appointment(id, description, appointmentDate, dateOfExecution, executorID, typeID);

        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return appointment;
    }

    @Override
    public boolean delete(final Integer id) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("appointment.delete.by.id" + id));
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
    public boolean delete(final Appointment object) throws SQLException {
        boolean b = true;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("appointment.delete"
                    + object.getAppointmentID()));
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
    public boolean create(final Appointment object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("appointment.insert"));
            preparedStatement.setString(1, object.getDescription());
            preparedStatement.setDate(2, (java.sql.Date) object.getAppointment());
            preparedStatement.setDate(3, (java.sql.Date) object.getExecution());
            preparedStatement.setInt(4, object.getAppointmentTypeID());
            preparedStatement.setInt(5, object.getExecutorID());
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
    public boolean update(final Appointment object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("appointment.update"
                    + object.getAppointmentID()));
            preparedStatement.setString(1, object.getDescription());
            preparedStatement.setDate(2, (java.sql.Date) object.getAppointment());
            preparedStatement.setDate(3, (java.sql.Date) object.getExecution());
            preparedStatement.setInt(4, object.getAppointmentTypeID());
            preparedStatement.setInt(5, object.getExecutorID());
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
