package br.com.fiap.javaChallenge.controller.product;

import br.com.fiap.javaChallenge.domainmodel.product.Product;
import br.com.fiap.javaChallenge.service.product.ProductServiceImpl;
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
public class ProductController {

    @Autowired
    private @Setter ProductServiceImpl service;

    @GetMapping("/addNewProduct")
    public String addNewProduct( Model model ){
        Product pro = new Product();
        model.addAttribute("product", pro);
        return "newProduct";
    }

    @PostMapping("/saveProduct")
    public String save( @ModelAttribute("product") Product product ){
        this.service.save( product );
        return "redirect:/product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String  deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/product";
    }

    @GetMapping("/product")
    public String viewHomePageAsList(Model model){
        List<Product> productList = this.service.findAllProduct();
        model.addAttribute("allProductList", productList);
        return "indexProduct";
    }

    @GetMapping("/showFormForUpdateProduct/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Product> product  = this.service.findById(id);
        if(product.isPresent())
            model.addAttribute("product", product.get());
        else
            System.out.println("Error");
        return "updateProduct";

    }

    @PostMapping("/updateProduct")
    public String update( @ModelAttribute("product") Product product ){
        this.service.save( product );
        return "redirect:/product";
    }
}
