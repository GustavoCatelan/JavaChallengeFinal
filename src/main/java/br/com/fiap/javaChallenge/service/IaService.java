package br.com.fiap.javaChallenge.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class IaService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL_TEMPLATE = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=%s";

    // Supondo que a chave API foi movida para o application.properties
    @Value("${api.key}")
    private String apiKey;

    public String chamadaApi(final String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        String requestBody = requestJSONCreator(prompt);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        String apiUrl = String.format(API_URL_TEMPLATE, apiKey);

        try {
            ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, String.class);
            Logger.getLogger(IaService.class.getName()).log(Level.INFO, "Response from API: " + response.getBody());
            return response.getBody();
        } catch (RestClientException e) {
            Logger.getLogger(IaService.class.getName()).log(Level.SEVERE, "API call failed", e);
            return "API call failed: " + e.getMessage();
        }
    }

    private String requestJSONCreator(final String prompt) throws RuntimeException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode contentNode = objectMapper.createObjectNode();
        ObjectNode partsNode = objectMapper.createObjectNode();
        partsNode.put("text", prompt);
        contentNode.set("parts", objectMapper.createArrayNode().add(partsNode));
        ObjectNode requestBodyNote = objectMapper.createObjectNode();
        requestBodyNote.set("contents", objectMapper.createArrayNode().add(contentNode));
        String requestBody = "";
        try {
            requestBody = objectMapper.writeValueAsString(requestBodyNote);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(IaService.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Failed to construct JSON request body object representarion!");
        }
        return requestBody;
    }
}