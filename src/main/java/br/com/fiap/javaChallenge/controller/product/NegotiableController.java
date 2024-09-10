package br.com.fiap.javaChallenge.controller.product;

import br.com.fiap.javaChallenge.domainmodel.product.Negotiable;
import br.com.fiap.javaChallenge.service.product.NegotiableServiceImpl;
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
public class NegotiableController {

    @Autowired
    private @Setter NegotiableServiceImpl service;

    @GetMapping("/addNewNegotiable")
    public String addNewNegotiable( Model model ){
        Negotiable neg = new Negotiable();
        model.addAttribute("negotiable", neg);
        return "newNegotiable";
    }

    @PostMapping("/saveNegotiable")
    public String save( @ModelAttribute("negotiable") Negotiable negotiable  ){
        this.service.save(negotiable );
        return "redirect:/negotiable";
    }

    @GetMapping("/deleteNegotiable/{id}")
    public String  deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/negotiable";
    }

    @GetMapping("/negotiable")
    public String viewHomePageAsList(Model model){
        List<Negotiable> negotiableList = this.service.findAllNegotiable();
        model.addAttribute("allNegotiableList", negotiableList);
        return "indexNegotiable";
    }

    @GetMapping("/showFormForUpdateNegotiable/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Negotiable> negotiable  = this.service.findById(id);
        if(negotiable.isPresent())
            model.addAttribute("negotiable", negotiable.get());
        else
            System.out.println("Error");
        return "updateNegotiable";

    }

    @PostMapping("/updateNegotiable")
    public String update( @ModelAttribute("negotiable") Negotiable negotiable ){
        this.service.save( negotiable );
        return "redirect:/negotiable";
    }

    @GetMapping("/showNegotiable/{id}")
    public String showNegotiable( @PathVariable("id") Long id, Model model){
        Optional<Negotiable> negotiable = this.service.findById(id);

        if( negotiable.isPresent() )
            model.addAttribute("negotiable", negotiable.get());
        else
            System.out.println("Error");
        return "showNegotiable";
    }
}
