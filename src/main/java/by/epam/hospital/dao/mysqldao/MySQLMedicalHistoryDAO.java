package by.epam.hospital.dao.mysqldao;

import by.epam.hospital.conpool.DBConnectionPool;
import by.epam.hospital.dao.AbstractDAO;
import by.epam.hospital.entities.MedicalHistory;
import by.epam.hospital.config.ConfigurationManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * MySQL Medical history DAO
 */
public class MySQLMedicalHistoryDAO implements AbstractDAO<Integer, MedicalHistory> {

    private static final DBConnectionPool CONNECTION_POOL = new DBConnectionPool(ConfigurationManager.get("db.url"),
            ConfigurationManager.get("db.login"), ConfigurationManager.get("db.password"), 16);

    /**
     * find all Medical history
     *
     * @return List of medical histories
     * @throws SQLException exc
     */
    public List<MedicalHistory> findAll() throws SQLException {
        List<MedicalHistory> medicalHistoryList = new ArrayList<MedicalHistory>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("medical.history.select.all"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int patientID = resultSet.getInt(2);
                int diagnosedID = resultSet.getInt(3);
                Date dateOfReceipt = resultSet.getDate(4);
                Date dateOdDischarged = resultSet.getDate(5);
                String diagnosis = resultSet.getString(6);
                String comment = resultSet.getString(7);
                int appointmentID = resultSet.getInt(8);
                medicalHistoryList.add(new MedicalHistory(id, patientID, diagnosedID, dateOfReceipt,
                        dateOdDischarged, diagnosis, comment, appointmentID));
            }
        } catch (SQLException e) {
            System.err.println("SQL exception in 'Staff select all'" + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return medicalHistoryList;
    }

    /**
     * find history by ID
     *
     * @param id ID
     * @return Medical history
     * @throws SQLException exc
     */
    public MedicalHistory findObjectById(final Integer id) throws SQLException {
        MedicalHistory medicalHistory = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("medical.history.select.by.id"
                    + id));
            ResultSet resultSet = preparedStatement.executeQuery();
            int patientID = resultSet.getInt(2);
            int diagnosedID = resultSet.getInt(3);
            Date dateOfReceipt = resultSet.getDate(4);
            Date dateOdDischarged = resultSet.getDate(5);
            String diagnosis = resultSet.getString(6);
            String comment = resultSet.getString(7);
            int appointmentID = resultSet.getInt(8);
            medicalHistory = new MedicalHistory(id, patientID, diagnosedID, dateOfReceipt, dateOdDischarged,
                    diagnosis, comment, appointmentID);
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return medicalHistory;
    }

    /**
     * delete history by ID
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
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("medical.history.delete.by.id"
                    + id));
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
     * delete Medical history
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean delete(final MedicalHistory object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("medical.history.delete"
                    + object.getMedicalHistoryID()));
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
     * create Mdeical history
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean create(final MedicalHistory object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("medical.history.insert"));
            preparedStatement.setInt(1, object.getPatientID());
            preparedStatement.setInt(2, object.getDiagnosedID());
            preparedStatement.setDate(3, (java.sql.Date) object.getDateOfReceipt());
            preparedStatement.setDate(4, (java.sql.Date) object.getDateOfDischarge());
            preparedStatement.setString(5, object.getDiagnosis());
            preparedStatement.setString(6, object.getComment());
            preparedStatement.setInt(7, object.getAppointmentID());
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
     * update medical history
     *
     * @param object object
     * @return true if success
     * @throws SQLException exc
     */
    public boolean update(final MedicalHistory object) throws SQLException {
        boolean b = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CONNECTION_POOL.getConnection();
            preparedStatement = connection.prepareStatement(ConfigurationManager.get("medical.history.update"
                    + object.getMedicalHistoryID()));
            preparedStatement.setInt(1, object.getPatientID());
            preparedStatement.setInt(2, object.getDiagnosedID());
            preparedStatement.setDate(3, (java.sql.Date) object.getDateOfReceipt());
            preparedStatement.setDate(4, (java.sql.Date) object.getDateOfDischarge());
            preparedStatement.setString(5, object.getDiagnosis());
            preparedStatement.setString(6, object.getComment());
            preparedStatement.setInt(7, object.getAppointmentID());
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
