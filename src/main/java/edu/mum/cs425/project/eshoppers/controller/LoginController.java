package edu.mum.cs425.project.eshoppers.controller;


import edu.mum.cs425.project.eshoppers.domain.Customer;
import edu.mum.cs425.project.eshoppers.domain.User;
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
    @Autowired
    UserService userService;
    @Autowired
    CustomerService customerService;
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
                                      @RequestParam("password") String password,Model model){
        if(bindingResult.hasErrors()){
                  System.out.println("errors");
               return new ModelAndView("webapps/login");

        }

        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user.getPassword());
          if(userService.findUserByEmailAndPassword(email,password)!=null){
              Customer name= customerService.findCustomerByEmail(email);
              modelAndView.setViewName("/webapps/index");
              model.addAttribute("name" ,name.getFirstName());
            modelAndView.addObject("user", user);
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


}





