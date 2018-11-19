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

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddToCartController {
    List<Product> listOfCart;
    @Autowired
    ProductService productService;
    @GetMapping(value = "/AddToCart")
    public String contactus() {
        return "webapps/AddToCart";
    }

//    @RequestMapping(value="/AddToCart/{id}", method = RequestMethod.GET)
//    public ModelAndView productList(@PathVariable Long id) {
//           Product product= productService.findOne(id);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("product", product);
//        modelAndView.setViewName("webapps/AddToCart");
//        return modelAndView;
//
//    }
    @RequestMapping(value="/AddToCart/{id}", method = RequestMethod.GET)
    public ModelAndView productListCart(@PathVariable Long id) {
        System.out.println("ghjk");
            if(listOfCart==null){
            listOfCart=new ArrayList<>();
        Product product= productService.findOne(id);
        listOfCart.add(product);}
        else
            {
                Product product= productService.findOne(id);
                listOfCart.add(product);
            }
            for(Product p: listOfCart)
                System.out.println(p.getProductName()+""+p.getUnitPrice());
         ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", listOfCart);
        modelAndView.setViewName("webapps/AddToCart");
        return modelAndView;

    }
}
