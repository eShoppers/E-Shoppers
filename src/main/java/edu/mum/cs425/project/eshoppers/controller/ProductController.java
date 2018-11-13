package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Product;
import edu.mum.cs425.project.eshoppers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "webapps/addProduct";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("product") Product product,
                       BindingResult result, Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "webapps/addProduct";
        }
        product = productService.save(product);

//        update with correct url
        return "redirect:/products";
    }
}
