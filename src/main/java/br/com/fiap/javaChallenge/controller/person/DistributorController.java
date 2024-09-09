package br.com.fiap.javaChallenge.controller.person;

import br.com.fiap.javaChallenge.domainmodel.person.Distributor;
import br.com.fiap.javaChallenge.service.person.DistributorServiceImpl;
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
public class DistributorController {

    @Autowired
    public @Setter DistributorServiceImpl service;

    @GetMapping("/addNewDistributor")
    public String addNewDistributor( Model model ){
        Distributor dis = new Distributor();
        model.addAttribute("distributor", dis);
        return "newDistributor";
    }

    @PostMapping("/saveDistributor")
    public String save( @ModelAttribute("distributor") Distributor distributor ){
        this.service.save( distributor );
        return "redirect:/distributor";
    }

    @GetMapping("/deleteDistributor/{id}")
    public String  deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/distributor";
    }

    @GetMapping("/distributor")
    public String viewHomePageAsList(Model model){
        List<Distributor> distributorList = this.service.findAllDistributor();
        model.addAttribute("allDistributorList", distributorList);
        return "indexDistributor";
    }

    @GetMapping("/showFormForUpdateDistributor/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Distributor> distributor  = this.service.findById(id);
        if(distributor.isPresent())
            model.addAttribute("distributor", distributor.get());
        else
            System.out.println("Error");
        return "updateDistributor";

    }

    @PostMapping("/updateDistributor")
    public String update( @ModelAttribute("distributor") Distributor distributor ){
        this.service.save( distributor );
        return "redirect:/distributor";
    }

    @GetMapping("/showDistributor/{id}")
    public String showDistributor( @PathVariable("id") Long id, Model model){
        Optional<Distributor> distributor = this.service.findById(id);

        if( distributor.isPresent() )
            model.addAttribute("distributor", distributor.get());
        else
            System.out.println("Error");
        return "showDistributor";
    }
}
