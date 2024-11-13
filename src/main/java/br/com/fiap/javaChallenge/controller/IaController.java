package br.com.fiap.javaChallenge.controller;

import br.com.fiap.javaChallenge.service.IaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class IaController {

    private static final Logger LOG = Logger.getLogger(IaController.class.getName());
    private final IaService iaService;

    public IaController(IaService iaService) {
        this.iaService = iaService;
    }

    @PostMapping("/prompt")
    public ResponseEntity<String> getResponse(@RequestBody String prompt) {
        LOG.log(Level.INFO, "Received prompt: {0}", prompt);

        if (prompt == null || prompt.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("O prompt não pode estar vazio.");
        }

        try {
            String response = iaService.chamadaApi(prompt);
            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            LOG.log(Level.SEVERE, "API error: {0}", e.getMessage());
            return ResponseEntity.status(e.getStatusCode()).body("Erro na API: " + e.getMessage());
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "General error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a solicitação: " + e.getMessage());
        }
    }
}