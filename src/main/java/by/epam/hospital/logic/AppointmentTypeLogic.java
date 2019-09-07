package by.epam.hospital.logic;

import by.epam.hospital.dao.DAOFactory;
import by.epam.hospital.dao.DBType;
import by.epam.hospital.entities.AppointmentType;

import java.sql.SQLException;
import java.util.List;

/**
 * appointment type logic
 */
public class AppointmentTypeLogic {
    /**
     * reading all appointment types
     * @return list of appointment types
     */
    public static List<AppointmentType> readAllAppointmentType() {
        List appointmentTypeList = null;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        try {
            appointmentTypeList = daoFactory.getAppointmentType().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentTypeList;
    }
}
