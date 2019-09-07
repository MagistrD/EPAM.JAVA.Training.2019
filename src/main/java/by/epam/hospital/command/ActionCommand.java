package by.epam.hospital.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * interface for CRUD operations
 */
public interface ActionCommand {
    /**
     * Create
     *
     * @param request  request
     * @param response response
     * @return string
     * @throws IOException exception
     */
    String create(HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * Read
     *
     * @param request  request
     * @param response response
     * @return string
     * @throws IOException exception
     */
    String read(HttpServletRequest request, HttpServletResponse response);

    /**
     * Update
     *
     * @param request  request
     * @param response response
     * @return string
     * @throws IOException exception
     */
    String update(HttpServletRequest request, HttpServletResponse response) throws IOException;

    /**
     * Delete
     *
     * @param request  request
     * @param response response
     * @return string
     */
    String delete(HttpServletRequest request, HttpServletResponse response);

}
