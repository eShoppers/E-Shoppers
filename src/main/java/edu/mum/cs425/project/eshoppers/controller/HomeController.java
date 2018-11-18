package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Catalog;
import edu.mum.cs425.project.eshoppers.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs425.project.eshoppers.domain.User;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

	@Autowired
	CatalogService catalogService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homepage() {
		List<Catalog> catalog = catalogService.findAll();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("cata", catalog);
		modelAndView.setViewName("webapps/index");
		return modelAndView;
	}
}


	
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login() {
//		return "webapps/login";
//	}
//
//	@RequestMapping(value = "/signup", method = RequestMethod.GET)
//	public String signup() {
//		return "webapps/signup";
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String signin(@ModelAttribute(name = "loginForm") User user, Model model) {
//		System.out.println("Userrrrrr" + user);
//		String username = user.getEmail();
//		String password = user.getPassword();
//
//		if ("admin".equals(username) && "admin".equals(password)) {
//			return "webapps/index";
//		}
//		model.addAttribute("invalidCredentials", true);
//		return "webapps/login";
//	}
//
//	@RequestMapping(value = "/signup", method = RequestMethod.POST)
//	public String signup(@ModelAttribute(name = "signup") User user, Model model) {
//		System.out.println("Userrrrrr" + user);
//		return "webapps/login";
//	}
//

