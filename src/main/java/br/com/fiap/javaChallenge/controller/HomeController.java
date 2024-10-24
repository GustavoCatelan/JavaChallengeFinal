package br.com.fiap.javaChallenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/indexAddress")
    public String indexAddress() {
        return "indexAddress";
    }

    @GetMapping("/indexEvaluation")
    public String indexEvaluation() {
        return "indexEvaluation";
    }

    @GetMapping("/indexNegotiable")
    public String indexNegotiable() {
        return "indexNegotiable";
    }

    @GetMapping("/indexPerson")
    public String indexPerson() {
        return "indexPerson";
    }

    @GetMapping("/indexDistributor")
    public String indexDistributor() {
        return "indexDistributor";
    }

    @GetMapping("/indexLegalPerson")
    public String indexLegalPerson() {
        return "indexLegalPerson";
    }

}