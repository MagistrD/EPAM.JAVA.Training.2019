package by.epam.hospital.dao;

import by.epam.hospital.dao.mysqldao.*;
import by.epam.hospital.config.ConfigurationManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * MySQL DAO Factory
 */
public class MySQLDAOFactory extends DAOFactory {

    /**
     * method get conneticon
     *
     * @return connection
     * @throws SQLException exc
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(ConfigurationManager.get("db.url"), ConfigurationManager.get("db.login"),
                ConfigurationManager.get("db.password"));
    }

    /**
     * constructor
     */
    public MySQLDAOFactory() {
        try {
            String driver = ConfigurationManager.get("mysql.driver");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get staff
     *
     * @return MySQLStaffDAO
     */
    public AbstractDAO getStaff() {
        return new MySQLStaffDAO();
    }

    /**
     * Get doctor
     *
     * @return MySQLDoctorDAO
     */
    public AbstractDAO getDoctor() {
        return new MySQLDoctorDAO();
    }

    /**
     * Get nurse
     *
     * @return MySQLNurseDAO
     */
    public AbstractDAO getNurse() {
        return new MySQLNurseDAO();
    }

    /**
     * Get patient
     *
     * @return MySQLPatientDAO
     */
    public AbstractDAO getPatient() {
        return new MySQLPatientDAO();
    }

    /**
     * get Appointment
     *
     * @return MySQLAppointmentDAO
     */
    public AbstractDAO getAppointment() {
        return new MySQLAppointmentDAO();
    }


    /**
     * get Medical history
     *
     * @return MySQLMedicalHistoryDAO
     */
    public AbstractDAO getMedicalHistory() {
        return new MySQLMedicalHistoryDAO();
    }

    /**
     * get Staff specialization
     *
     * @return MySQLSpecializationDAO
     */
    public AbstractDAO getStaffSpecialization() {
        return new MySQLSpecializationDAO();
    }

    /**
     * get appointment type
     *
     * @return MySQLAppointmentTypeDAO
     */
    public AbstractDAO getAppointmentType() {
        return new MySQLAppointmentTypeDAO();
    }

}
