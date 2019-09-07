package by.epam.hospital.logic;

import by.epam.hospital.dao.DAOFactory;
import by.epam.hospital.dao.DBType;
import by.epam.hospital.entities.Doctor;

import java.sql.SQLException;
import java.util.List;

/**
 * logic for doctors
 */
public class DoctorLogic {
    /**
     * read all doctors
     * @return list with all doctors
     */
    public static List<Doctor> readAllDoctors() {
        List docList = null;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            docList = daoFactory.getDoctor().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return docList;
    }
}
