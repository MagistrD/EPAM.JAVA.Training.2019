package by.epam.hospital.command.entitiesCommand;

import by.epam.hospital.command.ActionCommand;
import by.epam.hospital.entities.Staff;
import by.epam.hospital.logic.StaffLogic;
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
 * command for staff
 */
public class StaffCommand implements ActionCommand {

    @Override
    public String create(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = br.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        Staff staff = null;
        try {
            staff = objectMapper.readValue(json, Staff.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        if (StaffLogic.createStaff(staff)) {
            return "Object created!";
        } else {
            return "Not created";
        }
    }

    @Override
    public String read(final HttpServletRequest request, final HttpServletResponse response) {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonAllStaff = "";
        List<Staff> staffList = StaffLogic.readAllStaff();
        try {
            jsonAllStaff = objectWriter.writeValueAsString(staffList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonAllStaff;
    }

    @Override
    public String update(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = br.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        Staff staff = null;
        try {
            staff = objectMapper.readValue(json, Staff.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        if (StaffLogic.updateStaff(staff)) {
            return "Object update!";
        } else {
            return "Not update";
        }
    }

    @Override
    public String delete(final HttpServletRequest request, final HttpServletResponse response) {
        int i = Integer.valueOf(request.getParameter("id"));

        if (StaffLogic.deleteStaff(i)) {
            return "Object was delete!";
        } else {
            return "Object wasn't delete";
        }
    }
}
