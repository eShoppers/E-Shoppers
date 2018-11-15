package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Customer;
import edu.mum.cs425.project.eshoppers.domain.State;
import edu.mum.cs425.project.eshoppers.service.CustomerService;
import edu.mum.cs425.project.eshoppers.service.StateService;
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

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String  signup(Model model){
        model.addAttribute("customer", new Customer());
        List<State> states = stateService.findAll();
        model.addAttribute("states",states);
        return "webapps/signup";
    }

    @RequestMapping(value="/signup", method=RequestMethod.POST)
    public String signup(@Valid @ModelAttribute(name="customer") Customer customer, BindingResult result,
                         @RequestParam String State_option,@RequestParam String gridRadios  ,  Model model) {
        System.out.println("first");
        if (result.hasErrors()) {
            System.out.println("errrorinitial");
            model.addAttribute("errors", result.getAllErrors());
            System.out.println(result.getAllErrors());
            return "webapps/signup";

        }

        customer.setState(State_option);
        System.out.println("out"+gridRadios);
        customer.setGender(gridRadios);
        customer= customerService.save(customer);

        System.out.println("Userrrrrr"+customer);
        return "redirect:/login";
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



