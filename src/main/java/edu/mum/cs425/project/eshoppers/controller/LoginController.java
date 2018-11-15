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
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginform(Model model) {
        ModelAndView modelAndView = new ModelAndView();
               modelAndView.addObject("user", new User());
               modelAndView.setViewName("webapps/login");
           // model.addAttribute("user", new User());
               return modelAndView;
    }

    //    // checking for login credentials
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handlerLoginRequest(@Valid @ModelAttribute("user") User user, BindingResult result, @RequestParam String username, @RequestParam String password , Model model) {
        boolean found=false;
        System.out.println(username);
        System.out.println(password);
           if(result.hasErrors())
           {

               model.addAttribute("errors", result.getAllErrors());
               System.out.println(result.getAllErrors());
                // return "webapps/login";

           }
             List<User> users= userService.findAll();
             for(User u: users)
             {
                 if(u.getEmail().equals(username)&& u.getPassword().equals(password))
                 {
                       found=true;
                     Customer customer;
                     customer = customerService.findOne(u.getId());
                       System.out.println(u.getId()+customer.getFirstName());

                     break;
                 }
             }
                if(found==true)
            return "webapps/index";
             else{
                 model.addAttribute("user","can not be ");
                 return "webapps/login";
             }
    }




}





