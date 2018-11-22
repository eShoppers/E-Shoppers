package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Cart;
import edu.mum.cs425.project.eshoppers.domain.Product;
import edu.mum.cs425.project.eshoppers.service.CartService;
import edu.mum.cs425.project.eshoppers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static edu.mum.cs425.project.eshoppers.controller.LoginController.currentUser;

@Controller
public class AddToCartController {

    @Autowired
    ProductService productService;
    @Autowired
    CartService cartService;

    @GetMapping(value = "/AddToCart")
    public ModelAndView AddToCart() {
        ModelAndView modelAndView = new ModelAndView();
        List<Cart> carts = cartService.findCartByCustomer_Cid(currentUser.getCid());
        modelAndView.addObject("carts", carts);
        modelAndView.setViewName("webapps/AddToCart");

        List<Product> products = new ArrayList<>();
        for(Cart c: carts){
            products.add(c.getProduct());
        }
        List<String> productImages = ProductController.recreateImages(products);
        modelAndView.addObject("productImages", productImages );

        return modelAndView;
    }


    @RequestMapping(value = "/AddToCart/{id}", method = RequestMethod.GET)
    public ModelAndView productListCart(@PathVariable Long id) {
           Product product = productService.findOne(id);
             Cart cart = new Cart();
        cart.setCustomer(currentUser);
        cart.setQuantity(1);
        cart.setTotalPrice(product.getUnitPrice());
        cart.setProduct(product);
        cartService.save(cart);
        ModelAndView modelAndView = new ModelAndView();
        List<Cart> carts = cartService.findCartByCustomer_Cid(currentUser.getCid());
        double subtotal=0.0;
        for(Cart c: carts)
        {
            subtotal += c.getTotalPrice();
        }
         modelAndView.addObject("subtotal",subtotal);
         modelAndView.addObject("carts", carts);
        modelAndView.setViewName("webapps/AddToCart");
        return modelAndView;
    }

    @RequestMapping(value = "/AddToCart", method = RequestMethod.POST)
    public ModelAndView updateCart() {
        ModelAndView modelAndView = new ModelAndView();
        //  modelAndView.addObject("product", product);
        modelAndView.setViewName("webapps/AddToCart");
        return modelAndView;

    }

    @RequestMapping(value = "/AddToCart/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id,Model model) {
        System.out.println(id);
        cartService.delete(id);
        return "redirect:/AddToCart";


    }

    @RequestMapping(value = "/calculate/{totalPrice}/{unitPrice}/{id}", method = RequestMethod.GET)
    public ModelAndView caluclate(@PathVariable double totalPrice,
                                  @PathVariable double unitPrice, @PathVariable Long id)//@PathVariable double unitPrice,@PathVariable int quantity
    {
        System.out.println(totalPrice + " " + unitPrice + "" + id);
        Cart cart = new Cart();
        cart = cartService.findCartById(id);
        cart.setTotalPrice(totalPrice * unitPrice);
        cartService.save(cart);
        ModelAndView modelAndView = new ModelAndView();
        List<Cart> carts = cartService.findCartByCustomer_Cid(currentUser.getCid());
               modelAndView.addObject("carts", carts);
        modelAndView.setViewName("webapps/AddToCart");
        return modelAndView;
    }
}






