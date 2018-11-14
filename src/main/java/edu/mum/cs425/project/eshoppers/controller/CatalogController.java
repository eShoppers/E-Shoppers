package edu.mum.cs425.project.eshoppers.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs425.project.eshoppers.domain.Catalog;
import edu.mum.cs425.project.eshoppers.service.CatalogService;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CatalogController {

	@Autowired
	CatalogService catalogService;
	
	@GetMapping(value="/Catalog")
	public String cataloglist() {
		
		return "webapps/Catalog";
	}

	@RequestMapping(value = "/addcatalog", method = RequestMethod.GET)
	public String create(Model model){
		model.addAttribute("catalog", new Catalog());
		return "webapps/addCatalog";
	}

	@RequestMapping(value = "/addcatalog", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("catalog") Catalog catalog,
					   BindingResult result, Model model)  {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			System.out.println("error occured");
			System.out.println(result.toString());
			return "webapps/addCatalog";
		}
		catalog = catalogService.save(catalog);
		System.out.println("successfull" + catalog);
		System.out.println("successfull" + catalog);
//        update with correct url
		return "redirect:/";
	}
	
	
}
