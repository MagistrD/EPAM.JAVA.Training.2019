package by.epam.hospital.logic;

import by.epam.hospital.dao.DAOFactory;
import by.epam.hospital.dao.DBType;
import by.epam.hospital.entities.Nurse;

import java.sql.SQLException;
import java.util.List;

/**
 * logic for nurses
 */
public class NurseLogic {
    /**
     * read all nurses from staff
     *
     * @return list of nurses
     */
    public static List<Nurse> readAllNurses() {
        List nurseList = null;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            nurseList = daoFactory.getNurse().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nurseList;
    }
}
