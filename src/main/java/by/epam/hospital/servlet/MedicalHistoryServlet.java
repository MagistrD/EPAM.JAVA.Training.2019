package by.epam.hospital.servlet;

import by.epam.hospital.command.entitiesCommand.AppointmentCommand;
import by.epam.hospital.command.entitiesCommand.MedicalHistoryCommand;
import by.epam.hospital.logic.AppointmentLogic;
import by.epam.hospital.logic.MedicalHistoryLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet for medical histories
 */
@WebServlet(name = "MedicalHistoryServlet", urlPatterns = "/history")
public class MedicalHistoryServlet extends HttpServlet {

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        String type = req.getParameter("type");
        int id = 0;
        int subType = 0;
        // parsing cookies
        for (Cookie c : req.getCookies()) {
            if (c.getName().equals("type")) {
                type = c.getValue();
            }
            if (c.getName().equals("ID")) {
                id = Integer.parseInt(c.getValue());
            }
            if (c.getName().equals("subType") && !c.getValue().equals("")) {
                subType = Integer.parseInt(c.getValue());
            }
        }
        MedicalHistoryCommand medicalHistoryCommand = new MedicalHistoryCommand();
        String respString = medicalHistoryCommand.readByTypeAndID(type, subType, id);
        resp.getOutputStream().write(respString.getBytes());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("appointmentID"));

        AppointmentCommand appointmentCommand = new AppointmentCommand();
        String respString = appointmentCommand.getAppointmentByID(id);
        resp.getOutputStream().write(respString.getBytes());

    }
}
