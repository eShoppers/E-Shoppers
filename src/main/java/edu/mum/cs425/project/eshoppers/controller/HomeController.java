package edu.mum.cs425.project.eshoppers.controller;

import edu.mum.cs425.project.eshoppers.domain.Catalog;
import edu.mum.cs425.project.eshoppers.service.CatalogService;
import edu.mum.cs425.project.eshoppers.service.UserService;
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
	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homepage(Model model) {
		List<Catalog> catalog = catalogService.findAll();
		ModelAndView modelAndView = new ModelAndView();

//		boolean flag = false;false
		model.addAttribute("flag",true);
//		modelAndView.addObject("flag",flag);
		modelAndView.addObject("cata", catalog);
		modelAndView.setViewName("webapps/index");
		return modelAndView;
	}
}
