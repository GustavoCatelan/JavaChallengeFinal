package br.com.fiap.javaChallenge.controller.product;

import br.com.fiap.javaChallenge.domainmodel.product.Service;
import br.com.fiap.javaChallenge.service.product.ServiceServiceImpl;
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
public class ServiceController {

    @Autowired
    private @Setter ServiceServiceImpl service;

    @GetMapping("/addNewService")
    public String addNewService( Model model ){
        Service ser = new Service();
        model.addAttribute("service", ser);
        return "newService";
    }

    @PostMapping("/saveService")
    public String save( @ModelAttribute("service") Service service ){
        this.service.save( service );
        return "redirect:/service";
    }

    @GetMapping("/deleteService/{id}")
    public String  deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/service";
    }

    @GetMapping("/service")
    public String viewHomePageAsList(Model model){
        List<Service> serviceList = this.service.findAllService();
        model.addAttribute("allServiceList", serviceList);
        return "index";
    }

    @GetMapping("/showFormForUpdateService/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Service> service  = this.service.findById(id);
        if(service.isPresent())
            model.addAttribute("service", service.get());
        else
            System.out.println("Error");
        return "updateService";

    }

    @PostMapping("/updateService")
    public String update( @ModelAttribute("service") Service service ){
        this.service.save( service );
        return "redirect:/service";
    }

    @GetMapping("/showService/{id}")
    public String showService( @PathVariable("id") Long id, Model model){
        Optional<Service> service = this.service.findById(id);

        if( service.isPresent() )
            model.addAttribute("service", service.get());
        else
            System.out.println("Error");
        return "showService";
    }
}
