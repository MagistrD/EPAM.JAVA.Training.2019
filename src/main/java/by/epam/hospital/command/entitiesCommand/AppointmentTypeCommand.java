package by.epam.hospital.command.entitiesCommand;

import by.epam.hospital.command.ActionCommand;
import by.epam.hospital.entities.AppointmentType;
import by.epam.hospital.logic.AppointmentTypeLogic;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * realize CRUD for Appointment type
 */
public class AppointmentTypeCommand implements ActionCommand {
    @Override
    public String create(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        return null;
    }

    @Override
    public String read(final HttpServletRequest request, final HttpServletResponse response) {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonAllAppointmentTypes = "";
        List<AppointmentType> appointmentTypeList = AppointmentTypeLogic.readAllAppointmentType();
        try {
            jsonAllAppointmentTypes = objectWriter.writeValueAsString(appointmentTypeList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonAllAppointmentTypes;
    }

    @Override
    public String update(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        return null;
    }

    @Override
    public String delete(final HttpServletRequest request, final HttpServletResponse response) {
        return null;
    }
}
