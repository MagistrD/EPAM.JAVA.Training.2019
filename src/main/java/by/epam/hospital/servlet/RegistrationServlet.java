package by.epam.hospital.servlet;

import by.epam.hospital.logic.RegistrationLogic;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet for registration
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {

        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String surname = req.getParameter("surname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        RegistrationLogic registrationLogic = new RegistrationLogic();
        registrationLogic.createUser(firstName, secondName, surname, username, password);
        resp.sendRedirect("/html/login.html");
    }
}
