package by.epam.hospital.logic;

import by.epam.hospital.dao.DAOFactory;
import by.epam.hospital.dao.DBType;
import by.epam.hospital.entities.Patient;

import java.sql.SQLException;
import java.util.List;

/**
 * logic for patients
 */
public class PatientLogic {

    /**
     * read all patients
     * @return list of patients
     */
    public static List<Patient> readAllPatients() {
        List patientList = null;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            patientList = daoFactory.getPatient().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientList;
    }

    /**
     * create patient
     * @param patient patient object
     * @return is create
     */
    public static boolean createPatient(final Patient patient) {
        boolean b = false;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            b = daoFactory.getPatient().create(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    /**
     * update patient
     * @param patient patient object
     * @return is update
     */
    public static boolean updatePatient(final Patient patient) {
        boolean b = false;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            b = daoFactory.getPatient().update(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    /**
     * delete patient by id
     * @param id id
     * @return is delete
     */
    public static boolean deletePatient(final int id) {
        boolean b = false;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            b = daoFactory.getPatient().delete(Integer.valueOf(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }


}
