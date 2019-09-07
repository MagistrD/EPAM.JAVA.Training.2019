package by.epam.hospital.servlet;

import by.epam.hospital.command.ActionCommand;
import by.epam.hospital.command.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet 'controller'. Use for the main functionality
 */
@WebServlet(name = "Controller", urlPatterns = "/controller")
public class Controller extends HttpServlet {

    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        String responseString;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        responseString = command.read(request, response);
        response.getOutputStream().write(responseString.getBytes());
    }

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        String responseString;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        responseString = command.create(request, response);
        response.getOutputStream().write(responseString.getBytes());
    }


    protected void doDelete(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        String responseString;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        responseString = command.delete(request, response);
        response.getOutputStream().write(responseString.getBytes());
    }

    @Override
    protected void doPut(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        String responseString;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);

        responseString = command.update(request, response);
        response.getOutputStream().write(responseString.getBytes());

    }
}
