package edu.mum.cs425.project.eshoppers.controller;


import edu.mum.cs425.project.eshoppers.domain.Cart;
import edu.mum.cs425.project.eshoppers.domain.Customer;
import edu.mum.cs425.project.eshoppers.domain.User;
import edu.mum.cs425.project.eshoppers.service.CartService;
import edu.mum.cs425.project.eshoppers.service.CatalogService;
import edu.mum.cs425.project.eshoppers.service.CustomerService;
import edu.mum.cs425.project.eshoppers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class LoginController {
    public static Customer currentUser;

    @Autowired
    UserService userService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CartService cartService;

    @Autowired
    CatalogService catalogService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView getLoginform(Model model) {
        ModelAndView modelAndView = new ModelAndView();
               modelAndView.addObject("user", new User());
               modelAndView.setViewName("webapps/login");
                     return modelAndView;
    }


    //    // checking for login credentials
    @RequestMapping(value ="/login" ,method=RequestMethod.POST)
    public ModelAndView loginSuccess(@Valid @ModelAttribute("user") User user,BindingResult bindingResult,@RequestParam("email") String email,
                                      @RequestParam("password") String password){
        if(bindingResult.hasErrors()){
                  System.out.println("errors");
               return new ModelAndView("webapps/login");

        }

        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user.getPassword());
          if(userService.findUserByEmailAndPassword(email,password)!=null){
              Customer customer= customerService.findCustomerByEmail(email);
              currentUser=customer;
              List<Cart> carts = cartService.findCartByCustomer_Cid(currentUser.getCid());
//              List<Catalog> catalog = catalogService.findAll();
//
//              modelAndView.addObject("cata", catalog);
              modelAndView.addObject("LengthCart",carts.size());
              modelAndView.addObject("customer", customer);
              modelAndView.setViewName("/webapps/index");

             return modelAndView;

        }else{
            bindingResult.rejectValue("email", "error.user",
                    "invalid email");
            bindingResult.rejectValue("password", "error.user",
                    "invalid password");
              modelAndView.setViewName("webapps/login");


        }
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String  logout() {
        currentUser = null;
        return "redirect:/";
    }


}





