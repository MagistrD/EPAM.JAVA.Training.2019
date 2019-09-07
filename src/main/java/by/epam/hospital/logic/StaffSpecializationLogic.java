package by.epam.hospital.logic;

import by.epam.hospital.dao.DAOFactory;
import by.epam.hospital.dao.DBType;
import by.epam.hospital.entities.StaffSpecialization;

import java.sql.SQLException;
import java.util.List;

/**
 * logic for staff specialization
 */
public class StaffSpecializationLogic {

    /**
     * create specialization
     *
     * @param specialization specialization object
     * @return is create
     */
    public static boolean createSpecialization(final StaffSpecialization specialization) {
        boolean flag = false;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            flag = daoFactory.getStaffSpecialization().create(specialization);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * read all specialization
     *
     * @return list of specializations
     */
    public static List<StaffSpecialization> readAllSpecializations() {
        List specializationsList = null;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            specializationsList = daoFactory.getStaffSpecialization().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specializationsList;
    }

    /**
     * update specialization
     *
     * @param specialization specialization object
     * @return is update
     */
    public static boolean updateStaffSpecialization(final StaffSpecialization specialization) {
        boolean flag = false;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            flag = daoFactory.getStaffSpecialization().update(specialization);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * delete staff specialization
     * @param id id
     * @return is delete
     */
    public static boolean deleteStaffSpecialization(final int id) {
        boolean flag = false;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            flag = daoFactory.getStaffSpecialization().delete(Integer.valueOf(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
