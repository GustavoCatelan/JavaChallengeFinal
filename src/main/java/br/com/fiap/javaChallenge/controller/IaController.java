package br.com.fiap.javaChallenge.controller;

import br.com.fiap.javaChallenge.service.IaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class IaController {
    private static final Logger LOG = Logger.getLogger(IaController.class.getName());

    @Autowired
    private IaService iaService;

    @PostMapping("/prompt")
    public ResponseEntity<String> getResponse(@RequestBody String prompt) {
        LOG.log(Level.INFO, "Prompt to submit: " + prompt);

        if (prompt == null || prompt.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("O prompt não pode estar vazio.");
        }

        try {
            String response = iaService.chamadaApi(prompt);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error calling IA service", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a solicitação: " + e.getMessage());
        }
    }
}