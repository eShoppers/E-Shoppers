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

    @ModelAttribute("products")
    public List<Product> getProducts() {
        // Get cart using empId from DB
        //List<Cart> cart = cartService.findAll();
        List<Product> pros = productService.findAll();
        return  pros;
    }

    @RequestMapping(value="/cart", method = RequestMethod.GET)
    public String cartContent() {
        return "webapps/cart";

    }

    @RequestMapping(value = "/place/order", method = RequestMethod.POST)
    public String placeOrder(@ModelAttribute("products") List<Product> products,
                             BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            System.out.println("error occured");
            return "webapps/addCatalog";
        }

        System.out.println("List of products in cart");
        System.out.println(products);
        int orderid = 100;
        for(Product product: products){
            Date d= new Date();
            Orders order = new Orders();
            order.setProduct(product);
            order.setOrderDate(LocalDate.now());
            order.setQuantity(1L);
            order.setPrice(200.00);
            order.setOrderId("" +  d.getTime());
            System.out.println("successfull" + order);

            ordersService.save(order);

        }


        System.out.println("Order placed successfully");

//        update with correct url
        return "redirect:/";
    }
}
