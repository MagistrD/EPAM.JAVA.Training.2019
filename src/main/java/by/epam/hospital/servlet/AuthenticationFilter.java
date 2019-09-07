package by.epam.hospital.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Authentication filter
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {
    private ServletContext context;

    /**
     * destroy filter
     */
    public void destroy() {
    }

    /**
     * filter request by authentication
     * @param req request
     * @param resp response
     * @param chain filter chain
     * @throws ServletException servlet exception
     * @throws IOException IO exception
     */
    public void doFilter(final ServletRequest req, final ServletResponse resp, final FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri = request.getRequestURI();
        this.context.log("Requested Resource::" + uri);
        HttpSession session = request.getSession(false);
        if (session != null) {
            boolean authUser = (boolean) session.getAttribute("authuser");

            if (authUser) {
                chain.doFilter(request, response);
            } else {
                response.sendRedirect("/html/login.html");
            }
        } else {
            if (uri.endsWith("login.html") || uri.endsWith("registration.html") || uri.endsWith("/login")
                    || uri.endsWith("/registration")) {
                chain.doFilter(request, response);
            } else {
                this.context.log("Unauthorized access request");
                response.sendRedirect("/html/login.html");
            }
        }
    }

    /**
     * when filter init
     * @param config filter config
     * @throws ServletException servlet exception
     */
    public void init(final FilterConfig config) throws ServletException {
        this.context = config.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

}
