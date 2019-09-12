package by.epam.hospital.logic;

import by.epam.hospital.dao.DAOFactory;
import by.epam.hospital.dao.DBType;
import by.epam.hospital.dao.mysqldao.MySQLPatientDAO;
import by.epam.hospital.dao.mysqldao.MySQLUserDAO;

import java.sql.SQLException;

/**
 * logic for registration
 */
public class RegistrationLogic {
    /**
     * create patient
     *
     * @param firstName  first name
     * @param secondName second name
     * @param surname    surname
     * @return id
     */
    public static int createPatient(final String firstName, final String secondName, final String surname) {
        int id = -1;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        MySQLPatientDAO mySQLPatientDAO = new MySQLPatientDAO();

        try {
            id = mySQLPatientDAO.createPatientAndReturnID(firstName, secondName, surname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * create user by parameters
     *
     * @param firstName  first name
     * @param secondName second name
     * @param surname    surname
     * @param username   username
     * @param password   password
     * @return is create
     */
    public static boolean createUser(final String firstName, final String secondName, final String surname,
                                     final String username, final String password) {
        boolean flag = false;
        MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
        try {
            int i = createPatient(firstName, secondName, surname);
            flag = mySQLUserDAO.createUserWithID(username, password, i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
