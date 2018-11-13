package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Customer;
import edu.mum.cs425.project.eshoppers.domain.User;
import edu.mum.cs425.project.eshoppers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    CustomerService customerService;
    @RequestMapping(value="/login", method= RequestMethod.GET )
    public String login() {
        return "webapps/login";
    }


    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String signin(@ModelAttribute(name="loginForm") User user, Model model) {
        System.out.println("Userrrrrr"+user);
        String username = user.getEmail();
        String password = user.getPassword();

        if("admin".equals(username) && "admin".equals(password)) {
            return "webapps/index";
        }
        model.addAttribute("invalidCredentials",true);
        return "webapps/login";
    }


//    @RequestMapping(value="/signup", method=RequestMethod.GET )
//    public String signup() {
//        return "webapps/signup"; }

    @RequestMapping(value="/signup", method = RequestMethod.GET)
   public String signup(Model model){
        model.addAttribute("customer", new Customer());
        return "webapps/signup";
   }

    @RequestMapping(value="/signup", method=RequestMethod.POST)
    public String signup(@Valid @ModelAttribute(name="customer") Customer customer, BindingResult result, Model model) {
                System.out.println("first");
        if (result.hasErrors()) {
            System.out.println("errrorinitial");
            model.addAttribute("errors", result.getAllErrors());
            System.out.println(result.getObjectName()+result.getErrorCount());
            return "webapps/signup";

        }

         customerService.save(customer);
        System.out.println("Userrrrrr"+customer);
        return "redirect:/login";
    }
}
