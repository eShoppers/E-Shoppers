package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Customer;
import edu.mum.cs425.project.eshoppers.domain.State;
import edu.mum.cs425.project.eshoppers.domain.User;
import edu.mum.cs425.project.eshoppers.service.CustomerService;
import edu.mum.cs425.project.eshoppers.service.StateService;
import edu.mum.cs425.project.eshoppers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SignUpController {
    @Autowired
    CustomerService customerService;
    @Autowired
    StateService stateService;
    @Autowired
    UserService userService;
    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String  signup(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("user",new User());
        List<State> states = stateService.findAll();
        model.addAttribute("states",states);
        return "webapps/signup";
    }

    @RequestMapping(value="/signup", method=RequestMethod.POST)
    public ModelAndView signup(@Valid User user,BindingResult resultUser, @Valid Customer customer, BindingResult result,
                               @RequestParam String State_option, @RequestParam String gridRadios,@RequestParam String role) {
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            resultUser
                    .rejectValue("email", "error.customer",
                            "There is already a user registered with the email provided");
            System.out.println("error");
        }
            ModelAndView modelAndView = new ModelAndView();
            if (resultUser.hasErrors() || result.hasErrors()) {
                modelAndView.addObject("errorMessage","There is already a user registered with the email provided");
                modelAndView.setViewName("/webapps/signup");

            } else {
                customer.setRole(role);
                customer.setState(State_option);
                customer.setGender(gridRadios);
                customer=customerService.save(customer);

                modelAndView.addObject("successMessage", "User has been registered successfully");
                modelAndView.addObject("customer", new Customer());
                modelAndView.setViewName("/webapps/signup");
            }
            return modelAndView;
        }
    @RequestMapping(value="/signup/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model){
        model.addAttribute("customer", customerService.findOne(id));
        return "webapps/signup";
    }
    @RequestMapping(value="/EditProfile/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model){
        customerService.delete(id);
        return "redirect:/index";
    }

}



