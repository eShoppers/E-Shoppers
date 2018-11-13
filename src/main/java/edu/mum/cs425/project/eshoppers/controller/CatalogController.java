package edu.mum.cs425.project.eshoppers.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs425.project.eshoppers.domain.Catalog;
import edu.mum.cs425.project.eshoppers.service.CatalogService;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CatalogController {

	@Autowired
	CatalogService catalogService;

//	@RequestMapping(value = "/addcatalog")
//	public List<Catalog> catalog(@Valid @ModelAttribute("catalog") Catalog catalog,BindingResult result,Model model) {
//		if(result.hasErrors())
//			return null;
//		return catalogService.findAll();
//	}

	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public String create(Model model){
		model.addAttribute("catalog", new Catalog());
		return "webapps/addCatalog";
	}

	@RequestMapping(value = "/catalog", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("catalog") Catalog catalog,
					   BindingResult result, Model model)  {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "webapps/addCatalog";
		}
		catalog = catalogService.save(catalog);

//        update with correct url
		return "redirect:/catalogs";
	}
}
