package br.com.fiap.javaChallenge.controller.person;

import br.com.fiap.javaChallenge.domainmodel.person.PhysicalPerson;
import br.com.fiap.javaChallenge.service.person.PhysicalPersonServiceImpl;
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
public class PhysicalPersonController {

    @Autowired
    private @Setter PhysicalPersonServiceImpl service;

    @GetMapping("/addNewPhysicalPerson")
    public String addNewPhysicalPerson( Model model ){
        PhysicalPerson psp = new PhysicalPerson();
        model.addAttribute("physicalPerson", psp);
        return "newPhysicalPerson";
    }

    @PostMapping("/savePhysicalPerson")
    public String save( @ModelAttribute("physicalPerson") PhysicalPerson physicalPerson ){
        this.service.save( physicalPerson );
        return "redirect:/physicalPerson";
    }

    @GetMapping("/deletePhysicalPerson/{id}")
    public String  deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/physicalPerson")
    public String viewHomePageAsList(Model model){
        List<PhysicalPerson> physicalPersonList = this.service.findAllPhysicalPerson();
        model.addAttribute("allPhysicalPersonList", physicalPersonList);
        return "index";
    }

    @GetMapping("/showFormForUpdatePhysicalPerson/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<PhysicalPerson> physicalPerson  = this.service.findById(id);
        if(physicalPerson.isPresent())
            model.addAttribute("physicalPerson", physicalPerson.get());
        else
            System.out.println("Error");
        return "update";

    }

    @PostMapping("/updatePhysicalPerson")
    public String update( @ModelAttribute("physicalPerson") PhysicalPerson physicalPerson ){
        this.service.save( physicalPerson );
        return "redirect:/physicalPerson";
    }

    @GetMapping("/showPhysicalPerson/{id}")
    public String showPhysicalPerson( @PathVariable("id") Long id, Model model){
        Optional<PhysicalPerson> physicalPerson = this.service.findById(id);

        if( physicalPerson.isPresent() )
            model.addAttribute("physicalPerson", physicalPerson.get());
        else
            System.out.println("Error");
        return "showPhysicalPerson";
    }
}
