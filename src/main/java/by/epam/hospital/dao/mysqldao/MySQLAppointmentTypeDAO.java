package by.epam.hospital.dao.mysqldao;

import by.epam.hospital.config.ConfigurationManager;
import by.epam.hospital.conpool.DBConnectionPool;
import by.epam.hospital.dao.AbstractDAO;
import by.epam.hospital.entities.AppointmentType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for Appointment types
 */
public class MySQLAppointmentTypeDAO implements AbstractDAO<Integer, AppointmentType> {
    private static final DBConnectionPool CONNECTION_POOL = new DBConnectionPool(ConfigurationManager.get("db.url"),
            ConfigurationManager.get("db.login"), ConfigurationManager.get("db.password"), 16);

    @Override
    public List<AppointmentType> findAll() throws SQLException {
        List<AppointmentType> appointmentTypeList = new ArrayList<AppointmentType>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("appointment.type.select.all"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                appointmentTypeList.add(new AppointmentType(id, name));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception in 'Appointment type select all'" + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return appointmentTypeList;
    }

    @Override
    public AppointmentType findObjectById(final Integer id) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(final Integer id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(final AppointmentType object) throws SQLException {
        return false;
    }

    @Override
    public boolean create(final AppointmentType object) throws SQLException {
        return false;
    }

    @Override
    public boolean update(final AppointmentType object) throws SQLException {
        return false;
    }
}
