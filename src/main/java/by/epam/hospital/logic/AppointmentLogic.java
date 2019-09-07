package by.epam.hospital.logic;

import by.epam.hospital.dao.mysqldao.MySQLAppointmentDAO;
import by.epam.hospital.entities.Appointment;

import java.sql.SQLException;

/**
 * Logic for Appointment
 */
public class AppointmentLogic {
    /**
     * create appointment and return ID
     *
     * @param appointment appointment
     * @return id
     */
    public static int createAppointmentAndReturnID(final Appointment appointment) {
        int id = -1;
        MySQLAppointmentDAO mySQLAppointmentDAO = new MySQLAppointmentDAO();
        try {
            id = mySQLAppointmentDAO.createAndReturnID(appointment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static Appointment getAppointmentByID(int id) {
        Appointment appointment = null;
        MySQLAppointmentDAO mySQLAppointmentDAO = new MySQLAppointmentDAO();
        try {
            appointment = mySQLAppointmentDAO.findObjectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }

}
