package by.epam.hospital.logic;

import by.epam.hospital.dao.DAOFactory;
import by.epam.hospital.dao.DBType;
import by.epam.hospital.dao.mysqldao.MySQLMedicalHistoryDAO;
import by.epam.hospital.entities.MedicalHistory;

import java.sql.SQLException;
import java.util.List;

/**
 * logic for medical histories
 */
public class MedicalHistoryLogic {

    /**
     * create
     * @param medicalHistory medical histories object
     * @return is created
     */
    public static boolean createMedicalHistory(final MedicalHistory medicalHistory) {
        boolean flag = false;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);

        try {
            flag = daoFactory.getMedicalHistory().create(medicalHistory);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * read all histories for choose staff
     * @param type type
     * @param subType subtype
     * @param id id
     * @return list of histories
     */
    public static List<MedicalHistory> getHistoriesFor(final String type, final int subType, final int id) {
        List historyList = null;
        MySQLMedicalHistoryDAO mySQLMedicalHistoryDAO = new MySQLMedicalHistoryDAO();
        try {
            historyList = mySQLMedicalHistoryDAO.getAllHistoryFor(type, subType, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historyList;
    }

    /**
     * read all histories
     * @return list of histories
     */
    public static List<MedicalHistory> readAllHistories() {
        List historiesList = null;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            historiesList = daoFactory.getMedicalHistory().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historiesList;
    }
}
