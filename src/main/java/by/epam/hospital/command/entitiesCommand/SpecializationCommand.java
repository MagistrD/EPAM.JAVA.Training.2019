package by.epam.hospital.command.entitiesCommand;

import by.epam.hospital.command.ActionCommand;
import by.epam.hospital.entities.StaffSpecialization;
import by.epam.hospital.logic.StaffSpecializationLogic;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * command for specialization
 */
public class SpecializationCommand implements ActionCommand {
    @Override
    public String create(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = bufferedReader.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        StaffSpecialization specialization = null;
        try {
            specialization = objectMapper.readValue(json, StaffSpecialization.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        if (StaffSpecializationLogic.createSpecialization(specialization)) {
            return "Specialization created";
        } else {
            return "Specialization not created";
        }
    }

    @Override
    public String read(final HttpServletRequest request, final HttpServletResponse response) {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonAllSpecializations = "";
        List<StaffSpecialization> staffSpecializationList = StaffSpecializationLogic.readAllSpecializations();
        try {
            jsonAllSpecializations = objectWriter.writeValueAsString(staffSpecializationList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonAllSpecializations;
    }

    @Override
    public String update(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = br.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        StaffSpecialization specialization = null;
        try {
            specialization = objectMapper.readValue(json, StaffSpecialization.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        if (StaffSpecializationLogic.updateStaffSpecialization(specialization)) {
            return "Object update!";
        } else {
            return "Not update";
        }
    }

    @Override
    public String delete(final HttpServletRequest request, final HttpServletResponse response) {
        int i = Integer.valueOf(request.getParameter("id"));
        if (StaffSpecializationLogic.deleteStaffSpecialization(i)) {
            return "Specialization was delete";
        } else {
            return "Specialization wasn't delete!";
        }
    }
}
