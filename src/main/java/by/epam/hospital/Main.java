package by.epam.hospital;

import by.epam.hospital.dao.DAOFactory;
import by.epam.hospital.dao.DBType;
import by.epam.hospital.entities.Doctor;

import java.sql.SQLException;


/**
 * Created by Vlad.Litoshik on 18.11.2015.
 */
public class Main {
    /**
     * @param args
     * @throws
     */
    public static void main(String[] args) {
        //adding records into a database

        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.MySQL);
        Doctor doctor = new Doctor("1", "2", "3", 1);
        System.out.println(doctor.toString());
        try {
           daoFactory.getStaff().create(doctor);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
