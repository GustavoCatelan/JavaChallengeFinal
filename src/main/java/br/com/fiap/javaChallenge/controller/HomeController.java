package br.com.fiap.javaChallenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

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

    @GetMapping("/indexDistributor")
    public String indexDistributor() {
        return "indexDistributor";
    }

    @GetMapping("/indexLegalPerson")
    public String indexLegalPerson() {
        return "indexLegalPerson";
    }

    @GetMapping("/indexPhysicalPerson")
    public String indexPhysicalPerson() {
        return "indexPhysicalPerson";
    }

    @GetMapping("/indexTelephone")
    public String indexTelephone() {
        return "indexTelephone";
    }

    @GetMapping("/indexUsers")
    public String indexUsers() {
        return "indexUsers";
    }

    @GetMapping("/indexProduct")
    public String indexProduct() {
        return "indexProduct";
    }

    @GetMapping("/indexService")
    public String indexService() {
        return "indexService";
    }

}