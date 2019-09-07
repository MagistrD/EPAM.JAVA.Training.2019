package by.epam.hospital.logic;

import by.epam.hospital.dao.DAOFactory;
import by.epam.hospital.dao.DBType;
import by.epam.hospital.entities.Staff;

import java.sql.SQLException;
import java.util.List;

/**
 * logic for staff
 */
public class StaffLogic {
    /**
     * read all staff
     * @return list of staff
     */
    public static List<Staff> readAllStaff() {
        List staffList = null;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            staffList = daoFactory.getStaff().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;
    }

    /**
     * create staff
     * @param staff staff object
     * @return is create
     */
    public static boolean createStaff(final Staff staff) {
        boolean flag = false;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);

        try {
            flag = daoFactory.getStaff().create(staff);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * update staff
     * @param staff staff object
     * @return is update
     */
    public static boolean updateStaff(final Staff staff) {
        boolean flag = false;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);

        try {
            flag = daoFactory.getStaff().update(staff);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * delete staff
     * @param i id
     * @return is delete
     */
    public static boolean deleteStaff(final int i) {
        boolean flag = false;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            flag = daoFactory.getStaff().delete(Integer.valueOf(i));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
