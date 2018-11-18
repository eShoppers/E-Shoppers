package edu.mum.cs425.project.eshoppers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs425.project.eshoppers.domain.User;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String homepages() {
		return "webapps/index";
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
}
