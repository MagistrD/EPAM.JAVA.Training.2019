package by.epam.hospital.command;

import javax.servlet.http.HttpServletRequest;

/**
 * class Action Command
 */
public class ActionFactory {
    /**
     * Parse request, find parameter and return current action
     * @param request request
     * @return current action
     */
    public ActionCommand defineCommand(final HttpServletRequest request) {
        ActionCommand current = null;
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
        }
        return current;
    }
}
