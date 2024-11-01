package br.com.fiap.javaChallenge.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class IaService {

    @Autowired
    private RestTemplate restTemplate;

    // Atualize a URL da API do Gemini
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=%s";

    private static final String API_KEY = "AIzaSyDqn8DBS6fCSY3LyvzLP1vrSUg_kf5W0Zc";

    public String chamadaApi(final String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", API_KEY);

        String requestBody = requestJSONCreator(prompt);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, request, String.class);
            Logger.getLogger(IaService.class.getName()).log(Level.INFO, "Response from API: " + response.getBody());
            return response.getBody();
        } catch (Exception e) {
            Logger.getLogger(IaService.class.getName()).log(Level.SEVERE, "Erro ao chamar a API: ", e);
            return "Erro ao processar a solicitação. Verifique sua chave de API e permissões.";
        }
    }

    private String requestJSONCreator(final String prompt) throws RuntimeException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode requestBodyNode = objectMapper.createObjectNode();
        requestBodyNode.put("model", "gemini"); // Altere o modelo, se necessário
        requestBodyNode.set("messages", objectMapper.createArrayNode()
                .add(objectMapper.createObjectNode().put("role", "user").put("content", prompt)));

        String requestBody;
        try {
            requestBody = objectMapper.writeValueAsString(requestBodyNode);
            Logger.getLogger(IaService.class.getName()).log(Level.INFO, "Request Body: " + requestBody);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(IaService.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Failed to construct JSON request body object representation!");
        }
        return requestBody;
    }
}