package br.com.fiap.javaChallenge.controller.person;

import br.com.fiap.javaChallenge.domainmodel.person.Users;
import br.com.fiap.javaChallenge.service.person.UsersServiceImpl;
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
public class UsersController {

    @Autowired
    private @Setter UsersServiceImpl service;

    @GetMapping("/addNewUsers")
    public String addNewUsers( Model model ){
        Users use = new Users();
        model.addAttribute("users", use);
        return "newUsers";
    }

    @PostMapping("/saveUsers")
    public String save( @ModelAttribute("users") Users users ){
        this.service.save( users );
        return "redirect:/users";
    }

    @GetMapping("/deleteUsers/{id}")
    public String  deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String viewHomePageAsList(Model model){
        List<Users> usersList = this.service.findAllUser();
        model.addAttribute("allUsersList", usersList);
        return "index";
    }

    @GetMapping("/showFormForUpdateUsers/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Users> users  = this.service.findById(id);
        if(users.isPresent())
            model.addAttribute("users", users.get());
        else
            System.out.println("Error");
        return "updateUsers";

    }

    @PostMapping("/updateUsers")
    public String update( @ModelAttribute("users") Users users ){
        this.service.save( users );
        return "redirect:/users";
    }

    @GetMapping("/showUsers/{id}")
    public String showUsers( @PathVariable("id") Long id, Model model){
        Optional<Users> users = this.service.findById(id);

        if( users.isPresent() )
            model.addAttribute("users", users.get());
        else
            System.out.println("Error");
        return "showUsers";
    }
}
