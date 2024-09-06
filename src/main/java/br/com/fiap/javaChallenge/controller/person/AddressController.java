package br.com.fiap.javaChallenge.controller.person;

import br.com.fiap.javaChallenge.domainmodel.person.Address;
import br.com.fiap.javaChallenge.service.person.AddressServiceImpl;
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
public class AddressController {

    @Autowired
    private @Setter AddressServiceImpl service;

    @GetMapping("/addNew")
    public String addNewAddress( Model model ){
        Address add = new Address();
        model.addAttribute("address", add);
        return "newAddress";
    }

    @PostMapping("/save")
    public String save( @ModelAttribute("address") Address address ){
        this.service.save( address );
        return "redirect:/";
    }

    @GetMapping("/deleteAddress/{id}")
    public String  deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/";
    }

    //http://locahost:8080/
    @GetMapping("/")
    public String viewHomePageAsList(Model model){
        List<Address> addressList = this.service.findAllAddress();
        model.addAttribute("allAddressList", addressList);
        return "index";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Address> address  = this.service.findById(id);
        if(address.isPresent())
            model.addAttribute("employee", address.get());
        else
            System.out.println("Erro");
        return "update";

    }

    @PostMapping("/update")
    public String update( @ModelAttribute("address") Address address ){
        this.service.save( address );
        return "redirect:/";
    }

    @GetMapping("/show/{id}")
    public String showAddress( @PathVariable("id") Long id, Model model){
        Optional<Address> address = this.service.findById(id);

        if( address.isPresent() )
            model.addAttribute("address", address.get());
        else
            System.out.println("Erro");
        return "showAddress";
    }
}
