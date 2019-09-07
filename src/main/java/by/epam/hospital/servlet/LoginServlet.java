package by.epam.hospital.servlet;

import by.epam.hospital.entities.User;
import by.epam.hospital.logic.LoginLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * servlet for login
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        LoginLogic loginLogic = new LoginLogic();
        User user = loginLogic.getUserFromDB(username, password, type);
        if (user != null) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("authuser", true);
                Cookie usernameCookie = new Cookie("user", username);
                Cookie userType = new Cookie("type", type);
                Cookie id = new Cookie("ID", Integer.toString(user.getPeopleID()));
                Cookie userSubType = new Cookie("subType", user.getSubType());
                resp.addCookie(usernameCookie);
                resp.addCookie(userType);
                resp.addCookie(userSubType);
                resp.addCookie(id);
                if (user.getType().equals("patient")) {
                    resp.sendRedirect("/html/view/patient_view/medical_histories_for_patients.html");
                } else if (user.getType().equals("staff") && user.getSubType().equals("1")) {
                    resp.sendRedirect("/html/view/administrator_view/admin_menu.html");
                } else if (user.getType().equals("staff") && user.getSubType().equals("2")) {
                    resp.sendRedirect("/html/view/nurse_view/medical_histories_for_nurse.html");
                } else {
                    resp.sendRedirect("/html/view/doctor_view/medical_histories_for_doctor.html");
                }
            }
        } else {
            resp.sendRedirect("/html/login.html");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/html/login.html");
            PrintWriter writer = resp.getWriter();
            writer.println("Either user name or password is wrong.");
            requestDispatcher.include(req, resp);
        }
    }
}

