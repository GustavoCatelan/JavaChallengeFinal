package br.com.fiap.javaChallenge.controller.person;

import br.com.fiap.javaChallenge.domainmodel.person.Person;
import br.com.fiap.javaChallenge.service.person.PersonServiceImpl;
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
public class PersonController {

    @Autowired
    private  @Setter PersonServiceImpl service;

    @GetMapping("/addNewPerson")
    public String addNewPerson( Model model ){
        Person per = new Person();
        model.addAttribute("person", per);
        return "newPerson";
    }

    @PostMapping("/savePerson")
    public String save( @ModelAttribute("person") Person person ){
        this.service.save( person );
        return "redirect:/person";
    }

    @GetMapping("/deletePerson/{id}")
    public String  deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/person";
    }

    @GetMapping("/person")
    public String viewHomePageAsList(Model model){
        List<Person> personList = this.service.findAllPerson();
        model.addAttribute("allPersonList", personList);
        return "indexPerson";
    }

    @GetMapping("/showFormForUpdatePerson/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Person> person  = this.service.findById(id);
        if(person.isPresent())
            model.addAttribute("person", person.get());
        else
            System.out.println("Error");
        return "updatePerson";

    }

    @PostMapping("/updatePerson")
    public String update( @ModelAttribute("Person") Person person ){
        this.service.save( person );
        return "redirect:/person";
    }

    @GetMapping("/showPerson/{id}")
    public String showPerson( @PathVariable("id") Long id, Model model){
        Optional<Person> person = this.service.findById(id);

        if( person.isPresent() )
            model.addAttribute("person", person.get());
        else
            System.out.println("Error");
        return "showPerson";
    }
}
