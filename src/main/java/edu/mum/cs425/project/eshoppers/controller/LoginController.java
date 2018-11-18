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
                                      @RequestParam("password") String password){
        if(bindingResult.hasErrors()){
                  System.out.println("errors");
               return new ModelAndView("webapps/login");

        }

        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user.getPassword());
       // if(userService.findByEmail(user.getEmail()).isPresent() || userService.findByPassword(user.getPassword()).isPresent()){
      //  if(userService.findByEmailContainsAndPassword(email,password)!=null){
           if(userService.findUserByEmailAndPassword(email,password)!=null){
            modelAndView.setViewName("/webapps/index");
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

//    @RequestMapping(value= {"/index"}, method=RequestMethod.GET)
//    public ModelAndView home() {
//        ModelAndView model = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByEmail(auth.getName());
//               System.out.println(user);
//      //  model.addObject("userName", user.getFirstname() + " " + user.getLastname());
//        model.setViewName("webapps/index");
//        return model;
//    }
//
//    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
//    public ModelAndView accessDenied() {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("webapps/access_denied");
//        return model;
//    }



}





