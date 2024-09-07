package br.com.fiap.javaChallenge.controller.person;

import br.com.fiap.javaChallenge.domainmodel.person.LegalPerson;
import br.com.fiap.javaChallenge.service.person.LegalPersonServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class LegalPersonController {

    @Autowired
    private @Setter LegalPersonServiceImpl service;

    @GetMapping("/addNewLegalPerson")
    public String addNewLegalPerson( Model model ){
        LegalPerson lgp = new LegalPerson();
        model.addAttribute("legalPerson", lgp);
        return "newLegalPerson";
    }

    @PostMapping("/saveLegalPerson")
    public String save( @ModelAttribute("legalPerson") LegalPerson legalPerson ){
        this.service.save( legalPerson );
        return "redirect:/legalPerson";
    }

    @GetMapping("/deleteLegalPerson/{id}")
    public String  deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/legalPerson";
    }

    @GetMapping("/legalPerson")
    public String viewHomePageAsList(Model model){
        List<LegalPerson> legalPersonList = this.service.findAllLegalPerson();
        model.addAttribute("allLegalPersonList", legalPersonList);
        return "index";
    }

    @GetMapping("/showFormForUpdateLegalPerson/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<LegalPerson> legalPerson  = this.service.findById(id);
        if(legalPerson.isPresent())
            model.addAttribute("legalPerson", legalPerson.get());
        else
            System.out.println("Error");
        return "updateLegalPerson";

    }

    @PostMapping("/updateLegalPerson")
    public String update( @ModelAttribute("legalPerson") LegalPerson legalPerson ){
        this.service.save( legalPerson );
        return "redirect:/legalPerson";
    }

    @GetMapping("/showLegalPerson/{id}")
    public String showLegalPerson( @PathVariable("id") Long id, Model model){
        Optional<LegalPerson> legalPerson = this.service.findById(id);

        if( legalPerson.isPresent() )
            model.addAttribute("legalPerson", legalPerson.get());
        else
            System.out.println("Error");
        return "showLegalPerson";
    }
}
