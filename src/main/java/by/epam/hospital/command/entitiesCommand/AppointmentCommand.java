package by.epam.hospital.command.entitiesCommand;

import by.epam.hospital.command.ActionCommand;
import by.epam.hospital.entities.Appointment;
import by.epam.hospital.logic.AppointmentLogic;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class for realization CRUD operations for Appointment table
 */
public class AppointmentCommand implements ActionCommand {

    @Override
    public String create(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = br.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        Appointment appointment = null;
        try {
            appointment = objectMapper.readValue(json, Appointment.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        int id = AppointmentLogic.createAppointmentAndReturnID(appointment);
        if (id > 0) {
            return Integer.toString(id);
        } else {
            return "Not created";
        }
    }

    @Override
    public String read(final HttpServletRequest request, final HttpServletResponse response) {
        return null;
    }

    @Override
    public String update(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        return null;
    }

    @Override
    public String delete(final HttpServletRequest request, final HttpServletResponse response) {
        return null;
    }


    public String getAppointmentByID(int id) {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonAppointment = "";
        Appointment appointment = AppointmentLogic.getAppointmentByID(id);
        try {
            jsonAppointment = objectWriter.writeValueAsString(appointment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonAppointment;
    }
}
