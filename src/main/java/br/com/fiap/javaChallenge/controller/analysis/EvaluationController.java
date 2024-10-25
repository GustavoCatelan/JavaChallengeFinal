package br.com.fiap.javaChallenge.controller.analysis;

import br.com.fiap.javaChallenge.domainmodel.analysis.Evaluation;
import br.com.fiap.javaChallenge.service.analysis.EvaluationServiceImpl;
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
public class EvaluationController {

    @Autowired
    private @Setter EvaluationServiceImpl service;

    @GetMapping("/addNewEvaluation")
    public String addNewEvaluation( Model model ){
        Evaluation eva = new Evaluation();
        model.addAttribute("evaluation", eva);
        return "newEvaluation";
    }

    @PostMapping("/saveEvaluation")
    public String save( @ModelAttribute("evaluation") Evaluation evaluation ){
        this.service.save( evaluation );
        return "redirect:/evaluation";
    }

    @GetMapping("/deleteEvaluation/{id}")
    public String deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/evaluation";
    }

    @GetMapping("/evaluation")
    public String viewHomePageAsList(Model model){
        List<Evaluation> evaluationList = this.service.findAllEvaluation();
        model.addAttribute("allEvaluationList", evaluationList);
        return "indexEvaluation";
    }

    @GetMapping("/showFormForUpdateEvaluation/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Evaluation> evaluation  = this.service.findById(id);
        if(evaluation.isPresent())
            model.addAttribute("evaluation", evaluation.get());
        else
            System.out.println("Error");
        return "updateEvaluation";

    }

    @PostMapping("/updateEvaluation")
    public String update( @ModelAttribute("evaluation") Evaluation evaluation ){
        this.service.save( evaluation );
        return "redirect:/evaluation";
    }

}
