package by.epam.hospital.dao.mysqldao;

import by.epam.hospital.conpool.DBConnectionPool;
import by.epam.hospital.dao.AbstractDAO;
import by.epam.hospital.entities.Nurse;
import by.epam.hospital.config.ConfigurationManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * MySQL Nurse DAO
 */
public class MySQLNurseDAO implements AbstractDAO<Integer, Nurse> {
    private static final DBConnectionPool CONNECTION_POOL = new DBConnectionPool(ConfigurationManager.get("db.url"),
            ConfigurationManager.get("db.login"), ConfigurationManager.get("db.password"), 16);

    /**
     * find all Nuses
     *
     * @return List of Nurse
     * @throws SQLException exc
     */
    public List<Nurse> findAll() throws SQLException {
        List<Nurse> nurseList = new ArrayList<Nurse>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.select.all.nurse"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String secondName = resultSet.getString(3);
                String surname = resultSet.getString(4);
                int specialization = resultSet.getInt(5);
                nurseList.add(new Nurse(id, firstName, secondName, surname, specialization));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception in 'Staff select all'" + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return nurseList;
    }

    /**
     * find Nurse by ID
     *
     * @param id ID
     * @return Nurse
     * @throws SQLException exc
     */
    public Nurse findObjectById(final Integer id) throws SQLException {
        Nurse nurse = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.select.all.doctors" + id));
            ResultSet resultSet = preparedStatement.executeQuery();

            String firstName = resultSet.getString(2);
            String secondName = resultSet.getString(3);
            String surname = resultSet.getString(4);
            int specialization = resultSet.getInt(5);

            nurse = new Nurse(id, firstName, secondName, surname, specialization);
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return nurse;
    }

    /**
     * delete Nurse
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
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.delete.doctor.by.id" + id));
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
     * delete Nurse
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean delete(final Nurse object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.delete.doctor"
                    + object.getNurseID()));
            preparedStatement.executeUpdate();
            b = true;
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        object.getNurseID();
        return b;
    }

    /**
     * create Nurse
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean create(final Nurse object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.insert"
                    + object.getNurseID()));
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
     * update Nurse
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean update(final Nurse object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("staff.update"
                    + object.getNurseID()));
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
