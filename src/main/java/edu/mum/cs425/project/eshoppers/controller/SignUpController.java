package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Customer;
import edu.mum.cs425.project.eshoppers.service.CustomerService;
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
    private CustomerService customerService;
//
//        @RequestMapping(value="/signup", method = RequestMethod.GET)
//    public ModelAndView customers(){
//        List<Customer> customers = customerService.findAll();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("customer", customers);
//        modelAndView.setViewName("signup");
//        return modelAndView;
//    }
//
//    @RequestMapping(value="/signup", method = RequestMethod.GET)
//    public String create(Model model){
//        model.addAttribute("customer", new Customer());
//        return "webapps/signup";
//    }
//
//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public String edit(@Valid @ModelAttribute("customer") Customer customer,
//                       BindingResult result, Model model)  {
//
//        if (result.hasErrors()) {
//            model.addAttribute("errors", result.getAllErrors());
//            return "/home";
//        }
//        customer = customerService.save(customer);
//        return "redirect:/signup";
//    }
//
//    @RequestMapping(value="/student/{id}", method = RequestMethod.GET)
//    public String view(@PathVariable Long id, Model model){
//        model.addAttribute("student", customerService.findOne(id));
//        return "student/edit";
//    }
//
//    @RequestMapping(value="/student/delete/{id}", method = RequestMethod.GET)
//    public String delete(@PathVariable Long id, Model model){
//        customerService.delete(id);
//        return "redirect:/students";
//    }
}



