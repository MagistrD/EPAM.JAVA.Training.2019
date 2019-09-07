package by.epam.hospital.command.entitiesCommand;

import by.epam.hospital.command.ActionCommand;
import by.epam.hospital.entities.MedicalHistory;
import by.epam.hospital.logic.MedicalHistoryLogic;
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
 * realized CRUD for medical histories
 */
public class MedicalHistoryCommand implements ActionCommand {
    @Override
    public String create(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = br.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        MedicalHistory medicalHistory = null;
        try {
            medicalHistory = objectMapper.readValue(json, MedicalHistory.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json");
        if (MedicalHistoryLogic.createMedicalHistory(medicalHistory)) {
            return "Object created!";
        } else {
            return "Not created";
        }
    }

    @Override
    public String read(final HttpServletRequest request, final HttpServletResponse response) {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonAllHistories = "";
        List<MedicalHistory> historyList = MedicalHistoryLogic.readAllHistories();
        try {
            jsonAllHistories = objectWriter.writeValueAsString(historyList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonAllHistories;

    }

    @Override
    public String update(final HttpServletRequest request, final HttpServletResponse response) {
        return null;
    }

    @Override
    public String delete(final HttpServletRequest request, final HttpServletResponse response) {
        return null;
    }

    /**
     * reading history by staff types and id
     * @param type type
     * @param subType subtype
     * @param id id
     * @return JSON string with histories
     */
    public String readByTypeAndID(final String type, final int subType, final int id) {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonAllHistory = "";
        List<MedicalHistory> medicalHistories = MedicalHistoryLogic.getHistoriesFor(type, subType, id);
        try {
            jsonAllHistory = objectWriter.writeValueAsString(medicalHistories);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonAllHistory;
    }
}
