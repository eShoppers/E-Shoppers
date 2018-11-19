package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Product;
import edu.mum.cs425.project.eshoppers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AddToCartController {
    @Autowired
    ProductService productService;
    @GetMapping(value = "/AddToCart")
    public String contactus() {
        return "webapps/AddToCart";
    }

    @RequestMapping(value="/AddToCart/{id}", method = RequestMethod.GET)
    public ModelAndView productList(@PathVariable Long id) {
           Product product= productService.findOne(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("webapps/AddToCart");
        return modelAndView;

    }
    @RequestMapping(value="/MultiplyPrice/{unitPrice}", method = RequestMethod.GET)
    public ModelAndView MultiplyPrice(@PathVariable Double unitPrice,@PathVariable int totalPrice) {
        System.out.println("ghj");
        double result=unitPrice*totalPrice;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result", result);
        modelAndView.setViewName("webapps/AddToCart");
        return modelAndView;

    }
}
