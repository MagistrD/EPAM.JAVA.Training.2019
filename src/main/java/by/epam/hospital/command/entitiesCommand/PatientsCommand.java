package by.epam.hospital.command.entitiesCommand;

import by.epam.hospital.command.ActionCommand;
import by.epam.hospital.entities.Patient;
import by.epam.hospital.logic.PatientLogic;
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
 * patient command
 */
public class PatientsCommand implements ActionCommand {
    @Override
    public String create(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = bufferedReader.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        Patient patient = null;
        try {
            patient = objectMapper.readValue(json, Patient.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        if (PatientLogic.createPatient(patient)) {
            return "Specialization created";
        } else {
            return "Specialization not created";
        }
    }

    @Override
    public String read(final HttpServletRequest request, final HttpServletResponse response) {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonAllPatients = "";
        List<Patient> staffSpecializationList = PatientLogic.readAllPatients();
        try {
            jsonAllPatients = objectWriter.writeValueAsString(staffSpecializationList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonAllPatients;
    }

    @Override
    public String update(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = br.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        Patient patient = null;
        try {
            patient = objectMapper.readValue(json, Patient.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        if (PatientLogic.updatePatient(patient)) {
            return "Object update!";
        } else {
            return "Not update";
        }
    }

    @Override
    public String delete(final HttpServletRequest request, final HttpServletResponse response) {
        int i = Integer.valueOf(request.getParameter("id"));
        if (PatientLogic.deletePatient(i)) {
            return "Object was delete";
        } else {
            return "Object wasn't delete!";
        }
    }
}
