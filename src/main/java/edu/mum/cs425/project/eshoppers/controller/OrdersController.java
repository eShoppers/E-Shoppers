package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Cart;
import edu.mum.cs425.project.eshoppers.domain.Orders;
import edu.mum.cs425.project.eshoppers.domain.Product;
import edu.mum.cs425.project.eshoppers.service.OrdersService;
import edu.mum.cs425.project.eshoppers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    ProductService productService;

//    @ModelAttribute("products")
//    public List<Product> getProducts() {
//        // Get cart using empId from DB
//        //List<Cart> cart = cartService.findAll();
//        List<Product> pros = productService.findAll();
//        return  pros;
//    }

//    @RequestMapping(value="/cart", method = RequestMethod.GET)
//    public String cartContent() {
//        return "webapps/cart";
//
//    }

    @RequestMapping(value = "/order/history/{cid}", method = RequestMethod.GET)
    public ModelAndView orderHistory(@PathVariable Long cid) {

        List<Orders> orders = ordersService.findOrdersByCustomer_Cid(cid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("webapps/orderHistory");

        return modelAndView;
    }


}
