package by.epam.hospital.logic;

import by.epam.hospital.dao.mysqldao.MySQLUserDAO;
import by.epam.hospital.entities.User;

import java.sql.SQLException;

/**
 * logic for login
 */
public class LoginLogic {
    /**
     * getting user from db by parameters
     * @param username username
     * @param password password
     * @param type type
     * @return User
     */
    public static User getUserFromDB(final String username, final String password, final String type) {
        User user = null;
        MySQLUserDAO userDAO = new MySQLUserDAO();
        try {
            user = userDAO.findUser(username, password, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
