package by.epam.hospital.dao;

import by.epam.hospital.dao.mysqldao.MySQLAppointmentDAO;

/**
 * Abstract class DAO Factory
 */
public abstract class DAOFactory {
    /**
     * DAO for Staff
     *
     * @return DAO for Staff
     */
    public abstract AbstractDAO getStaff();

    /**
     * DAO for Doctor
     *
     * @return DAO for Doctor
     */
    public abstract AbstractDAO getDoctor();

    /**
     * DAO for Nurse
     *
     * @return DAO for Nurse
     */
    public abstract AbstractDAO getNurse();

    /**
     * DAO for Patient
     *
     * @return DAO for Patient
     */
    public abstract AbstractDAO getPatient();

    /**
     * DAO for Appointment
     *
     * @return DAO for Appointment
     */
    public abstract MySQLAppointmentDAO getAppointment();

    /**
     * DAO for Medical history
     *
     * @return DAO for Medical history
     */
    public abstract AbstractDAO getMedicalHistory();

    /**
     * method for getting DAO
     *
     * @param type DB type
     * @return dao for selected Database Management System
     */
    public static DAOFactory getDAOFactory(final DBType type) {
        DAOFactory daoFactory;
        switch (type) {
            case MySQL:
                daoFactory = new MySQLDAOFactory();
                break;
            default:
                daoFactory = null;
        }
        return daoFactory;
    }
}
